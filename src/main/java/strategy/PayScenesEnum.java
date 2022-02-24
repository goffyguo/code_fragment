package strategy;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: GuoFei
 * @Date: 2022/02/24/15:03
 * @Description:
 */
public enum PayScenesEnum {

    AGGREGATE_PAY( "AGGREGATE_PAY", "聚合支付"),

    PC_PAY("PC_PAY", "扫码支付"),

    WECHAT_JS_PAY( "WECHAT_JS_PAY", "微信公众号支付"),

    APP_PAY( "APP_PAY", "APP支付"),

    H5_PAY( "H5_PAY", "H5支付"),

    ALIPAY_LIFE_PAY( "ALIPAY_LIFE_PAY", "支付宝生活号支付"),

    WECHAT_MINI_PAY( "WECHAT_MINI_PAY", "微信小程序支付"),

    ALIPAY_MINI_PAY( "ALIPAY_MINI_PAY", "支付宝小程序支付"),

    UNCONSCIOUS_PAY( "UNCONSCIOUS_PAY", "无感支付");

    /**
     * code值
     */
    private final String code;

    /**
     * 说明
     */
    private final String message;

    PayScenesEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public static PayScenesEnum getEnum(String code){
        for (PayScenesEnum ABCPayStatusEnum : values()) {
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
