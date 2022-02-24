package strategy.api.pay.alipay;

import com.alibaba.fastjson.JSONObject;
import org.springframework.util.CollectionUtils;
import strategy.MchLevelEnum;
import strategy.PayResponseBOEnum;
import strategy.api.pay.alipay.sdk.AlipayClient;
import strategy.api.pay.alipay.sdk.AlipayTradeCreateRequest;
import strategy.api.pay.alipay.sdk.AlipayTradeCreateResponse;
import strategy.dto.PayOrderInfoDTO;
import strategy.dto.PayProfitSharingDTO;
import strategy.exception.PayServiceException;

import java.math.BigDecimal;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: GuoFei
 * @Date: 2022/02/24/15:04
 * @Description:
 */
public class AliPayUtil {

    /**
     * 支付宝小程序支付
     * 二级商户就是服务商支付  一级是普通支付
     * @param payOrderInfoDTO
     * @return
     * @throws PayServiceException
     */
    public static AliPayMiniResultDTO aliMiniPay(PayOrderInfoDTO payOrderInfoDTO) throws PayServiceException {
        boolean isSp = false;
        if (payOrderInfoDTO.getMchLevelEnum() == MchLevelEnum.SECOND_MCH) {
            isSp = true;
        }
        if (isSp) {
            AliPayMchConfigDTO mchConfig = null;
            if (payOrderInfoDTO.getProfitSharingStatus()) {
                if (CollectionUtils.isEmpty(payOrderInfoDTO.getPayProfitSharingDTOList())) {
                    throw new PayServiceException(PayResponseBOEnum.ERROR_04119);
                }
                PayProfitSharingDTO payProfitSharingDTO = payOrderInfoDTO.getPayProfitSharingDTOList().get(0);
                mchConfig = (AliPayMchConfigDTO) payProfitSharingDTO.getMchConfig();
            } else {
                throw new PayServiceException(PayResponseBOEnum.ERROR_04119);
            }

            mchConfig.setAppId(mchConfig.getMiniAppId());
            mchConfig.setAlipayPublicKey(mchConfig.getMiniAlipayPublicKey());
            mchConfig.setPrivateKey(mchConfig.getMiniPrivateKey());

            // 实例化客户端
            AlipayClient alipayClient = getAlipayClient(mchConfig);
            AlipayTradeCreateRequest request = new AlipayTradeCreateRequest();
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("out_trade_no", payOrderInfoDTO.getTradeNo());
            jsonObject.put("total_amount", payOrderInfoDTO.getTotalOrderAmount().multiply(new BigDecimal(100)).intValue());
            jsonObject.put("subject", payOrderInfoDTO.getDescription());
            jsonObject.put("buyer_id", payOrderInfoDTO.getUserId());
            request.setBizContent(jsonObject.toJSONString());
            AlipayTradeCreateResponse response = null;
            try {
                response = alipayClient.execute(request);
                if (response.isSuccess()) {
                    AliPayMiniResultDTO aliPayMiniResultDTO = new AliPayMiniResultDTO();
                    aliPayMiniResultDTO.setInfo(response.getBody());
                    aliPayMiniResultDTO.setTradeNo(response.getTradeNo());
                    aliPayMiniResultDTO.setOutTradeNo(response.getOutTradeNo());
                    return aliPayMiniResultDTO;
                } else {
                    throw new PayServiceException(PayResponseBOEnum.ERROR_05000);
                }
            } catch (Exception e) {
                //logger.error("[alipay] 统一下单失败 ，error->{}", e);
                throw new PayServiceException(PayResponseBOEnum.ERROR_04020);
            }
        } else {
            AliPayMchConfigDTO aliPayMchConfigDTO = (AliPayMchConfigDTO) payOrderInfoDTO.getMchConfig();

            aliPayMchConfigDTO.setAppId(aliPayMchConfigDTO.getMiniAppId());
            aliPayMchConfigDTO.setAlipayPublicKey(aliPayMchConfigDTO.getMiniAlipayPublicKey());
            aliPayMchConfigDTO.setPrivateKey(aliPayMchConfigDTO.getMiniPrivateKey());

            AlipayClient alipayClient = getAlipayClient(aliPayMchConfigDTO);
            AlipayTradeCreateRequest request = new AlipayTradeCreateRequest();
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("out_trade_no", payOrderInfoDTO.getTradeNo());
            jsonObject.put("total_amount", payOrderInfoDTO.getTotalOrderAmount().multiply(new BigDecimal(100)).intValue());
            jsonObject.put("subject", payOrderInfoDTO.getDescription());
            jsonObject.put("buyer_id", payOrderInfoDTO.getUserId());
            request.setBizContent(jsonObject.toJSONString());
            AlipayTradeCreateResponse response = null;
            try {
                response = alipayClient.execute(request);
                if (response.isSuccess()) {
                    AliPayMiniResultDTO aliPayMiniResultDTO = new AliPayMiniResultDTO();
                    aliPayMiniResultDTO.setInfo(response.getBody());
                    aliPayMiniResultDTO.setTradeNo(response.getTradeNo());
                    aliPayMiniResultDTO.setOutTradeNo(response.getOutTradeNo());
                    return aliPayMiniResultDTO;
                } else {
                    //logger.error("[alipay] 统一下单失败 ，SubMsg->{},", response.getSubMsg());
                    throw new PayServiceException(PayResponseBOEnum.ERROR_05000);
                }
            } catch (Exception e) {
                //logger.error("[alipay] 统一下单失败 ，error->{}", e);
                throw new PayServiceException(PayResponseBOEnum.ERROR_04020);
            }
        }
    }
    private static AlipayClient getAlipayClient(AliPayMchConfigDTO aliPayMchConfigDTO){
        AlipayClient alipayClient = AliMchConfigCache.get(aliPayMchConfigDTO.getAppId());
        if (alipayClient == null){
            /*alipayClient = new DefaultAlipayClient(
                    aliPayMchConfigDTO.getServerUrl(),
                    aliPayMchConfigDTO.getAppId(),
                    aliPayMchConfigDTO.getPrivateKey(),
                    aliPayMchConfigDTO.getFormat(),
                    aliPayMchConfigDTO.getCharset(),
                    aliPayMchConfigDTO.getAlipayPublicKey(),
                    aliPayMchConfigDTO.getSignType());*/
            AliMchConfigCache.put(aliPayMchConfigDTO.getAppId(), alipayClient);
        }
        return alipayClient;
    }
}

