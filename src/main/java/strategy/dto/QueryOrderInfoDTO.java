package strategy.dto;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: GuoFei
 * @Date: 2022/02/24/14:27
 * @Description:
 */
public class QueryOrderInfoDTO {
    /**
     * 商户订单号
     */
    private String tradeNo;

    /**
     * 订单号
     */
    private String orderNo;

    /**
     * 商户编号
     */
    private String mchId;

    /**
     * 商户配置
     */
    private String mchConfigString;

    /**
     * 商户配置
     */
    private Object mchConfig;


    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
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

    public Object getMchConfig() {
        return mchConfig;
    }

    public void setMchConfig(Object mchConfig) {
        this.mchConfig = mchConfig;
    }

    @Override
    public String toString() {
        return "QueryOrderInfoDTO{" +
                "tradeNo='" + tradeNo + '\'' +
                ", orderNo='" + orderNo + '\'' +
                ", mchId='" + mchId + '\'' +
                ", mchConfigString='" + mchConfigString + '\'' +
                ", mchConfig=" + mchConfig +
                '}';
    }
}
