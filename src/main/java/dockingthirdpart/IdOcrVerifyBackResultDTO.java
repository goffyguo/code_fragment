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
public class IdOcrVerifyBackResultDTO {

    /**
     * 签发日期
     */
    private String begin;
    /**
     * 签发机关
     */
    private String department;
    /**
     * 失效日期
     */
    private String end;
    /**
     * 背面
     */
    private String side;
    /**
     * 本次查询流水号
     */
    private String orderid;
}
