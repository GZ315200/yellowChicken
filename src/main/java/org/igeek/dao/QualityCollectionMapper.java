package org.igeek.dao;

import org.igeek.pojo.QualityCollection;

public interface QualityCollectionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(QualityCollection record);

    int insertSelective(QualityCollection record);

    QualityCollection selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(QualityCollection record);

    int updateByPrimaryKey(QualityCollection record);
}