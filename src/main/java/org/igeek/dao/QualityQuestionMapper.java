package org.igeek.dao;

import org.apache.ibatis.annotations.Param;
import org.igeek.pojo.QualityQuestion;

import java.util.List;

public interface QualityQuestionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(QualityQuestion record);

    int insertSelective(QualityQuestion record);

    QualityQuestion selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(QualityQuestion record);

    int updateByPrimaryKey(QualityQuestion record);

    List<QualityQuestion> getQualityQuestionList(@Param("collectType") Integer collectType,
                                           @Param("workerId") Integer workerId,
                                           @Param("orgId") Integer orgId);

    List<QualityQuestion> getWorkerCollectInfo(@Param("workerId") Integer workerId,
                                               @Param("collectId") String collectId,
                                               @Param("questionId") Integer questionId,
                                               @Param("orgId") Integer orgId);

}