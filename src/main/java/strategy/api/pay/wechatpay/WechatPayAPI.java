package strategy.api.pay.wechatpay;

import org.springframework.stereotype.Service;
import strategy.PayPlatformEnum;
import strategy.api.IPayAPI;
import strategy.dto.PayNotifyDTO;
import strategy.dto.PayOrderInfoDTO;
import strategy.exception.PayServiceException;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: GuoFei
 * @Date: 2022/02/24/15:17
 * @Description:
 */
@Service
public class WechatPayAPI implements IPayAPI {
    /**
     * 获取对接平台
     *
     * @return
     */
    @Override
    public PayPlatformEnum getPayPlatform() {
        return null;
    }

    /**
     * 请求支付
     *
     * @param payOrderInfoDTO
     * @return
     */
    @Override
    public Object prepareOrder(PayOrderInfoDTO payOrderInfoDTO) throws PayServiceException {
        return null;
    }

    /**
     * 支付回调
     *
     * @param payNotifyDTO
     */
    @Override
    public void parsingPayResult(PayNotifyDTO payNotifyDTO) {

    }

    /**
     * 退款回调
     *
     * @param notifyInfo
     */
    @Override
    public void parsingRefundResult(Object notifyInfo) {

    }

    /**
     * 转化配置文件
     *
     * @param payOrderInfoDTO
     */
    @Override
    public void convertConfig(PayOrderInfoDTO payOrderInfoDTO) {

    }
}
