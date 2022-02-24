package strategy.service;

import strategy.dto.PayApiVerifyDTO;
import strategy.dto.PayNotifyDTO;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: GuoFei
 * @Date: 2022/02/24/14:17
 * @Description:
 */
public interface PayService {
    Map preparePay(PayApiVerifyDTO payApiVerifyDTO) throws Exception;

    Map queryOrder(PayApiVerifyDTO payApiVerifyDTO) throws Exception;

    Map payNotify(PayNotifyDTO payNotifyDTO) throws Exception;

    Map refund(PayApiVerifyDTO payApiVerifyDTO) throws Exception;

    Map queryRefundOrder(PayApiVerifyDTO payApiVerifyDTO) throws Exception;
}
