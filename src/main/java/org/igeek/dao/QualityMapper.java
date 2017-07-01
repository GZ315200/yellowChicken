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

    int selectByTitle(@Param("qualityName") String qualityName);

    List<Quality> listAllQualityInfo(Integer status);

    int updateStatusById(@Param("qualityId") Integer qualityId,@Param("status") Integer status);

    List<Quality> selectAllQualityQuestion(Integer status,Integer questionType);


}