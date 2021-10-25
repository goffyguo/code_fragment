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
    * 用户实名认证结果表
    */
@Data
public class ExchangeUserRealNameAuthenticationResult implements Serializable {
    private Integer id;

    private Integer userId;

    private String phoneNumber;

    /**
     * 用户OCR信息（关联exchange_user_certificates_ocr_info主键id）
     */
    private Integer certificatesId;

    /**
     * 第三方认证流水号
     */
    private String orderId;

    /**
     * 实名认证结果（1匹配，2不匹配）
     */
    private Byte result;

    /**
     * 认证时间
     */
    private Date authenticationTime;

    private static final long serialVersionUID = 1L;
}