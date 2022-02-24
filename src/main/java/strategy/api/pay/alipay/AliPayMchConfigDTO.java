package strategy.api.pay.alipay;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: GuoFei
 * @Date: 2022/02/24/15:05
 * @Description:
 */
public class AliPayMchConfigDTO {
    private String serverUrl;
    private String appId;
    private String privateKey;
    private String format;
    private String charset;
    private String alipayPublicKey;
    private String signType;

    private String miniAppId;
    private String miniPrivateKey;
    private String miniAlipayPublicKey;
    private String lifeAppId;
    private String lifePrivateKey;
    private String lifeAlipayPublicKey;
    private String h5AppId;
    private String h5PrivateKey;
    private String h5AlipayPublicKey;

    public String getLifeAlipayPublicKey() {
        return lifeAlipayPublicKey;
    }

    public void setLifeAlipayPublicKey(String lifeAlipayPublicKey) {
        this.lifeAlipayPublicKey = lifeAlipayPublicKey;
    }

    public String getH5AppId() {
        return h5AppId;
    }

    public void setH5AppId(String h5AppId) {
        this.h5AppId = h5AppId;
    }

    public String getH5PrivateKey() {
        return h5PrivateKey;
    }

    public void setH5PrivateKey(String h5PrivateKey) {
        this.h5PrivateKey = h5PrivateKey;
    }

    public String getH5AlipayPublicKey() {
        return h5AlipayPublicKey;
    }

    public void setH5AlipayPublicKey(String h5AlipayPublicKey) {
        this.h5AlipayPublicKey = h5AlipayPublicKey;
    }

    public String getMiniPrivateKey() {
        return miniPrivateKey;
    }

    public void setMiniPrivateKey(String miniPrivateKey) {
        this.miniPrivateKey = miniPrivateKey;
    }

    public String getMiniAlipayPublicKey() {
        return miniAlipayPublicKey;
    }

    public void setMiniAlipayPublicKey(String miniAlipayPublicKey) {
        this.miniAlipayPublicKey = miniAlipayPublicKey;
    }

    public String getLifePrivateKey() {
        return lifePrivateKey;
    }

    public void setLifePrivateKey(String lifePrivateKey) {
        this.lifePrivateKey = lifePrivateKey;
    }


    public String getMiniAppId() {
        return miniAppId;
    }

    public void setMiniAppId(String miniAppId) {
        this.miniAppId = miniAppId;
    }

    public String getLifeAppId() {
        return lifeAppId;
    }

    public void setLifeAppId(String lifeAppId) {
        this.lifeAppId = lifeAppId;
    }

    public String getServerUrl() {
        return serverUrl;
    }

    public void setServerUrl(String serverUrl) {
        this.serverUrl = serverUrl;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getCharset() {
        return charset;
    }

    public void setCharset(String charset) {
        this.charset = charset;
    }

    public String getAlipayPublicKey() {
        return alipayPublicKey;
    }

    public void setAlipayPublicKey(String alipayPublicKey) {
        this.alipayPublicKey = alipayPublicKey;
    }

    public String getSignType() {
        return signType;
    }

    public void setSignType(String signType) {
        this.signType = signType;
    }
}
