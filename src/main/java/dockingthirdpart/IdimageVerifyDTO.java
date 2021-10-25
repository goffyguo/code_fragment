package dockingthirdpart;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;


/**
 * Created with IntelliJ IDEA.
 *
 * @Author: GuoFei
 * @Date: 2021/10/22/14:27
 * @Description: 身份认证DTO
 */
@Data
public class IdimageVerifyDTO {

    @JSONField(serialize = false)
    private MultipartFile IdImageFront;

    @JSONField(serialize = false)
    private MultipartFile IdImageBack;
}
