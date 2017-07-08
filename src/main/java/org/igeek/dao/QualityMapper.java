package org.igeek.dao;

import org.apache.ibatis.annotations.Param;
import org.igeek.pojo.Quality;

import java.util.List;

public interface QualityMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Quality record);

    int insertSelective(Quality record);

    Quality selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Quality record);

    int updateByPrimaryKey(Quality record);

    int selectByTitle(@Param("qualityName") String qualityName,@Param("orgId") Integer orgId);

    List<Quality> listAllQualityInfo(@Param("status") Integer status,
                                     @Param("userId") Integer userId,
                                     @Param("orgId") Integer orgId);

    int updateStatusById(@Param("qualityId") Integer qualityId,
                         @Param("status") Integer status,
                         @Param("orgId") Integer orgId);

    List<Quality> selectAllQualityQuestion(@Param("status") Integer status,
                                           @Param("questionType") Integer questionType,
                                           @Param("orgId") Integer orgId);
}