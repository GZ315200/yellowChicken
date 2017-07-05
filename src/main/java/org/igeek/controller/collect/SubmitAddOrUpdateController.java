package org.igeek.controller.collect;

import org.igeek.common.ServerResponse;
import org.igeek.pojo.QualityCollection;
import org.igeek.pojo.QualityQuestion;
import org.igeek.service.IQualityCollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Gyges on 2017/7/5.
 */
@Controller
@RequestMapping("/submit/")
public class SubmitAddOrUpdateController {

    @Autowired
    private QualityCollectController collectController;

    @Autowired
    private IQualityCollectService iQualityCollectService;


    /**
     * 提交需要保存的质量采集信息
     * @param qualityCollection
     * @param qualityQuestion
     * @return
     */
    @RequestMapping("save_info")
    @ResponseBody
    public ServerResponse<String> submitSaveInfo(QualityCollection qualityCollection, QualityQuestion qualityQuestion){
        ServerResponse<String> response = collectController.addOrUpdateInfo(qualityCollection);
        ServerResponse<String> serverResponse = collectController.addOrUpdateQuestion(qualityQuestion);
        if(response.isSuccess() && serverResponse.isSuccess()){
           return iQualityCollectService.updateCount(qualityCollection.getId());
        }
        return ServerResponse.createByErrorMsg("保存或更新信息失败");
    }


}
