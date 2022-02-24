package strategy;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: GuoFei
 * @Date: 2022/02/24/15:02
 * @Description:
 */
public enum PayChannelEnum {

    ABC( "ABC", "农业银行"),

    WECHAT("WECHAT", "微信"),
    NONGXIN("NONGXIN", "浙江农信"),

    ALIPAY( "ALIPAY", "支付宝");

    /**
     * code值
     */
    private final String code;

    /**
     * 说明
     */
    private final String message;

    PayChannelEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public static PayChannelEnum getEnum(String code){
        for (PayChannelEnum ABCPayStatusEnum : values()) {
            if (ABCPayStatusEnum.getCode().equals(code)) {
                return ABCPayStatusEnum;
            }
        }
        return null;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
