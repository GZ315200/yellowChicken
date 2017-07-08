package org.igeek.dao;

import org.apache.ibatis.annotations.Param;
import org.igeek.pojo.SpCollect;

import java.util.List;

public interface SpCollectMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SpCollect record);

    int insertSelective(SpCollect record);

    SpCollect selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SpCollect record);

    int updateByPrimaryKey(SpCollect record);

    List<SpCollect> getSpCollectList(@Param("status") Integer status,
                                     @Param("workerId") Integer workerId,
                                     @Param("orgId") Integer orgId);
}