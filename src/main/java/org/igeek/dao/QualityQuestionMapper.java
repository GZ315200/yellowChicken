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

    QualityQuestion getQualityQuestionList(@Param("collectType") Integer collectType,@Param("workerId") Integer workerId);

    List<QualityQuestion> getWorkerCollectInfo(@Param("workerId") Integer workerId,@Param("collectId") Integer collectId,@Param("questionId") Integer questionId);

}