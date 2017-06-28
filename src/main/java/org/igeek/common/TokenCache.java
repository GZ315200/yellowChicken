package org.igeek.common;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * Created by Gyges on 2017/5/30.
 * 用于token缓存 guava 缓存
 */
public class TokenCache {

    private static Logger logger = LoggerFactory.getLogger(TokenCache.class);

    public static String TOKEN_PROFIX = "token_";

    private static LoadingCache<String,String> tokenCache = CacheBuilder.newBuilder()
            .maximumSize(10000) //最大存储大小
            .initialCapacity(1000) //初始容量
            .expireAfterAccess(12, TimeUnit.HOURS) //过期时间12小时
            .build(new CacheLoader<String, String>() {
//                调用时如果key没有对应值调用此方法
                @Override
                public String load(String key) throws Exception {
                    return "null";
                }
            });

    /**
     * 设置 key-value
     * @param key
     * @param value
     */
    public static void setKey(String key,String value){
        tokenCache.put(key,value);
    }

    /**
     * 获得value
     * @param key
     * @return
     */
    public static String getValue(String key){
        String value = null;
        try {
           value =  tokenCache.get(key);
            if ("null".equals(value)){
                return null;
            }
            return value;
        } catch (ExecutionException e) {
            logger.error("localCache get Error",e);
            e.printStackTrace();
        }
        return null;
    }

}
