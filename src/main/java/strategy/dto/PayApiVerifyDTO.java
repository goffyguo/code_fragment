package strategy.dto;

import javax.validation.constraints.NotBlank;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: GuoFei
 * @Date: 2022/02/24/14:16
 * @Description:
 */
public class PayApiVerifyDTO {

    /**
     * 商户编号
     */
    @NotBlank(message = "商户号不能为空")
    private String mchId;

    /**
     * 请求使用的编码格式，如utf-8
     */
    @NotBlank(message = "编码不能为空")
    private String charset;

    /**
     * 商户生成签名字符串所使用的签名算法类型，目前支持SHA1
     */
    @NotBlank(message = "加密算法不能为空")
    private String signType;

    /**
     * 发送请求的时间，格式"yyyy-MM-dd HH:mm:ss"
     */
    @NotBlank(message = "请求时间不能为空")
    private String timestamp;

    /**
     * 六位随机数（数字类型）
     */
    @NotBlank(message = "随机数不能为空")
    private String nonce;

    /**
     * 调用的接口版本，固定为：1.0
     */
    @NotBlank(message = "接口版本不能为空")
    private String version;

    /**
     * 商户请求参数的签名串
     */
    @NotBlank(message = "sign 不能为空")
    private String sign;

    /**
     * 业务参数最大长度不限，除公共参数外所有请求参数都必须放在这个参数中传递
     */
    @NotBlank(message = "bizContent 不能为空")
    private String bizContent;

    public String getMchId() {
        return mchId;
    }

    public void setMchId(String mchId) {
        this.mchId = mchId;
    }

    public String getCharset() {
        return charset;
    }

    public void setCharset(String charset) {
        this.charset = charset;
    }

    public String getSignType() {
        return signType;
    }

    public void setSignType(String signType) {
        this.signType = signType;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getNonce() {
        return nonce;
    }

    public void setNonce(String nonce) {
        this.nonce = nonce;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getBizContent() {
        return bizContent;
    }

    public void setBizContent(String bizContent) {
        this.bizContent = bizContent;
    }

    @Override
    public String toString() {
        return "PayApiVerifyDTO{" +
                "mchId='" + mchId + '\'' +
                ", charset='" + charset + '\'' +
                ", signType='" + signType + '\'' +
                ", timestamp='" + timestamp + '\'' +
                ", nonce='" + nonce + '\'' +
                ", version='" + version + '\'' +
                ", sign='" + sign + '\'' +
                ", bizContent='" + bizContent + '\'' +
                '}';
    }
}
