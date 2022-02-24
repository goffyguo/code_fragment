package strategy;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import strategy.dto.PayApiVerifyDTO;
import strategy.service.PayService;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: GuoFei
 * @Date: 2022/02/24/14:14
 * @Description: 支付 controller
 */
@RestController
@RequestMapping("/pay")
public class PayController {


    @Resource
    private PayService orderPayService;

    /**
     * 请求支付
     * @param payApiVerifyDTO
     * @return
     * @throws Exception
     */
    @PostMapping("/preparePay")
    public String preparePay(@Validated @RequestBody PayApiVerifyDTO payApiVerifyDTO) throws Exception {
        Map map = orderPayService.preparePay(payApiVerifyDTO);
        return map.toString();
    }

    /**
     * 查询订单
     * @param payApiVerifyDTO
     * @return
     * @throws Exception
     */
    @PostMapping("/queryOrder")
    public String queryOrder(@RequestBody PayApiVerifyDTO payApiVerifyDTO) throws Exception {
        Map map = orderPayService.queryOrder(payApiVerifyDTO);
        return map.toString();
    }

    /**
     * 退款
     * @param payApiVerifyDTO
     * @return
     * @throws Exception
     */
    @PostMapping("/refund")
    public String refund(@RequestBody PayApiVerifyDTO payApiVerifyDTO) throws Exception {
        Map map = orderPayService.refund(payApiVerifyDTO);
        return map.toString();
    }

    /**
     * 查询订单
     * @param payApiVerifyDTO
     * @return
     * @throws Exception
     */
    @PostMapping("/queryRefundOrder")
    public String queryRefundOrder(@RequestBody PayApiVerifyDTO payApiVerifyDTO) throws Exception {
        Map map = orderPayService.queryRefundOrder(payApiVerifyDTO);
        return map.toString();
    }
}
