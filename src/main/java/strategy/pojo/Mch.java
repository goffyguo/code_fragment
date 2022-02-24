package strategy.pojo;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: GuoFei
 * @Date: 2022/02/24/14:34
 * @Description:
 */
public class Mch {
    private Integer id;

    /**
     * 商户编号
     */
    private String mchId;

    /**
     * 商户名称
     */
    private String mchName;

    /**
     * 密钥
     */
    private String secret;

    /**
     * 商户级别
     */
    private Integer level;

    /**
     * 父级商户id
     */
    private Integer pid;

    /**
     * 商户主体
     */
    private String mchSubject;

    /**
     * 营业执照图片地址
     */
    private String businessLicenseUrl;

    /**
     * 联系人姓名
     */
    private String contactName;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 分账比例 最大100
     */
    private Integer profitsharingScale;

    /**
     * 手续费比例
     */
    private BigDecimal serviceAmountScale;

    /**
     * 手续费类型，1：初始金额，2：收入金额
     */
    private Integer serviceAmountType;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 接收账户商户编号
     */
    private String receiverMchId;

    /**
     * 版本
     */
    private Integer version;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMchId() {
        return mchId;
    }

    public void setMchId(String mchId) {
        this.mchId = mchId == null ? null : mchId.trim();
    }

    public String getMchName() {
        return mchName;
    }

    public void setMchName(String mchName) {
        this.mchName = mchName == null ? null : mchName.trim();
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret == null ? null : secret.trim();
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getMchSubject() {
        return mchSubject;
    }

    public void setMchSubject(String mchSubject) {
        this.mchSubject = mchSubject == null ? null : mchSubject.trim();
    }

    public String getBusinessLicenseUrl() {
        return businessLicenseUrl;
    }

    public void setBusinessLicenseUrl(String businessLicenseUrl) {
        this.businessLicenseUrl = businessLicenseUrl == null ? null : businessLicenseUrl.trim();
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName == null ? null : contactName.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public Integer getProfitsharingScale() {
        return profitsharingScale;
    }

    public void setProfitsharingScale(Integer profitsharingScale) {
        this.profitsharingScale = profitsharingScale;
    }

    public BigDecimal getServiceAmountScale() {
        return serviceAmountScale;
    }

    public void setServiceAmountScale(BigDecimal serviceAmountScale) {
        this.serviceAmountScale = serviceAmountScale;
    }

    public Integer getServiceAmountType() {
        return serviceAmountType;
    }

    public void setServiceAmountType(Integer serviceAmountType) {
        this.serviceAmountType = serviceAmountType;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getReceiverMchId() {
        return receiverMchId;
    }

    public void setReceiverMchId(String receiverMchId) {
        this.receiverMchId = receiverMchId == null ? null : receiverMchId.trim();
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "Mch{" +
                "id=" + id +
                ", mchId='" + mchId + '\'' +
                ", mchName='" + mchName + '\'' +
                ", secret='" + secret + '\'' +
                ", level=" + level +
                ", pid=" + pid +
                ", mchSubject='" + mchSubject + '\'' +
                ", businessLicenseUrl='" + businessLicenseUrl + '\'' +
                ", contactName='" + contactName + '\'' +
                ", phone='" + phone + '\'' +
                ", profitsharingScale=" + profitsharingScale +
                ", serviceAmountScale=" + serviceAmountScale +
                ", serviceAmountType=" + serviceAmountType +
                ", status=" + status +
                ", receiverMchId='" + receiverMchId + '\'' +
                ", version=" + version +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
