package strategy.api.pay.alipay.sdk;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: GuoFei
 * @Date: 2022/02/24/15:13
 * @Description: SDK自带，需要引入
 */
public class AlipayTradeCreateRequest {

    private String bizContent;

    public String getBizContent() {
        return bizContent;
    }

    public void setBizContent(String bizContent) {
        this.bizContent = bizContent;
    }
}
