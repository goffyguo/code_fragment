package strategy.handle;

import strategy.dto.PayApiVerifyDTO;
import strategy.dto.PayOrderInfoDTO;
import strategy.dto.PreparePayDTO;
import strategy.exception.PayServiceException;
import strategy.pojo.Mch;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: GuoFei
 * @Date: 2022/02/24/14:33
 * @Description: 交易订单处理
 */
public interface PayOrderHandle {

    PayOrderInfoDTO createOrder(Mch mch1, PreparePayDTO preparePayDTO, String tradeNo, boolean isSave) throws PayServiceException;

    //Map<String, Object> queryOrder(Mch mch1, QueryOrderDTO queryOrderDTO) throws PayServiceException;

    //void payResult(PayResultDTO payResultDTO) throws PayServiceException;

    PreparePayDTO preparePayVerify(Mch mch, PayApiVerifyDTO payApiVerifyDTO) throws PayServiceException;



    boolean testVerify(PayApiVerifyDTO payApiVerifyDTO);
}
