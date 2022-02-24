package dockingthirdpart;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * @Author: GuoFei
 * @Date: 2021/10/25/11:54
 * @Description: 
 */

/**
    * 用户身份OCR信息表
 * @author guogoffy
 */
@Data
public class ExchangeUserCertificatesOcrInfo implements Serializable {
    private Integer id;

    private Integer userId;

    private String phoneNumber;

    private String userName;

    /**
     * 国籍
     */
    private String nationality;

    /**
     * 证件类型（0身份证）
     */
    private Byte certificatesType;

    /**
     * 证件号码
     */
    private String certificatesNumber;

    /**
     * 性别（0男，1女）
     */
    private Byte sex;

    /**
     * 民族
     */
    private String nation;

    /**
     * 出生日期
     */
    private String born;

    private String address;

    /**
     * 第三方查询返回流水号
     */
    private String orderId;

    private Date createTime;

    private Date updateTime;

    /**
     * 证件图像（正面）
     */
    private String certificatesImagsFront;

    /**
     * 证件图像（背面）
     */
    private String certificatesImagsBack;

    private static final long serialVersionUID = 1L;
}