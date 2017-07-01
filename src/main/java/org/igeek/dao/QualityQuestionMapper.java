package org.igeek.dao;

import org.igeek.pojo.QualityQuestion;

import java.util.List;

public interface QualityQuestionMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(QualityQuestion record);

    int insertQuestionBatch(List<QualityQuestion> qualityQuestionList);

    int insertSelective(QualityQuestion record);

    QualityQuestion selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(QualityQuestion record);

    int updateByPrimaryKey(QualityQuestion record);

}