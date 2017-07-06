package org.igeek.dao;

import org.apache.ibatis.annotations.Param;
import org.igeek.pojo.QualityCollection;

import java.util.List;

public interface QualityCollectionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(QualityCollection record);

    int insertSelective(QualityCollection record);

    QualityCollection selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(QualityCollection record);

    int updateCollectCount(@Param("collectId") Integer collectId,@Param("workerId") Integer workerId,@Param("count") Long count);

    int updateByPrimaryKey(QualityCollection record);

    List<QualityCollection> getQualityCollection(@Param("workerCode") String workerCode, @Param("workerId")  Integer workerId);

    List<QualityCollection> getAllCollectionList();

}