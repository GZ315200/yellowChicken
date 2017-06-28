package org.igeek.dao;

import org.igeek.pojo.Quality;

public interface QualityMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Quality record);

    int insertSelective(Quality record);

    Quality selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Quality record);

    int updateByPrimaryKey(Quality record);
}