package strategy.api.pay.alipay;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import strategy.PayChannelEnum;
import strategy.PayPlatformEnum;
import strategy.PayResponseBOEnum;
import strategy.PayScenesEnum;
import strategy.api.IPayAPI;
import strategy.dto.PayNotifyDTO;
import strategy.dto.PayOrderInfoDTO;
import strategy.exception.PayServiceException;
import strategy.util.JsonUtil;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: GuoFei
 * @Date: 2022/02/24/15:00
 * @Description:
 */
@Service
public class AlipayAPI implements IPayAPI {

    @Value("${alipay.notifyUrl}")
    private String notifyUrl;
    /**
     * 获取对接平台
     *
     * @return
     */
    @Override
    public PayPlatformEnum getPayPlatform() {
        return PayPlatformEnum.ALIPAY;
    }

    /**
     * 请求支付
     *
     * @param payOrderInfoDTO
     * @return
     */
    @Override
    public Object prepareOrder(PayOrderInfoDTO payOrderInfoDTO) throws PayServiceException {

        System.out.println("[AliPay],prepareOrder,payOrderInfoDTO->{}"+ JsonUtil.toJson(payOrderInfoDTO));

        this.convertConfig(payOrderInfoDTO);
        PayChannelEnum payChannelEnum = PayChannelEnum.getEnum(payOrderInfoDTO.getPayChannel());
        payOrderInfoDTO.setNotifyUrl(notifyUrl);
        if (payChannelEnum !=PayChannelEnum.ALIPAY){
            throw  new PayServiceException(PayResponseBOEnum.ERROR_04009);
        }
        return ALIPAYPay(payOrderInfoDTO);
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

    /**
     * 判断支付宝支付场景
     * @param payOrderInfoDTO
     * @return
     */
    private static Object ALIPAYPay(PayOrderInfoDTO payOrderInfoDTO) throws PayServiceException {
        PayScenesEnum anEnum = PayScenesEnum.getEnum(payOrderInfoDTO.getPayScenes());
        switch (anEnum) {
            case ALIPAY_LIFE_PAY:
            case ALIPAY_MINI_PAY:
                try {
                    return AliPayUtil.aliMiniPay(payOrderInfoDTO);
                } catch (PayServiceException e) {
                    //logger.error("[alipay] 支付宝异常",e);
                    throw new PayServiceException(PayResponseBOEnum.ERROR_05000);
                }
            /*case APP_PAY:
                try {
                    return AliPayUtil.aliAPPPay(payOrderInfoDTO);
                } catch (PayServiceException e) {
                    //logger.error("[alipay] 支付宝异常",e);
                    throw new PayServiceException(PayResponseBOEnum.ERROR_05000);
                }
            case H5_PAY:
                try {
                    return AliPayUtil.aliH5Pay(payOrderInfoDTO);
                } catch (PayServiceException e) {
                    // logger.error("[alipay] 支付宝异常",e);
                    throw new PayServiceException(PayResponseBOEnum.ERROR_05000);
                }*/
        }
        return null;
    }
}
