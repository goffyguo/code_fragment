package strategy;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: GuoFei
 * @Date: 2022/02/24/14:36
 * @Description:
 */
public enum PayResponseBOEnum {
    SUCCESS("00000", "成功"),

    ERROR_04010("04010", "商户号不存在"),

    ERROR_04005("04005", "参数错误"),

    ERROR_05000("05000", "系统异常"),

    ERROR_04009("04009", "商户无权限"),

    ERROR_04002("04002", "商户订单号重复"),

    ERROR_04006("04006", "订单不存在"),

    ERROR_04001("04001", "签名错误"),

    ERROR_04014("04014", "applicationId和mchId不匹配"),

    ERROR_04016("04016", "退款金额等于0"),

    ERROR_04017("04017", "订单无法退款"),

    ERROR_04018("04018", "退款失败"),

    ERROR_04019("04019", "银行处理失败"),

    ERROR_04020("04020", "支付宝处理失败"),

    ERROR_04119("04119", "商户配置错误"),

    ERROR_05001("05001", "银行异常"),

    ERROR_04101("04101", "没有相应配置");


    private String code;

    private String message;

    PayResponseBOEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }
}
