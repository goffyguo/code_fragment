package dockingthirdpart;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.model.CannedAccessControlList;
import com.aliyun.oss.model.OSSObject;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.InputStream;



/**
 * @author GuoFei
 */
@Slf4j
public class UploadFileToAliOss {
    /**
     * 上传文件到阿里OSS服务器
     * @param endpoint        OSS服务器地区VPC网络endponit
     * @param accessKeyId     连接阿里OSS服务器公钥
     * @param accessKeySecret 连接阿里OSS服务器密钥钥
     * @param bucketName      阿里OSS服务器bucket名称
     * @param in              上传文件对象输入流
     * @param ossFilePath     文件要放在服务器的位置，可以级联路径
     */
    public static void uploadFile(String endpoint,String accessKeyId,String accessKeySecret,
                                  String bucketName,InputStream in,String ossFilePath) throws IOException {
        /*
         * 创建一个OSS连接客户端
         */
        OSS client = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
        try {
            /*
             * Create an empty folder without request body, note that the key must be
             * suffixed with a slash
             */
            client.putObject(bucketName, ossFilePath, in);
            client.setObjectAcl(bucketName, ossFilePath, CannedAccessControlList.PublicRead);

            /*
             * Verify whether the size of the empty folder is zero
             */
            OSSObject object = client.getObject(bucketName, ossFilePath);
            log.debug("Size of the empty folder '" + object.getKey() + "' is " +
                    object.getObjectMetadata().getContentLength());
            object.getObjectContent().close();

        } catch (OSSException oe) {
            log.error("Caught an OSSException, which means your request made it to OSS, but was rejected with an error response for some reason.");
            log.error("Error Message: " + oe.getErrorMessage());
            log.error("Error Code:       " + oe.getErrorCode());
            log.error("Request ID:      " + oe.getRequestId());
            log.error("Host ID:           " + oe.getHostId());
            log.error("上传文件出错OSSException：", oe);
        } catch (ClientException ce) {
            log.error("Caught an ClientException, which means the client encountered a serious internal problem while trying to communicate with OSS, "
                    + "such as not being able to access the network.");
            log.error("Error Message: " + ce.getMessage());
            log.error("上传文件出错ClientException：", ce);
        } catch (Exception e) {
            log.error("上传文件出错Exception：", e);
        } finally {
            if (in != null){
                in.close();
            }
            /*
             * Do not forget to shut down the client finally to release all allocated resources.
             */
            client.shutdown();
        }
    }
    /**
     * 删除阿里OSS服务器上的文件
     * @param endpoint        OSS服务器地区VPC网络endponit
     * @param accessKeyId     连接阿里OSS服务器公钥
     * @param accessKeySecret 连接阿里OSS服务器密钥钥
     * @param bucketName      阿里OSS服务器bucket名称
     * @param ossFilePath     文件要放在服务器的位置，可以级联路径
     */
    public static void deleteFile(String endpoint,String accessKeyId,String accessKeySecret,
                                  String bucketName,String ossFilePath) {
        //创建一个OSS连接客户端
        OSS client = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
        try {
            // 删除文件或目录。如果要删除目录，目录必须为空。
            client.deleteObject(bucketName, ossFilePath);
        } catch (Exception e) {
            log.error("删除文件出错Exception：", e);
        } finally {
            client.shutdown();
        }
    }

    /**
     * 上传文件到阿里OSS服务器
     * @param aliyunOssConfig 阿里云OSS配置对象
     * @param in 文件输入流
     * @param ossFilePath OSS文件存储路径
     * @throws IOException 抛出异常
     */
    public static void uploadFile(AliyunOssConfig aliyunOssConfig, InputStream in, String ossFilePath) throws IOException{
        uploadFile(aliyunOssConfig.getEndponit(),aliyunOssConfig.getAccessKeyId(),aliyunOssConfig.getAccessKeySecret(),
                aliyunOssConfig.getBucketName(),in, ossFilePath);
    }
}

