package com.hry.guava.cache;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

/**
 * 缓存
 *
 *  用法教程：https://segmentfault.com/a/1190000011105644
 *
 * @author: huangrongyou@yixin.im
 * @date: 2019/12/13 10:43
 */
public class GuavaCache {

    public static void main(String[] args) {
        Cache<String,String> cache = CacheBuilder.newBuilder()
                .maximumSize(2)
                .build();
        cache.put("key1","value1");
        cache.put("key2","value2");
        cache.put("key3","value3");
        System.out.println("第一个值：" + cache.getIfPresent("key1"));
        System.out.println("第二个值：" + cache.getIfPresent("key2"));
        System.out.println("第三个值：" + cache.getIfPresent("key3"));

        System.out.println(cache.size());
        System.out.println(cache.stats());
        cache.cleanUp();


    }
}
