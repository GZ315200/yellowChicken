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

    int selectByRankTitle(@Param("rankName") String rankName);

    List<Rank> selectAllRankList(String status);

    int updateStatusById(@Param("rankId") Integer rankId,@Param("status") String status);

    List<Rank> getRankTitle(Integer status);
}