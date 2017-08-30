package com.aos.oigo.utils;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class WeiXinUtil
{
    /**
     * 发送请求到微信 : 带数据
     *
     * @param urlString
     * @param method
     * @param body
     * @return
     * @throws IOException
     */
    public static String httpsConn(String urlString, String method, String body) throws IOException
    {
        StringBuffer stringBuffer = new StringBuffer();
        HttpURLConnection conn;
        URL url;
        int code;

        try
        {
            url = new URL(urlString);
            conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setDoInput(true);
            if (method.equals("POST"))
            {
                conn.setRequestMethod("POST");
                conn.setUseCaches(false);
                conn.setInstanceFollowRedirects(true);
                conn.setRequestProperty("Content-Type", "text/html;charset=utf-8");
                conn.connect();
                DataOutputStream out = new DataOutputStream(conn.getOutputStream());
                byte[] data = body.getBytes("utf-8");
                out.write(data, 0, data.length);
                out.flush();
                out.close();
            } else if (method.equals("FILE"))
            {
                String filepath = body;
                String contentType = "";
                String media = "", filename = "";
                String BOUNDARY = "---------------------------123821742118716";
                conn.setConnectTimeout(5000);
                conn.setReadTimeout(30000);
                conn.setUseCaches(false);
                conn.setRequestMethod("POST");
                conn.setRequestProperty("Connection", "Keep-Alive");
                conn.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + BOUNDARY);
                OutputStream out = new DataOutputStream(conn.getOutputStream());
                File file = new File(filepath);
                StringBuffer strBuf = new StringBuffer();
                strBuf.append("\r\n").append("--").append(BOUNDARY).append("\r\n");
                strBuf.append("Content-Disposition: form-data; name=\"" + media + "\"; filename=\"" + filename + "\"\r\n");
                strBuf.append("Content-Type:" + contentType + "\r\n\r\n");
                out.write(strBuf.toString().getBytes());
                DataInputStream in = new DataInputStream(new FileInputStream(file));
                int bytes = 0;
                byte[] bufferOut = new byte[1024 * 4];
                while ((bytes = in.read(bufferOut)) != -1)
                {
                    out.write(bufferOut, 0, bytes);
                }
                in.close();

                byte[] endData = ("\r\n--" + BOUNDARY + "--\r\n").getBytes();
                out.write(endData);
                out.flush();
                out.close();
            } else
            {
                conn.setRequestMethod("GET");
            }
            code = conn.getResponseCode();
            // System.out.println("code:"+code);
        } catch (Exception e)
        {
            e.printStackTrace();
            // System.out.println(e.getMessage());
            return null;
        }
        if (code == HttpURLConnection.HTTP_OK)
        {
            String strCurrentLine;
            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            while ((strCurrentLine = reader.readLine()) != null)
            {

                // String s1=new String(strCurrentLine.getBytes(),"UTF-8");
                // String s2=new String(s1.getBytes("GBK"));
                // System.out.println(s2);
                stringBuffer.append(strCurrentLine).append("\n");
            }

            reader.close();
        }
        conn.disconnect();
        // System.out.println(new String(new
        // String(stringBuffer.toString().getBytes(),"UTF-8").getBytes("GBK")));
        return stringBuffer.toString();
    }


    /**
     * 发送请求到微信 : 不带数据
     *
     * @param urlString
     * @param method
     * @return
     */
    public static String httpConn(String urlString, String method)
    {
        StringBuffer stringBuffer = new StringBuffer();
        HttpURLConnection httpConnection;
        URL url;
        int code;
        try
        {
            url = new URL(urlString);
            httpConnection = (HttpURLConnection) url.openConnection();
            httpConnection.setRequestMethod(method);
            httpConnection.setDoOutput(true);
            httpConnection.setDoInput(true);

            code = httpConnection.getResponseCode();
        } catch (Exception e)
        {
            return null;
        }
        if (code == HttpURLConnection.HTTP_OK)
        {
            try
            {
                String strCurrentLine;
                BufferedReader reader = new BufferedReader(new InputStreamReader(httpConnection.getInputStream()));
                while ((strCurrentLine = reader.readLine()) != null)
                {
                    stringBuffer.append(strCurrentLine).append("\n");
                }
                reader.close();
            } catch (IOException e)
            {
                e.printStackTrace();
            }
        }
        return stringBuffer.toString();
    }
}
