package dockingthirdpart;

import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: GuoFei
 * @Date: 2021/10/22/15:24
 * @Description:
 */
@Data
public class IdOcrVerifyResultDTO {

    /**
     * 姓名
     */
    private String realname;
    /**
     * 性别
     */
    private String sex;
    /**
     * 民族
     */
    private String nation;
    /**
     * 出生日期
     */
    private String born;
    /**
     * 地址
     */
    private String address;
    /**
     * 身份证号
     */
    private String idcard;
    /**
     * 正面
     */
    private String side;
    /**
     * 本次查询流水号
     */
    private String orderid;
}
