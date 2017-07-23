package org.igeek.service;

import org.igeek.common.ServerResponse;
import org.igeek.pojo.QualityQuestion;

/**
 * Created by Gyges on 2017/7/4.
 */
public interface IQualityQuestionService {

    public ServerResponse<String> addOrUpdateQuestion(QualityQuestion qualityQuestion);

    public ServerResponse<String> deleteCollectSingleInfo(Integer workerId,String collectId,Integer orgId);
}
