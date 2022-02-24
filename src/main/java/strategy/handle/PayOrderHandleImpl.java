package strategy.handle;

import org.springframework.stereotype.Service;
import strategy.util.PayEncryptUtil;
import strategy.dto.PayApiVerifyDTO;
import strategy.dto.PayOrderInfoDTO;
import strategy.dto.PreparePayDTO;
import strategy.exception.PayServiceException;
import strategy.pojo.Mch;
import strategy.util.JsonUtil;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: GuoFei
 * @Date: 2022/02/24/14:40
 * @Description:
 */
@Service
public class PayOrderHandleImpl implements PayOrderHandle{
    @Override
    public PayOrderInfoDTO createOrder(Mch mch1, PreparePayDTO preparePayDTO, String tradeNo, boolean isSave) throws PayServiceException {
        return null;
    }

    @Override
    public PreparePayDTO preparePayVerify(Mch mch, PayApiVerifyDTO payApiVerifyDTO) throws PayServiceException {
        // 验签
        boolean checkFlag = PayEncryptUtil.verify(payApiVerifyDTO, mch.getSecret());
        /*if (!checkFlag) {
            throw new PayServiceException(PayResponseBOEnum.ERROR_04001);
        }*/

        // 参数转换
        PreparePayDTO preparePayDTO = JsonUtil.fromJson(payApiVerifyDTO.getBizContent(), PreparePayDTO.class);
        //validatorService.validObject(preparePayDTO);

        // 查询应用
       /* long applicationCount = mchRelApplicationDao.countByMchIdAndApplicationIdAndStatus(mch.getMchId(),
                preparePayDTO.getApplicationId(), DefaultStatusEnum.ENABLE.getStatus());
        if (applicationCount == 0){
            throw new PayServiceException(PayResponseBOEnum.ERROR_04014);
        }*/

        // 查询是否有相应支付权限
        /*long count = mchPlatformRelChannelRelScenesDao.countByMchIdAndPlatformCodeAndChannelCodeAndScenesCodeAndStatus(
                mch.getMchId(), preparePayDTO.getPayPlatform(),
                preparePayDTO.getPayChannel(), preparePayDTO.getPayScenes(), DefaultStatusEnum.ENABLE.getStatus());
        if (count == 0){
            throw new PayServiceException(PayResponseBOEnum.ERROR_04009);
        }*/

        return preparePayDTO;
    }

    @Override
    public boolean testVerify(PayApiVerifyDTO payApiVerifyDTO) {
        return false;
    }
}
