package org.igeek.service;

import org.igeek.common.ServerResponse;
import org.igeek.pojo.QualityCollection;

import java.security.GeneralSecurityException;

/**
 * Created by Gyges on 2017/6/29.
 */
public interface IQualityCollectService {

    public ServerResponse<String> addOrUpdateInfo(QualityCollection qualityCollection);

//    public ServerResponse<Set<UserVo>> searchUserList(String name);

    public ServerResponse searchUserCategoryList(Integer category, Integer orgId);

    public ServerResponse getQualityCategoryList(Integer status, Integer questionType, Integer orgId);

    public ServerResponse getCollectHomePageInfo(Integer status, String workerCode, Integer orgId);

    public ServerResponse getWorkerProductCode(Integer status, Integer workerId, String workerCode,Integer orgId);

    public ServerResponse getQualityCollectInfo(String workerCode, Integer workerId, Integer orgId);

    public ServerResponse<String> updateCount(String collectId, Integer workerId, Integer count, Integer orgId);

    public ServerResponse getQualityCollectDetail(Integer orgId, Integer workerId) throws GeneralSecurityException;
}
