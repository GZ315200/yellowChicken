package org.igeek.dao;

import org.igeek.pojo.QualityCollection;

import java.util.List;

public interface QualityCollectionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(QualityCollection record);

    int insertSelective(QualityCollection record);

    QualityCollection selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(QualityCollection record);

    int updateCollectCount(Integer collectId);

    int updateByPrimaryKey(QualityCollection record);

    List<QualityCollection> getQualityCollection(Integer userId);

}