package org.igeek.dao;

import org.apache.ibatis.annotations.Param;
import org.igeek.pojo.CollectHomepage;

public interface CollectHomepageMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CollectHomepage record);

    int insertSelective(CollectHomepage record);

    CollectHomepage selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CollectHomepage record);

    int updateByPrimaryKey(CollectHomepage record);

    CollectHomepage getCollectWorkerInfo(@Param("workerId") Integer workerId, @Param("orgId") Integer orgId);

    int updateCollectWorkerCount(@Param("workerId") Integer workerId, @Param("orgId") Integer orgId,
                                 @Param("collectCount") Integer count);
}