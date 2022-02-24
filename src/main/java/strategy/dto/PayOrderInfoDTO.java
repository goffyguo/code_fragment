package strategy.dto;

import strategy.MchLevelEnum;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: GuoFei
 * @Date: 2022/02/24/14:28
 * @Description:
 */
public class PayOrderInfoDTO {
    /**
     * 请求单号
     */
    private String tradeNo;


    /**
     * 商户号
     */
    private String mchId;

    /**
     * 订单号
     */
    private String orderNo;

    /**
     * 总订单金额 （单位：元）
     */
    private BigDecimal totalOrderAmount;

    /**
     * 是否拆分账单
     */
    private Boolean profitSharingStatus;

    /**
     * 分账商户
     */
    private List<PayProfitSharingDTO> payProfitSharingDTOList;


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


    /**
     * 商户配置
     */
    private String mchConfigString;

    /**
     * 商户配置
     */
    private Object mchConfig;

    /**
     * 商户级别
     */
    private MchLevelEnum mchLevelEnum;

    /**
     * 请求参数
     */
    private PreparePayDTO preparePayDTO;

    /**
     * 记录实际请求支付mchId
     */
    private String preparePayMchId;

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

    public BigDecimal getTotalOrderAmount() {
        return totalOrderAmount;
    }

    public void setTotalOrderAmount(BigDecimal totalOrderAmount) {
        this.totalOrderAmount = totalOrderAmount;
    }

    public Boolean getProfitSharingStatus() {
        return profitSharingStatus;
    }

    public void setProfitSharingStatus(Boolean profitSharingStatus) {
        this.profitSharingStatus = profitSharingStatus;
    }

    public List<PayProfitSharingDTO> getPayProfitSharingDTOList() {
        return payProfitSharingDTOList;
    }

    public void setPayProfitSharingDTOList(List<PayProfitSharingDTO> payProfitSharingDTOList) {
        this.payProfitSharingDTOList = payProfitSharingDTOList;
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

    public String getMchConfigString() {
        return mchConfigString;
    }

    public void setMchConfigString(String mchConfigString) {
        this.mchConfigString = mchConfigString;
    }

    public MchLevelEnum getMchLevelEnum() {
        return mchLevelEnum;
    }

    public void setMchLevelEnum(MchLevelEnum mchLevelEnum) {
        this.mchLevelEnum = mchLevelEnum;
    }

    public Object getMchConfig() {
        return mchConfig;
    }

    public void setMchConfig(Object mchConfig) {
        this.mchConfig = mchConfig;
    }

    public String getMchId() {
        return mchId;
    }

    public void setMchId(String mchId) {
        this.mchId = mchId;
    }

    public PreparePayDTO getPreparePayDTO() {
        return preparePayDTO;
    }

    public void setPreparePayDTO(PreparePayDTO preparePayDTO) {
        this.preparePayDTO = preparePayDTO;
    }

    public String getPreparePayMchId() {
        return preparePayMchId;
    }

    public void setPreparePayMchId(String preparePayMchId) {
        this.preparePayMchId = preparePayMchId;
    }

    @Override
    public String toString() {
        return "PayOrderInfoDTO{" +
                "tradeNo='" + tradeNo + '\'' +
                ", mchId='" + mchId + '\'' +
                ", orderNo='" + orderNo + '\'' +
                ", totalOrderAmount=" + totalOrderAmount +
                ", profitSharingStatus=" + profitSharingStatus +
                ", payProfitSharingDTOList=" + payProfitSharingDTOList +
                ", description='" + description + '\'' +
                ", notifyUrl='" + notifyUrl + '\'' +
                ", returnUrl='" + returnUrl + '\'' +
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
                ", mchConfigString='" + mchConfigString + '\'' +
                ", mchConfig=" + mchConfig +
                ", mchLevelEnum=" + mchLevelEnum +
                ", preparePayDTO=" + preparePayDTO +
                ", preparePayMchId='" + preparePayMchId + '\'' +
                '}';
    }
}
