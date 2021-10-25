package dockingthirdpart;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 阿里云存储配置类
 * @author luoyonghui
 */

@Configuration
@ConfigurationProperties(prefix = "ali.oss")
@Data
public class AliyunOssConfig {
    /**
     * 阿里云存储访问域名
     */
    private String endponit;
    /**
     * 阿里云存储访问key id
     */
    private String accessKeyId;
    /**
     * 阿里云存储访问密钥
     */
    private String accessKeySecret;
    /**
     * 阿里云存储访问桶名
     */
    private String bucketName;
    /**
     * 阿里云存储访问地址前缀
     */
    private String outsideWebAddress;

    /**
     * 构建一个访问客房端
     * @return 访问客房端
     */
    @Bean
    public OSS ossClient() {
        return  new OSSClientBuilder().build(endponit, accessKeyId, accessKeySecret);
    }

}