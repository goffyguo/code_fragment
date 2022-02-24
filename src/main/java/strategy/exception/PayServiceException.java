package strategy.exception;

import strategy.PayResponseBOEnum;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: GuoFei
 * @Date: 2022/02/24/14:35
 * @Description:
 */
public class PayServiceException extends Exception {
    private PayResponseBOEnum payResponseBOEnum;

    public PayServiceException(PayResponseBOEnum payResponseBOEnum) {
        super(payResponseBOEnum.getMessage());
        this.payResponseBOEnum = payResponseBOEnum;
    }

    public PayResponseBOEnum getPayResponseBOEnum() {
        return payResponseBOEnum;
    }

    public void setPayResponseBOEnum(PayResponseBOEnum payResponseBOEnum) {
        this.payResponseBOEnum = payResponseBOEnum;
    }
}
