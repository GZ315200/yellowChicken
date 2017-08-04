package org.igeek.dao;

import org.apache.ibatis.annotations.Param;
import org.igeek.pojo.PCollect;

import java.util.List;

public interface PCollectMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PCollect record);

    int insertSelective(PCollect record);

    PCollect selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PCollect record);

    int updateByPrimaryKey(PCollect record);


    PCollect selectSpCollectByProductId(@Param("orgId") Integer orgId, @Param("proId")Integer proId,
                                         @Param("workerId") Integer workerId);

    List<PCollect> selectByProductId(@Param("productId") Integer productId,
                                      @Param("workerId") Integer workerId, @Param("orgId") Integer orgId);

    List<PCollect> getSpCollectList(@Param("status") Integer status,
                                     @Param("workerId") Integer workerId,
                                     @Param("orgId") Integer orgId);

    List<PCollect> getSpCollectInfo(@Param("workerId") Integer workerId,@Param("orgId") Integer orgId);
}