package strategy.service;

import org.springframework.stereotype.Service;
import strategy.api.IPayAPI;
import strategy.PayPlatformApiFactory;
import strategy.PayPlatformEnum;
import strategy.dto.PayApiVerifyDTO;
import strategy.dto.PayNotifyDTO;
import strategy.dto.PayOrderInfoDTO;
import strategy.dto.PreparePayDTO;
import strategy.handle.PayOrderHandle;
import strategy.pojo.Mch;
import strategy.util.JsonUtil;
import strategy.util.PayEncryptUtil;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: GuoFei
 * @Date: 2022/02/24/14:21
 * @Description:
 */
@Service
public class PayServiceImpl implements PayService{

    @Resource
    private PayOrderHandle payOrderHandle;

    @Resource
    private PayPlatformApiFactory payPlatformApiFactory;

    @Override
    public Map preparePay(PayApiVerifyDTO payApiVerifyDTO) throws Exception {

        // 校验mch
        Optional<Mch> mch = null;
        String mchId = mch.map(Mch::getMchId).orElse("");
        PreparePayDTO preparePayDTO = payOrderHandle.preparePayVerify(mch.get(), payApiVerifyDTO);

        PayPlatformEnum payPlatformEnum = PayPlatformEnum.getEnum(preparePayDTO.getPayPlatform());
        IPayAPI api = payPlatformApiFactory.get(payPlatformEnum);
        System.out.println("[preparePay]，IPayAPI -> {}"+api.getPayPlatform().getCode());
        PayOrderInfoDTO payOrderInfoDTO = null;

        // 动态订单号生成规则
        String tradeNo = api.generateTradeNo();
        boolean flag = true;
        /*if (preparePayExcludeCreateOrderList.contains(key)){
            flag = false;
        }*/
        payOrderInfoDTO = payOrderHandle.createOrder(mch.get(), preparePayDTO, tradeNo, flag);
        // 添加商户配置
        //mchConfigHandle.setConfig(payOrderInfoDTO);

        // 添加请求参数
        payOrderInfoDTO.setPreparePayMchId(mchId);
        payOrderInfoDTO.setPreparePayDTO(preparePayDTO);
        // 请求支付
        Object result = api.prepareOrder(payOrderInfoDTO);
        System.out.println("[preparePay]，prepareOrder，result-> {}"+ JsonUtil.toJson(result));

        Map<String, Object> map = new HashMap<>(16);
        map.put("outOrderNo", preparePayDTO.getOutOrderNo());
        map.put("applicationId", preparePayDTO.getApplicationId());
        map.put("amount", preparePayDTO.getAmount());
        map.put("currency", preparePayDTO.getCurrency());
        map.put("orderNo", payOrderInfoDTO.getTradeNo());
        map.put("orderDate", preparePayDTO.getOrderDate());
        map.put("thirdOrderNo", null);
        map.put("payPlatform", payOrderInfoDTO.getPayPlatform());
        map.put("payChannel", payOrderInfoDTO.getPayChannel());
        map.put("payScenes", payOrderInfoDTO.getPayScenes());
        map.put("payInfo", JsonUtil.toJson(result));
        return PayEncryptUtil.addGeneratedSignature(map, mchId,
                mch.map(Mch::getSecret).orElse(null));
    }

    @Override
    public Map queryOrder(PayApiVerifyDTO payApiVerifyDTO) throws Exception {
        return null;
    }

    @Override
    public Map payNotify(PayNotifyDTO payNotifyDTO) throws Exception {
        return null;
    }

    @Override
    public Map refund(PayApiVerifyDTO payApiVerifyDTO) throws Exception {
        return null;
    }

    @Override
    public Map queryRefundOrder(PayApiVerifyDTO payApiVerifyDTO) throws Exception {
        return null;
    }
}
