package org.igeek.dao;

import org.igeek.pojo.SpCollect;

import java.util.List;

public interface SpCollectMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SpCollect record);

    int insertSelective(SpCollect record);

    SpCollect selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SpCollect record);

    int updateByPrimaryKey(SpCollect record);

    List<SpCollect> getSpCollectList(Integer status);
}