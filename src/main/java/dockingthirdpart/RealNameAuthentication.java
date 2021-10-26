package dockingthirdpart;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.IdUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import sun.misc.BASE64Encoder;
import com.alibaba.fastjson.JSON;

import javax.annotation.Resource;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: GuoFei
 * @Date: 2021/10/25/16:50
 * @Description: 对接第三方市民认证
 */
@Slf4j
public class RealNameAuthentication {

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private AliyunOssConfig aliyunOssConfig;




    public  boolean realNameAuthentication(IdimageVerifyDTO idimageVerifyDTO) throws Exception{
        BASE64Encoder encoder = new BASE64Encoder();
        String encode = encoder.encode(idimageVerifyDTO.getIdImageFront().getBytes());

        // 生成新的文件名称防止文件名冲突发生文件覆盖
        String idImageFrontImg = IdUtil.simpleUUID() + "." + FileUtil.getSuffix( idimageVerifyDTO.getIdImageFront().getOriginalFilename());
        //  拼接文件路径,根据年、月分类文件夹
        Date now = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM");
        String time = dateFormat.format(now);
        String idImageFront = "exchange/users/idcard/"+ time +"/" + idImageFrontImg;
        uploadShowImgFile(idImageFront, idimageVerifyDTO.getIdImageFront().getInputStream());
        String idImageBackImg = IdUtil.simpleUUID() + "." + FileUtil.getSuffix( idimageVerifyDTO.getIdImageFront().getOriginalFilename());
        //  拼接文件路径,根据年、月分类文件夹
        Date now1 = new Date();
        String time1 = dateFormat.format(now1);
        String idImageBack = "exchange/users/idcard/"+ time1 +"/" + idImageBackImg;
        uploadShowImgFile(idImageBack, idimageVerifyDTO.getIdImageBack().getInputStream());



        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.add("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
        MultiValueMap<String, String> requestBody = new LinkedMultiValueMap<>();
        String imgStr = GetBase64StrOfImg("/Users/guogoffy/companyImcore/pic/WechatIMG48.png");
        String ID_CARD_OCR_IDENTIFICATION_KEY = "";
        String ID_CARD_OCR_IDENTIFICATION_URL = "";
        requestBody.add("key",ID_CARD_OCR_IDENTIFICATION_KEY);
        requestBody.add("image",encode);
        requestBody.add("side","front");
        HttpEntity<MultiValueMap> requestEntity = new HttpEntity<>(requestBody, requestHeaders);
        IdentityAuthenticationDTO authenticationDTO = restTemplate.exchange(
                ID_CARD_OCR_IDENTIFICATION_URL,
                HttpMethod.POST,
                requestEntity,
                new ParameterizedTypeReference<IdentityAuthenticationDTO>() {
                }).getBody();
        String reason = authenticationDTO.getReason();
        IdOcrVerifyResultDTO resultDTO = JSON.parseObject(JSON.toJSONString(authenticationDTO.getResult()), IdOcrVerifyResultDTO.class);
        log.info("身份证OCR结果->{},result->{}",reason,resultDTO);
        if ("成功".equals(reason)){
            ExchangeUserCertificatesOcrInfo info = insertCertificatesOcrInfo(resultDTO, 1,"", idImageFront, idImageBack);
            //请求接口
            String REAL_NAME_AUTHENTICATION_KEY = "";
            String REAL_NAME_AUTHENTICATION_URL = "";
            IdentityAuthenticationDTO authenticationDTO1 = restTemplate.exchange(
                    REAL_NAME_AUTHENTICATION_URL+
                            "?key="+ REAL_NAME_AUTHENTICATION_KEY+
                            "&idcard="+ resultDTO.getIdcard()+
                            "&realname="+resultDTO.getRealname()+
                            "&orderid=1",
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<IdentityAuthenticationDTO>() {
                    }).getBody();
            String reason1 = authenticationDTO1.getReason();
            RealNameAuthenticationResultDTO resultDTO1 = JSON.parseObject(JSON.toJSONString(authenticationDTO1.getResult()), RealNameAuthenticationResultDTO.class);
            log.info("身份证认证结果->{},result->{}",reason1,resultDTO1);
            if ("成功".equals(reason1)){
                insertRealNameAuthenticationResult(resultDTO1,1, "",info.getId());
                if (resultDTO1.getRes().intValue()==1){
                    return true;
                }
                return false;
            }else{
                log.error("认证请求失败->{}",reason1);
            }
        }else{
            log.error("OCR请求失败->{}",reason);
        }

        return false;
    }

    private void insertRealNameAuthenticationResult(RealNameAuthenticationResultDTO resultDTO,Integer userId,String phoneNumber,Integer certificatesId) {
        ExchangeUserRealNameAuthenticationResult authenticationResult = new ExchangeUserRealNameAuthenticationResult();
        authenticationResult.setUserId(userId);
        authenticationResult.setPhoneNumber(phoneNumber);
        authenticationResult.setCertificatesId(certificatesId);
        authenticationResult.setOrderId(resultDTO.getOrderid());
        authenticationResult.setResult(resultDTO.getRes());
        authenticationResult.setAuthenticationTime(new Date());
        //authenticationResultMapper.insert(authenticationResult);
    }

    private ExchangeUserCertificatesOcrInfo insertCertificatesOcrInfo(IdOcrVerifyResultDTO resultDTO,Integer userId,String phoneNumber,String idImageFront,String idImageBack) {
        ExchangeUserCertificatesOcrInfo info = new ExchangeUserCertificatesOcrInfo();
        info.setUserId(userId);
        info.setPhoneNumber(phoneNumber);
        info.setUserName(resultDTO.getRealname());
        info.setNationality("CN");
        info.setCertificatesType((byte)0);
        info.setCertificatesNumber(resultDTO.getIdcard());
        info.setSex((byte)(resultDTO.getSex()=="男"?1:0));
        info.setNation(resultDTO.getNation());
        info.setBorn(resultDTO.getBorn());
        info.setAddress(resultDTO.getAddress());
        info.setOrderId(resultDTO.getOrderid());
        info.setCreateTime(new Date());
        info.setUpdateTime(new Date());
        info.setCertificatesImagsFront(idImageFront);
        info.setCertificatesImagsBack(idImageBack);
        //certificatesOcrInfoMapper.insert(info);
        return info;
    }

    public void uploadShowImgFile(String filePath, InputStream in) {
        try {
            UploadFileToAliOss.uploadFile(aliyunOssConfig.getEndponit(), aliyunOssConfig.getAccessKeyId(),
                    aliyunOssConfig.getAccessKeySecret(), aliyunOssConfig.getBucketName(),in,filePath);
        } catch (FileNotFoundException e) {
            throw new RuntimeException("上传至OSS的文件不存在");
        } catch (IOException e) {
            throw new RuntimeException("上传至OSS时发生错误");
        }
    }




    /**
     * 图片Base64编码
     * @param fileName
     * @return
     */
    public static String GetBase64StrOfImg(String fileName) {
        if (fileName == null) {
            return null;
        }
        try {
            FileInputStream stream = new FileInputStream(new File(fileName));
            ByteArrayOutputStream out = new ByteArrayOutputStream(1000);
            byte[] b = new byte[1000];
            for (int n; (n = stream.read(b)) != -1;) {
                out.write(b, 0, n);
            }
            stream.close();
            out.close();
            byte[] bytes = out.toByteArray();
            BASE64Encoder encoder = new BASE64Encoder();
            return encoder.encodeBuffer(bytes);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
