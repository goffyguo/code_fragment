package strategy.util;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: GuoFei
 * @Date: 2022/02/24/14:44
 * @Description:
 */
public class JsonUtil {

    private volatile static ObjectMapper objectMapper;

    private JsonUtil() {

    }

    public static ObjectMapper getInstance() {
        if (objectMapper == null) {
            synchronized (JsonUtil.class) {
                if (objectMapper == null) {
                    objectMapper = new ObjectMapper();
                }
            }
        }
        return objectMapper;
    }


    /**
     * 解析json
     *
     * @param content
     * @param valueType
     * @return
     */
    public static <T> T fromJson(String content, Class<T> valueType) {
        try {
            return JsonUtil.getInstance().readValue(content, valueType);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**jackson json转JSONObject
     * 生成json
     *
     * @param object
     * @return
     */
    public static String toJson(Object object) {
        try {
            return JsonUtil.getInstance().writeValueAsString(object);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
