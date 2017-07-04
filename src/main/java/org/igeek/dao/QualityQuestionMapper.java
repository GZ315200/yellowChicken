package org.igeek.dao;

import org.apache.ibatis.annotations.Param;
import org.igeek.pojo.QualityQuestion;

public interface QualityQuestionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(QualityQuestion record);

    int insertSelective(QualityQuestion record);

    QualityQuestion selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(QualityQuestion record);

    int updateByPrimaryKey(QualityQuestion record);

    QualityQuestion getQualityQuestionList(@Param("collectType") Integer collectType);
}