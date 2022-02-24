package strategy.api.pay.alipay;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import strategy.api.pay.alipay.sdk.AlipayClient;

import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: GuoFei
 * @Date: 2022/02/24/15:09
 * @Description:
 */
public class AliMchConfigCache {

    private static Cache<String, AlipayClient> cache = Caffeine.newBuilder()
            .maximumSize(1000)
            .expireAfterWrite(30, TimeUnit.MILLISECONDS)
            .softValues()
            .build();

    public static void put(String key, AlipayClient alipayClient){
        cache.put(key, alipayClient);
    }

    public static AlipayClient get(String key){
        return cache.getIfPresent(key);
    }

    public static long getSize(){
        return cache.estimatedSize();
    }

    public static ConcurrentMap<String, AlipayClient> asMap(){
        return cache.asMap();
    }
}
