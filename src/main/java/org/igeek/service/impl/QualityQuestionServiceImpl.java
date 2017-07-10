package org.igeek.service.impl;

import org.apache.commons.lang3.StringUtils;
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
        if (StringUtils.isBlank(qualityQuestion.getCollectId())) {
            return ServerResponse.createByErrorCodeAndMsg(ResponseCode.ILLEGAL_ARGUMENT.getCode(), ResponseCode.ILLEGAL_ARGUMENT.getCodeDesc());
        }
        if (qualityQuestion.getId() == null) {
            qualityQuestion.setStatus(1);
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


    public ServerResponse getQualityQuestionList(Integer collectType, Integer workerId,Integer orgId) {
        if (Objects.nonNull(collectType)) {
            List<QualityQuestion> qualityQuestion = qualityQuestionMapper.getQualityQuestionList(collectType, workerId,orgId);
            if (Objects.nonNull(qualityQuestion)) {
                return ServerResponse.createBySuccess(qualityQuestion);
            }
            return ServerResponse.createByErrorMsg("获取质量问题信息失败");
        }
        return ServerResponse.createByErrorCodeAndMsg(ResponseCode.ILLEGAL_ARGUMENT.getCode(), ResponseCode.ILLEGAL_ARGUMENT.getCodeDesc());
    }


}
