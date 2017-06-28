package org.igeek.dao;

import org.igeek.pojo.ProCategory;

public interface ProCategoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ProCategory record);

    int insertSelective(ProCategory record);

    ProCategory selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProCategory record);

    int updateByPrimaryKey(ProCategory record);
}