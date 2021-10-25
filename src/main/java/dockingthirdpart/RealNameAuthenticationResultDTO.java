package dockingthirdpart;

import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: GuoFei
 * @Date: 2021/10/25/10:59
 * @Description: 用户实名认证结果DTO
 */
@Data
public class RealNameAuthenticationResultDTO {

    /**
     * 真实姓名
     */
    private String realname;
    /**
     * 身份证号码
     */
    private String idcard;
    /**
     * 流水号
     */
    private String orderid;
    /**
     * 结果（1匹配，2不匹配）
     */
    private Byte res;
}
