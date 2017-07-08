package org.igeek.dao;

import org.apache.ibatis.annotations.Param;
import org.igeek.pojo.Rank;

import java.util.List;

public interface RankMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Rank record);

    int insertSelective(Rank record);

    Rank selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Rank record);

    int updateByPrimaryKey(Rank record);

    int selectByRankTitle(@Param("rankName") String rankName,@Param("orgId") Integer orgId);

    List<Rank> selectAllRankList(@Param("status") String status,@Param("orgId") Integer orgId);

    int updateStatusById(@Param("rankId") Integer rankId,
                         @Param("status") String status,
                         @Param("orgId") Integer orgId);

    List<Rank> getRankTitle(@Param("status") Integer status,@Param("orgId") Integer orgId);
}