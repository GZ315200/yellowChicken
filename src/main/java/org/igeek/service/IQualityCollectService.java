package org.igeek.service;

import org.igeek.common.ServerResponse;
import org.igeek.pojo.QualityCollection;

import java.security.GeneralSecurityException;

/**
 * Created by Gyges on 2017/6/29.
 */
public interface IQualityCollectService {

    public ServerResponse<String> addOrUpdateInfo(QualityCollection qualityCollection);

    public ServerResponse searchUserCategoryList(Integer category, Integer orgId);

    public ServerResponse getCollectUserList(Integer category, Integer orgId);

    public ServerResponse getCollectUserListWithFilter(String workerCode,Integer orgId);

    public ServerResponse getQualityCategoryList(Integer status, Integer questionType, Integer orgId);

    public ServerResponse getWorkerProductCode(Integer status, Integer workerId,Integer orgId);

    public ServerResponse getQualityCollectDetail(Integer orgId, Integer workerId,String collectId) throws GeneralSecurityException;

    public ServerResponse getCollectInfoDetail(Integer workerId,Integer orgId,String startTime,String endTime);

    public ServerResponse getSingleCollectInfoDetail(Integer workerId,String collectId,Integer orgId);


}
