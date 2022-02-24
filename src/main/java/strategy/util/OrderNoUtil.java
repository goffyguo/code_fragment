package strategy.util;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: GuoFei
 * @Date: 2022/02/24/14:55
 * @Description:
 */
public class OrderNoUtil {

    private static AtomicInteger atomicInteger = new AtomicInteger();

    /**
     * 获取自增位
     * @return
     */
    public static int getValue(){
        int newValue = atomicInteger.incrementAndGet();
        if (newValue > 99){
            newValue = atomicInteger.updateAndGet((i) -> i > 99 ? 0 : i);
        }
        return newValue;
    }

    /**
     * 数字转两位
     * @param value
     * @return
     */
    public static String intTo2(int value){
        DecimalFormat df = new DecimalFormat("00");
        return df.format(value);
    }

    /**
     * 校验位池
     */
    private static Map<Integer, Integer> checkMap;

    static {
        checkMap = new HashMap<>(16);
        checkMap.put(0, 67);
        checkMap.put(1, 97);
        checkMap.put(2, 15);
        checkMap.put(3, 45);
        checkMap.put(4, 83);
        checkMap.put(5, 95);
        checkMap.put(6, 34);
        checkMap.put(7, 53);
        checkMap.put(8, 39);
        checkMap.put(9, 71);
        checkMap.put(10, 80);
    }

    // 系数池 分别乘以不同的系数
    private static int[] COEFFICIENT_ARRAY = {7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2 ,9 , 10, 5, 8, 4, 2, 1, 3, 7, 9, 10, 5, 8, 4, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9};

    /**
     * 密码
     */
    private static String KEY = "7536";


    /**
     * 长度
     */
    private static final int LENGTH = 32;


    public static String generateOrderNo(String type) {
        // 标识
        String identifying = "68";
        // 版本
        String version = "01";
        return generateOrderNo(identifying, version, type);
    }

    //标识 2位|版本 2位|类型 2位|时间 17位|随机数 4位|自增数 2位|随机码 1位|校验码 2位
    public static String generateOrderNo(String identifying, String version, String type){
        // 时间
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS");
        LocalDateTime time = LocalDateTime.now();
        String localTime = df.format(time);

        // 随机数
        long randomNumber = Math.round((Math.random()+1) * 1000);

        // 输出字符串
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(identifying);
        stringBuilder.append(version);
        stringBuilder.append(type);
        stringBuilder.append(localTime);
        stringBuilder.append(randomNumber);
        stringBuilder.append(intTo2(getValue()));

        // 插入key字符串
        Integer random = generationRandomNumber(1,9);

        String str = stringBuilder.toString();

        StringBuilder newStringBuilder = new StringBuilder();
        // 把key插入 按照random的顺序
        if (str.toCharArray().length > random){
            int index = 0;
            int location = random;
            for (int i = 0; i < str.toCharArray().length; i++) {
                if (i == location && index < KEY.length()){
                    newStringBuilder.append(KEY.charAt(index));
                    location += random;
                    index ++;
                }
                newStringBuilder.append(str.charAt(i));
            }
        }
        String newStr = newStringBuilder.toString();

        int sum = 0;
        for (int i = 0; i < newStr.length(); i++) {
            // 判断是否是数字
            if (Character.isDigit(newStr.charAt(i))){
                int num = Character.digit(newStr.charAt(i), 10);
                // 2.将这17位数字和系数相乘的结果相加
                sum += num * (i > COEFFICIENT_ARRAY.length ? 1 : COEFFICIENT_ARRAY[i]);
            }
        }

        int mod = sum % 11;

        int check = checkMap.getOrDefault(mod, 01);
        return str + random + check;
    }

    private static int generationRandomNumber (int m, int n) {
        return m + (int) (Math.random() * (n + 1 - m));
    }

    //标识 2位|版本 2位|类型 2位|时间 17位|随机数 4位|自增数 2位|随机码 1位|校验码 2位
    class DTO{
        // 标识
        private String identifying;
        // 版本
        private String version;

        private String type;

        private String date;

        private String randomNumber;

        private String incrementNumber;

        private String randomCode;

        private String checkNumber;

        public String getIdentifying() {
            return identifying;
        }

        public void setIdentifying(String identifying) {
            this.identifying = identifying;
        }

        public String getVersion() {
            return version;
        }

        public void setVersion(String version) {
            this.version = version;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getRandomNumber() {
            return randomNumber;
        }

        public void setRandomNumber(String randomNumber) {
            this.randomNumber = randomNumber;
        }

        public String getIncrementNumber() {
            return incrementNumber;
        }

        public void setIncrementNumber(String incrementNumber) {
            this.incrementNumber = incrementNumber;
        }

        public String getRandomCode() {
            return randomCode;
        }

        public void setRandomCode(String randomCode) {
            this.randomCode = randomCode;
        }

        public String getCheckNumber() {
            return checkNumber;
        }

        public void setCheckNumber(String checkNumber) {
            this.checkNumber = checkNumber;
        }
    }


    public static void main(String[] args) {
        System.out.println(generateOrderNo("02"));
    }
}
