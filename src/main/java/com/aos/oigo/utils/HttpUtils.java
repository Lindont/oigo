package com.aos.oigo.utils;

import com.alibaba.fastjson.JSON;
import org.apache.http.*;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.LayeredConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;

import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.UnsupportedEncodingException;
import java.net.UnknownHostException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

/**
 * @Author : HuangHaoXin
 * @Description :HTTP 工具类
 * @Date : Create in 2017-08-24
 */

public class HttpUtils
{
    public static final int GET = 0;
    public static final int POST = 1;
    public static final int PUT = 2;
    public static final int DELETE = 3;

    private static ExecutorService httpExcutor;//线程池

    static
    {
        httpExcutor = Executors.newCachedThreadPool();
    }

    public HttpUtils()
    {
    }

    /**
     * 同步访问URL
     *
     * @param url        链接
     * @param headers    头部
     * @param jsonObject post的json
     * @param method     访问方法
     * @return
     */
    public static String getResultEntity(String url, Map<String, String> headers, Object jsonObject, int method)
    {
        if (jsonObject instanceof String)
        {
            jsonObject = JSON.parseObject((String) jsonObject);
        }
        try
        {
            return (String) connect(url, headers, (JSON) jsonObject, false, method, false, true, null);
        } catch (ClientProtocolException e)
        {
            e.printStackTrace();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 异步访问URL
     *
     * @param url
     * @param headers
     * @param jsonObject
     * @param method
     * @param callBack
     * @return
     */
    public static String getResultEntityAsyn(String url, Map<String, String> headers, Object jsonObject, int method, HttpCallBack callBack)
    {
        if (jsonObject instanceof String)
        {
            jsonObject = JSON.parseObject((String) jsonObject);
        }
        try
        {
            return (String) connect(url, headers, (JSON) jsonObject, false, method, false, false, callBack);
        } catch (ClientProtocolException e)
        {
            e.printStackTrace();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    public static int getResultStatus(String url, Map<String, String> headers, JSON jsonObject, int method, boolean getRightNow, HttpCallBack callBack)
    {
        Integer status = 0;
        try
        {
            status = (Integer) connect(url, headers, (JSON) jsonObject, false, method, true, getRightNow, callBack);
        } catch (ClientProtocolException e)
        {
            e.printStackTrace();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        return status == null ? 0 : status;
    }

    /**
     * 同步提交表单
     *
     * @param url
     * @param headers
     * @param pairs
     * @param method
     * @return
     */
    public static String getResultEntityByFormData(String url, Map<String, String> headers, List<NameValuePair> pairs, int method)
    {
        try
        {
            return (String) connect(url, headers, pairs, true, method, false, true, null);
        } catch (ClientProtocolException e)
        {
            e.printStackTrace();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 异步提交表单
     *
     * @param url
     * @param headers
     * @param pairs
     * @param method
     * @param callBack
     * @return
     */
    public static String getResultEntityByFormDataAsyn(String url, Map<String, String> headers, List<NameValuePair> pairs, int method, HttpCallBack callBack)
    {
        try
        {
            return (String) connect(url, headers, pairs, true, method, false, false, callBack);
        } catch (ClientProtocolException e)
        {
            e.printStackTrace();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        return null;
    }


    private static HttpResponse getResponseData(int method, String url, Map<String, String> headers, Object body, boolean isFormData, HttpCallBack callBack)
    {
        HttpResponse response = null;
        try
        {
            HttpClient client = HttpClientBuilder.create().build();
            // HttpClient client = PoolConnectManager.gethttpClient();
            switch (method)
            {
                case HttpUtils.GET:
                    response = client.execute(doGet(url, headers));
                    break;
                case HttpUtils.POST:
                    response = client.execute(doPost(url, headers, body, isFormData));
                    break;
                case HttpUtils.PUT:
                    response = client.execute(doPut(url, headers, body));
                    break;
                case HttpUtils.DELETE:
                    response = client.execute(doDelete(url, headers));
                    break;
                default:
                    return null;
            }
        } catch (IOException e)
        {
            if (callBack != null)
                callBack.onException(e);
            e.printStackTrace();
        }
        return response;
    }

    /**
     * connect
     * @param url
     * @param headers
     * @param entity
     * @param isFormData
     * @param method
     * @param isGetCode
     * @param getImmedetaly
     * @param callBack
     * @return
     * @throws ClientProtocolException
     * @throws IOException
     */
    @SuppressWarnings("unchecked")
    private static Object connect(final String url,
                                  final Map<String, String> headers,
                                  final Object entity,
                                  final boolean isFormData,
                                  final int method,
                                  final boolean isGetCode,
                                  boolean getImmedetaly,
                                  final HttpCallBack callBack) throws ClientProtocolException, IOException
    {

        FutureTask<Object> task = new FutureTask<Object>(new Callable<Object>()
        {
            @Override
            public Object call() throws Exception
            {
                HttpResponse response = getResponseData(method, url, headers, entity, isFormData, callBack);
                HttpEntity entity = response.getEntity();
                String result = EntityUtils.toString(entity);
                if (isGetCode)
                {
                    int code = response.getStatusLine().getStatusCode();
                    if (callBack != null)
                        callBack.resultCallBack(code);
                    return code;
                }
                if (callBack != null)
                {
                    callBack.resultCallBack(result);//返回实体
                }
                return result;
            }
        });

        httpExcutor.execute(task);
        if (getImmedetaly)
        {//如果需要阻塞获取结果
            try
            {
                return task.get();
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            } catch (ExecutionException e)
            {
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * doPost
     * @param url
     * @param headers
     * @param body
     * @param isFormData
     * @return
     */
    private static HttpPost doPost(String url, Map<String, String> headers, Object body, boolean isFormData)
    {
        HttpPost post = new HttpPost(url);
        if (headers != null)
        {
            for (Map.Entry<String, String> entry : headers.entrySet())
            {
                post.addHeader(entry.getKey(), entry.getValue());
            }
        }
        if (body == null)
            return post;
        if (isFormData)
        {
            try
            {
                post.setEntity(new UrlEncodedFormEntity((List<? extends NameValuePair>) body, "utf-8"));
            } catch (UnsupportedEncodingException e)
            {
                e.printStackTrace();
            }
        } else
        {
            StringEntity entity = new StringEntity(((JSON) body).toJSONString(), "UTF-8");
            post.setEntity(entity);
        }
        return post;
    }

    /**
     * doGet
     * @param url
     * @param headers
     * @return
     */
    private static HttpGet doGet(String url, Map<String, String> headers)
    {
        HttpGet get = new HttpGet(url);
        if (headers != null)
        {
            for (Map.Entry<String, String> entry : headers.entrySet())
            {
                get.addHeader(entry.getKey(), entry.getValue());
            }
        }
        return get;
    }

    /**
     * doDelete
     * @param url
     * @param headers
     * @return
     */
    private static HttpDelete doDelete(String url, Map<String, String> headers)
    {
        HttpDelete delete = new HttpDelete(url);
        if (headers != null)
        {
            for (Map.Entry<String, String> entry : headers.entrySet())
            {
                delete.addHeader(entry.getKey(), entry.getValue());
            }
        }
        return delete;
    }

    /**
     * doPut
     * @param url
     * @param headers
     * @param body
     * @return
     */
    private static HttpPut doPut(String url, Map<String, String> headers, Object body)
    {
        HttpPut put = new HttpPut(url);
        if (headers != null)
        {
            for (Map.Entry<String, String> entry : headers.entrySet())
            {
                put.addHeader(entry.getKey(), entry.getValue());
            }
        }
        StringEntity entity = null;
        try
        {
            entity = new StringEntity(((JSON) body).toJSONString());
        } catch (UnsupportedEncodingException e)
        {
            e.printStackTrace();
        }
        put.setEntity(entity);
        return put;
    }


    /**
     * 连接池
     */
    static class PoolConnectManager
    {
        private static PoolingHttpClientConnectionManager cm;
        private static HttpRequestRetryHandler httpRequestRetryHandler;

        static
        {
            ConnectionSocketFactory plainsf = PlainConnectionSocketFactory.getSocketFactory();
            LayeredConnectionSocketFactory sslsf = SSLConnectionSocketFactory.getSocketFactory();
            Registry<ConnectionSocketFactory> registry = RegistryBuilder.<ConnectionSocketFactory>create()
                    .register("http", plainsf)
                    .register("https", sslsf)
                    .build();
            cm = new PoolingHttpClientConnectionManager(registry);
            // 将最大连接数增加到200
            cm.setMaxTotal(200);
            // 将每个路由基础的连接增加到20
            cm.setDefaultMaxPerRoute(20);
            // 将目标主机的最大连接数增加到50
        /*HttpHost localhost = new HttpHost("https://a1.easemob.com/");
        cm.setMaxPerRoute(new HttpRoute(localhost), 50);*/
            //请求重试处理
            httpRequestRetryHandler = new HttpRequestRetryHandler()
            {
                public boolean retryRequest(IOException exception, int executionCount, HttpContext context)
                {
                    if (executionCount >= 5)
                    {// 如果已经重试了5次，就放弃
                        return false;
                    }
                    if (exception instanceof NoHttpResponseException)
                    {// 如果服务器丢掉了连接，那么就重试
                        return true;
                    }
                    if (exception instanceof SSLHandshakeException)
                    {// 不要重试SSL握手异常
                        return false;
                    }
                    if (exception instanceof InterruptedIOException)
                    {// 超时
                        return false;
                    }
                    if (exception instanceof UnknownHostException)
                    {// 目标服务器不可达
                        return false;
                    }
                    if (exception instanceof ConnectTimeoutException)
                    {// 连接被拒绝
                        return false;
                    }
                    if (exception instanceof SSLException)
                    {// ssl握手异常
                        return false;
                    }

                    HttpClientContext clientContext = HttpClientContext.adapt(context);
                    HttpRequest request = clientContext.getRequest();
                    // 如果请求是幂等的，就再次尝试
                    if (!(request instanceof HttpEntityEnclosingRequest))
                    {
                        return true;
                    }
                    return false;
                }
            };
        }

        public static CloseableHttpClient gethttpClient()
        {
            CloseableHttpClient httpClient = HttpClients.custom()
                    .setConnectionManager(cm)
                    .setRetryHandler(httpRequestRetryHandler)
                    .build();

            return httpClient;
        }
    }


    /**
     * 异步回调
     */
    public interface HttpCallBack<T>
    {
        <T> void resultCallBack(T result);

        void onException(Exception e);
    }
}
