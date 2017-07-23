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

    int updateByPrimaryKey(QualityCollection record);


    int updateCollectCount(@Param("collectId") String collectId,
                           @Param("workerId") Integer workerId,
                           @Param("count") Integer count,
                           @Param("orgId") Integer orgId);

    List<QualityCollection> getQualityCollection(@Param("workerCode") String workerCode,
                                           @Param("workerId") Integer workerId,
                                           @Param("orgId") Integer orgId);

    QualityCollection getSingleQualityCollect(@Param("workerCode") String workerCode,
                                             @Param("workerId") Integer workerId,
                                              @Param("collectId") String collectId,
                                             @Param("orgId") Integer orgId);

    List<QualityCollection> getQualityCollectionWithEmpty(Integer orgId);

    List<QualityCollection> getAllCollectionList(@Param("orgId") Integer orgId, @Param("workerId") Integer workerId);

    int getCollectCount(@Param("orgId") Integer orgId, @Param("workerId") Integer workerId,
                        @Param("firstTime") String firstTime,@Param("lastTime") String lastTime);
}