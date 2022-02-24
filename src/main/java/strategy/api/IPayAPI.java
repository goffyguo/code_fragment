package strategy.api;

import strategy.PayPlatformEnum;
import strategy.dto.PayNotifyDTO;
import strategy.dto.PayOrderInfoDTO;
import strategy.dto.QueryOrderInfoDTO;
import strategy.exception.PayServiceException;
import strategy.util.OrderNoUtil;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: GuoFei
 * @Date: 2022/02/24/14:26
 * @Description:
 */
public interface IPayAPI<R>{

    /**
     * 获取对接平台
     * @return
     */
    PayPlatformEnum getPayPlatform();

    /**
     * 请求支付
     *
     * @param payOrderInfoDTO
     * @return
     */
    R prepareOrder(PayOrderInfoDTO payOrderInfoDTO) throws PayServiceException;

    /**
     * 支付回调
     *
     * @param payNotifyDTO
     */
    void parsingPayResult(PayNotifyDTO payNotifyDTO);

    /**
     * 请求退款
     *
     * @param refundOrderInfoDTO
     */
    //void refundOrder(RefundOrderInfoDTO refundOrderInfoDTO) throws PayServiceException;

    /**
     * 退款回调
     * @param notifyInfo
     */
    void parsingRefundResult(Object notifyInfo);

    /**
     * 转化配置文件
     * @param payOrderInfoDTO
     */
    void convertConfig(PayOrderInfoDTO payOrderInfoDTO);

    /**
     * 查询订单详情
     * @param queryOrderInfoDTO
     * @return
     */
    //PlatformOrderInfoDTO queryOrderInfo(QueryOrderInfoDTO queryOrderInfoDTO) throws PayServiceException;

    /**
     * 交易号默认生成规则，各个支付方式可以自定义
     * @return
     */
    default String generateTradeNo(){
        return OrderNoUtil.generateOrderNo("01");
    }
}
