package strategy.dto;

import java.math.BigDecimal;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: GuoFei
 * @Date: 2022/02/24/14:31
 * @Description: 分账状态
 */
public class PayProfitSharingDTO {
    /**
     * 分账商户号
     */
    private String mchId;

    /**
     * 该商户分账金额
     */
    private BigDecimal payProfitSharingOrderAmount;

    /**
     * 商户配置
     */
    private String mchConfigString;

    /**
     * 商户配置
     */
    private Object mchConfig;



    public String getMchId() {
        return mchId;
    }

    public void setMchId(String mchId) {
        this.mchId = mchId;
    }

    public BigDecimal getPayProfitSharingOrderAmount() {
        return payProfitSharingOrderAmount;
    }

    public void setPayProfitSharingOrderAmount(BigDecimal payProfitSharingOrderAmount) {
        this.payProfitSharingOrderAmount = payProfitSharingOrderAmount;
    }

    public String getMchConfigString() {
        return mchConfigString;
    }

    public void setMchConfigString(String mchConfigString) {
        this.mchConfigString = mchConfigString;
    }

    public Object getMchConfig() {
        return mchConfig;
    }

    public void setMchConfig(Object mchConfig) {
        this.mchConfig = mchConfig;
    }

    @Override
    public String toString() {
        return "PayProfitSharingDTO{" +
                "mchId='" + mchId + '\'' +
                ", payProfitSharingOrderAmount=" + payProfitSharingOrderAmount +
                ", mchConfigString='" + mchConfigString + '\'' +
                ", mchConfig=" + mchConfig +
                '}';
    }
}
