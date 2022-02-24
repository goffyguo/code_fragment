package strategy.dto;

import strategy.PayPlatformEnum;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: GuoFei
 * @Date: 2022/02/24/14:18
 * @Description: 支付回调dto
 */
public class PayNotifyDTO {

    private PayPlatformEnum payPlatformEnum;

    private Object notifyInfo;

    private String orderNo;

    /**
     * 当有不同类型回调时，使用
     */
    private String type;

    private String mchId;

    private String mchConfigString;

    public PayNotifyDTO(PayPlatformEnum payPlatformEnum, Object notifyInfo,
                        String orderNo, String type, String mchId, String mchConfigString) {
        this.payPlatformEnum = payPlatformEnum;
        this.notifyInfo = notifyInfo;
        this.orderNo = orderNo;
        this.type = type;
        this.mchId = mchId;
        this.mchConfigString = mchConfigString;
    }

    public PayPlatformEnum getPayPlatformEnum() {
        return payPlatformEnum;
    }

    public void setPayPlatformEnum(PayPlatformEnum payPlatformEnum) {
        this.payPlatformEnum = payPlatformEnum;
    }

    public Object getNotifyInfo() {
        return notifyInfo;
    }

    public void setNotifyInfo(Object notifyInfo) {
        this.notifyInfo = notifyInfo;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMchId() {
        return mchId;
    }

    public void setMchId(String mchId) {
        this.mchId = mchId;
    }

    public String getMchConfigString() {
        return mchConfigString;
    }

    public void setMchConfigString(String mchConfigString) {
        this.mchConfigString = mchConfigString;
    }

    @Override
    public String toString() {
        return "PayNotifyDTO{" +
                "payPlatformEnum=" + payPlatformEnum +
                ", notifyInfo=" + notifyInfo +
                ", orderNo='" + orderNo + '\'' +
                ", type='" + type + '\'' +
                ", mchId='" + mchId + '\'' +
                ", mchConfigString='" + mchConfigString + '\'' +
                '}';
    }
}

