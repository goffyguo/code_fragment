package strategy.dto;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: GuoFei
 * @Date: 2022/02/24/14:28
 * @Description:
 */
public class PreparePayDTO {
    /**
     * 商户订单号
     * 64
     * 是
     */
    private String outOrderNo;

    /**
     * 应用编号
     * 16
     * 是
     */
    private String applicationId;

    /**
     * 金额（单位：分）
     * 11
     * 是
     */
    private Integer amount;

    /**
     * 货币类型，CNY:人民币
     * 10
     * 是
     */
    private String currency;

    /**
     * 订单时间，格式"yyyy-MM-dd HH:mm:ss"
     * 19
     * 是
     */
    private String orderDate;

    /**
     * 商品描述
     * 100
     * 是
     */
    private String description;

    /**
     * 支付回调地址（服务器回调）
     * 256
     * 是
     */
    private String notifyUrl;

    /**
     * 页面回调地址
     * 256
     * 否
     */
    private String returnUrl;

    /**
     * 附加信息，回调时附带
     * 128
     * 否
     */
    private String attach;

    /**
     * 支付用户，交易类型为“线下静态一码多付”时必输，输入客户的支付宝userid；交易类型为"公众号（小程序）支付"时必输，对应微信统一下单接口中的sub_openid
     * 32
     * 否
     */
    private String userId;

    /**
     * 支付授权码，交易类型为"刷卡支付"时必输，输入客户支付宝的授权码auth_code；交易类型为"微信付款码支付"时必输，输入扫码支付付款码，设备读取用户微信中的条码或者二维码信息
     * 32
     * 否
     */
    private String authCode;

    /**
     * 支付终端ip
     * 16
     * 否
     */
    private String payerClientIp;

    /**
     * 订单说明
     * 100
     * 否
     */
    private String orderDesc;

    /**
     * 对接平台
     * 20
     * 是
     */
    private String payPlatform;

    /**
     * 支付渠道
     * 20
     * 是
     */
    private String payChannel;

    /**
     * 支付场景
     * 20
     * 是
     */
    private String payScenes;

    /**
     * PC扫码支付方式
     * 2
     * 否
     */
    private String pcQrPayMode;

    /**
     * 自定义二维码宽度
     * 4
     * 否
     */
    private String pcQrCodeWidth;

    /**
     * wap支付中途退出返回网址
     * 256
     * 否
     */
    private String wapQuitUrl;

    /**
     * h5场景信息-场景类型
     * 45
     * 否
     */
    private String h5InfoType;

    /**
     * 应用名称
     * 64
     * 否
     */
    private String h5InfoAppName;

    /**
     * 网站url
     * 128
     * 否
     */
    private String h5InfoAppUrl;

    /**
     * ios平台BundleID
     * 128
     * 否
     */
    private String h5InfoBundleId;

    /**
     * android平台PackageName
     * 128
     * 否
     */
    private String h5InfoPackageName;

    public String getOutOrderNo() {
        return outOrderNo;
    }

    public void setOutOrderNo(String outOrderNo) {
        this.outOrderNo = outOrderNo;
    }

    public String getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }

    public String getReturnUrl() {
        return returnUrl;
    }

    public void setReturnUrl(String returnUrl) {
        this.returnUrl = returnUrl;
    }

    public String getAttach() {
        return attach;
    }

    public void setAttach(String attach) {
        this.attach = attach;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAuthCode() {
        return authCode;
    }

    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }

    public String getPayerClientIp() {
        return payerClientIp;
    }

    public void setPayerClientIp(String payerClientIp) {
        this.payerClientIp = payerClientIp;
    }

    public String getOrderDesc() {
        return orderDesc;
    }

    public void setOrderDesc(String orderDesc) {
        this.orderDesc = orderDesc;
    }

    public String getPayPlatform() {
        return payPlatform;
    }

    public void setPayPlatform(String payPlatform) {
        this.payPlatform = payPlatform;
    }

    public String getPayChannel() {
        return payChannel;
    }

    public void setPayChannel(String payChannel) {
        this.payChannel = payChannel;
    }

    public String getPayScenes() {
        return payScenes;
    }

    public void setPayScenes(String payScenes) {
        this.payScenes = payScenes;
    }

    public String getPcQrPayMode() {
        return pcQrPayMode;
    }

    public void setPcQrPayMode(String pcQrPayMode) {
        this.pcQrPayMode = pcQrPayMode;
    }

    public String getPcQrCodeWidth() {
        return pcQrCodeWidth;
    }

    public void setPcQrCodeWidth(String pcQrCodeWidth) {
        this.pcQrCodeWidth = pcQrCodeWidth;
    }

    public String getWapQuitUrl() {
        return wapQuitUrl;
    }

    public void setWapQuitUrl(String wapQuitUrl) {
        this.wapQuitUrl = wapQuitUrl;
    }

    public String getH5InfoType() {
        return h5InfoType;
    }

    public void setH5InfoType(String h5InfoType) {
        this.h5InfoType = h5InfoType;
    }

    public String getH5InfoAppName() {
        return h5InfoAppName;
    }

    public void setH5InfoAppName(String h5InfoAppName) {
        this.h5InfoAppName = h5InfoAppName;
    }

    public String getH5InfoAppUrl() {
        return h5InfoAppUrl;
    }

    public void setH5InfoAppUrl(String h5InfoAppUrl) {
        this.h5InfoAppUrl = h5InfoAppUrl;
    }

    public String getH5InfoBundleId() {
        return h5InfoBundleId;
    }

    public void setH5InfoBundleId(String h5InfoBundleId) {
        this.h5InfoBundleId = h5InfoBundleId;
    }

    public String getH5InfoPackageName() {
        return h5InfoPackageName;
    }

    public void setH5InfoPackageName(String h5InfoPackageName) {
        this.h5InfoPackageName = h5InfoPackageName;
    }

    @Override
    public String toString() {
        return "PreparePayDTO{" +
                "outOrderNo='" + outOrderNo + '\'' +
                ", applicationId='" + applicationId + '\'' +
                ", amount=" + amount +
                ", currency='" + currency + '\'' +
                ", orderDate='" + orderDate + '\'' +
                ", description='" + description + '\'' +
                ", notifyUrl='" + notifyUrl + '\'' +
                ", returnUrl='" + returnUrl + '\'' +
                ", attach='" + attach + '\'' +
                ", userId='" + userId + '\'' +
                ", authCode='" + authCode + '\'' +
                ", payerClientIp='" + payerClientIp + '\'' +
                ", orderDesc='" + orderDesc + '\'' +
                ", payPlatform='" + payPlatform + '\'' +
                ", payChannel='" + payChannel + '\'' +
                ", payScenes='" + payScenes + '\'' +
                ", pcQrPayMode='" + pcQrPayMode + '\'' +
                ", pcQrCodeWidth='" + pcQrCodeWidth + '\'' +
                ", wapQuitUrl='" + wapQuitUrl + '\'' +
                ", h5InfoType='" + h5InfoType + '\'' +
                ", h5InfoAppName='" + h5InfoAppName + '\'' +
                ", h5InfoAppUrl='" + h5InfoAppUrl + '\'' +
                ", h5InfoBundleId='" + h5InfoBundleId + '\'' +
                ", h5InfoPackageName='" + h5InfoPackageName + '\'' +
                '}';
    }
}
