package org.igeek.controller.collect;

import org.igeek.common.Const;
import org.igeek.common.ServerResponse;
import org.igeek.pojo.Organization;
import org.igeek.pojo.QualityCollection;
import org.igeek.pojo.QualityQuestion;
import org.igeek.service.IQualityCollectService;
import org.igeek.service.IQualityQuestionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * Created by Gyges on 2017/7/5.
 */
@Controller
    @RequestMapping("/submit/")
public class SubmitAddOrUpdateController {

    public static final Logger logger = LoggerFactory.getLogger(SubmitAddOrUpdateController.class);

    @Autowired
    private IQualityCollectService iQualityCollectService;

    @Autowired
    private IQualityQuestionService iQualityQuestionService;


    /**
     * 提交需要保存的质量采集信息
     * @param qualityCollection
     * @param qualityQuestion
     * @return
     */
    @RequestMapping("save_info")
    @ResponseBody
    public ServerResponse<String> submitSaveInfo(QualityCollection qualityCollection,
                                                 QualityQuestion qualityQuestion,HttpSession session){
        ServerResponse<String> serverResponse = null;
        Organization organization = (Organization) session.getAttribute(Const.CURRENT_USER);
        if (organization == null) {
            return ServerResponse.createByErrorMsg("当前用户不存在");
        }
        qualityCollection.setOrgId(organization.getOrgId());
        qualityQuestion.setOrgId(organization.getOrgId());
        serverResponse = iQualityCollectService.addOrUpdateInfo(qualityCollection);
        if (serverResponse.isSuccess()){
            return iQualityQuestionService.addOrUpdateQuestion(qualityQuestion);
        }
        return serverResponse;
    }


}
