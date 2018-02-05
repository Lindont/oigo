package com.aos.oigo.ehcache;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @Cacheable
 * value：    缓存位置名称，不能为空，如果使用EHCache，就是ehcache.xml中声明的cache的name
 * key：      缓存的key，默认为空，既表示使用方法的参数类型及参数值作为key，支持SpEL
 * condition：触发条件，只有满足条件的情况才会加入缓存，默认为空，既表示全部都加入缓存，支持SpEL
 */


@Service
public class EhCacheTestServiceImpl implements EhCacheTestService {

    @Cacheable(value = "cacheTest", key = "#param")
    public String getTimestamp(String param) {
        Long timestamp = System.currentTimeMillis();
        return timestamp.toString();
    }

}