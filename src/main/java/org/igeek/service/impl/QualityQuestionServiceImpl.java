package org.igeek.service.impl;

import org.igeek.common.ResponseCode;
import org.igeek.common.ServerResponse;
import org.igeek.dao.QualityQuestionMapper;
import org.igeek.pojo.QualityQuestion;
import org.igeek.service.IQualityQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * Created by Gyges on 2017/7/4.
 */
@Service(value = "iQualityQuestionService")
public class QualityQuestionServiceImpl implements IQualityQuestionService {

    @Autowired
    private QualityQuestionMapper qualityQuestionMapper;


    @Override
    public ServerResponse<String> addOrUpdateQuestion(QualityQuestion qualityQuestion) {
        if (qualityQuestion.getId() == null) {
            Integer workerId = qualityQuestion.getUserId();
            Integer collectId = qualityQuestion.getCollectId();
            Integer questionId = qualityQuestion.getQuestionId();
            List<QualityQuestion> qualityQuestionList = qualityQuestionMapper.getWorkerCollectInfo(workerId, collectId, questionId);
            if (qualityQuestionList.size() > 0) {
                return ServerResponse.createByErrorMsg("该成型工产品问题已经采集过");
            }
            int rowCount = qualityQuestionMapper.insert(qualityQuestion);
            if (rowCount > 0) {
                return ServerResponse.createBySuccess("插入质量问题信息成功");
            }
            return ServerResponse.createByErrorMsg("插入质量问题信息失败");
        } else {
            int resultCount = qualityQuestionMapper.updateByPrimaryKey(qualityQuestion);
            if (resultCount > 0) {
                return ServerResponse.createBySuccess("更新质量问题信息成功");
            }
            return ServerResponse.createByErrorMsg("更新质量问题信息失败");
        }
    }


    public ServerResponse<QualityQuestion> getQualityQuestionList(Integer collectType, Integer workerId) {
        if (Objects.nonNull(collectType)) {
            QualityQuestion qualityQuestion = qualityQuestionMapper.getQualityQuestionList(collectType, workerId);
            if (Objects.nonNull(qualityQuestion)) {
                return ServerResponse.createBySuccess(qualityQuestion);
            }
            return ServerResponse.createByErrorMsg("获取质量问题信息失败");
        }
        return ServerResponse.createByErrorCodeAndMsg(ResponseCode.ILLEGAL_ARGUMENT.getCode(), ResponseCode.ILLEGAL_ARGUMENT.getCodeDesc());
    }


}
