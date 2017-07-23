package org.igeek.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.igeek.common.ResponseCode;
import org.igeek.common.ServerResponse;
import org.igeek.dao.QualityCollectionMapper;
import org.igeek.dao.QualityQuestionMapper;
import org.igeek.pojo.QualityQuestion;
import org.igeek.service.IQualityQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Gyges on 2017/7/4.
 */
@Service(value = "iQualityQuestionService")
public class QualityQuestionServiceImpl implements IQualityQuestionService {

    @Autowired
    private QualityQuestionMapper qualityQuestionMapper;
    @Autowired
    private QualityCollectionMapper qualityCollectionMapper;


    @Override
    public ServerResponse<String> addOrUpdateQuestion(QualityQuestion qualityQuestion) {
        if (qualityQuestion.getId() == null) {
            qualityQuestion.setStatus(1);
            int rowCount = qualityQuestionMapper.insert(qualityQuestion);
            if (rowCount > 0) {
                return ServerResponse.createBySuccess("插入质量问题信息成功");
            }
            return ServerResponse.createByErrorMsg("插入质量问题信息失败");
        } else {
            qualityQuestion.setStatus(2);
            int resultCount = qualityQuestionMapper.updateByPrimaryKey(qualityQuestion);
            if (resultCount > 0) {
                return ServerResponse.createBySuccess("更新质量问题信息成功");
            }
            return ServerResponse.createByErrorMsg("更新质量问题信息失败");
        }
    }




    public ServerResponse<String> deleteCollectSingleInfo(Integer workerId, String collectId, Integer orgId) {
        if (workerId == null || StringUtils.isBlank(collectId)) {
            return ServerResponse.createByErrorCodeAndMsg(ResponseCode.ILLEGAL_ARGUMENT.getCode(), ResponseCode.ILLEGAL_ARGUMENT.getCodeDesc());
        }
        int resultCount = qualityQuestionMapper.updateQualityQuestionStatus(workerId, collectId, orgId);
        int rowCount = qualityCollectionMapper.updateCollectStatus(workerId, collectId, orgId);
        if (resultCount > 0 && rowCount > 0) {
            return ServerResponse.createBySuccess("更新信息成功");
        }
        return ServerResponse.createByErrorMsg("更新信息失败");
    }

}
