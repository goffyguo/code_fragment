package strategy.util;

import org.apache.commons.codec.digest.DigestUtils;
import strategy.dto.PayApiVerifyDTO;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: GuoFei
 * @Date: 2022/02/24/14:43
 * @Description:
 */
public class PayEncryptUtil {
    public static boolean verify(PayApiVerifyDTO payApiVerifyDTO, String secret){
        TreeMap<String, Object> params = new TreeMap<>();
        params.put("mchId", payApiVerifyDTO.getMchId());
        params.put("charset", payApiVerifyDTO.getCharset());
        params.put("signType", payApiVerifyDTO.getSignType());
        params.put("timestamp", payApiVerifyDTO.getTimestamp());
        params.put("nonce", payApiVerifyDTO.getNonce());
        params.put("version", payApiVerifyDTO.getVersion());
        params.put("sign", payApiVerifyDTO.getSign());
        params.put("bizContent", payApiVerifyDTO.getBizContent());
        String sign = signatureGeneration(params, secret);
        if (sign.equals(payApiVerifyDTO.getSign())){
            return true;
        }
        return false;
    }
    /**
     * 生成签名
     * @param paramMap
     * @param clientSecret
     * @return
     */
    public static String signatureGeneration(TreeMap<String, Object> paramMap, String clientSecret) {
        //参数有可能在header，参数有可能在url上，参数有可能在body json体
        TreeMap<String, Object> tree = new TreeMap<>(paramMap);
        // 去除请求中的签名
        tree.remove("sign");
        tree.put("secret", clientSecret);
        StringBuffer str = new StringBuffer();
        tree.forEach((key,value) -> Optional.ofNullable(value).filter(v -> v != null).map(v -> str.append(key).append("=").append(v)));
        return DigestUtils.sha1Hex(str.toString().toLowerCase());
    }

    /**
     * 添加验证参数生成签名
     * @param data
     * @param mchId
     * @param secret
     * @return
     */
    public static Map<String, Object> addGeneratedSignature(Map data, String mchId, String secret){
        DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        TreeMap<String, Object> params = new TreeMap<>(data);
        params.put("mchId", mchId);
        params.put("charset", "UTF-8");
        params.put("signType", "SHA1");
        params.put("timestamp", dtf2.format(LocalDateTime.now()));
        params.put("nonce", "123456");
        params.put("version", "1.0");
        String sign = signatureGeneration(params, secret);
        params.put("sign", sign);
        return params;
    }
}
