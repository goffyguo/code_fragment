package strategy;

import strategy.api.IPayAPI;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: GuoFei
 * @Date: 2022/02/24/14:26
 * @Description: 存储对接平台 API
 */
public class PayPlatformApiFactory {

    private static Map<String, IPayAPI> map = new ConcurrentHashMap<>();

    public IPayAPI get(PayPlatformEnum payPlatformEnum){
        return map.get(payPlatformEnum.getCode());
    }

    public IPayAPI put(PayPlatformEnum payPlatformEnum, IPayAPI iPayAPI ){
        return map.putIfAbsent(payPlatformEnum.getCode(), iPayAPI);
    }

    public boolean containsKey(PayPlatformEnum payPlatformEnum){
        return map.containsKey(payPlatformEnum.getCode());
    }
}
