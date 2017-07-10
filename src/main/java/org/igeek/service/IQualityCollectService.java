package org.igeek.service;

import org.igeek.common.ServerResponse;
import org.igeek.pojo.QualityCollection;
import org.igeek.vo.ProductCollectVo;
import org.igeek.vo.QualityVo;
import org.igeek.vo.UserVo;

import java.security.GeneralSecurityException;
import java.util.Set;

/**
 * Created by Gyges on 2017/6/29.
 */
public interface IQualityCollectService {

    public ServerResponse<String> addOrUpdateInfo(QualityCollection qualityCollection);

//    public ServerResponse<Set<UserVo>> searchUserList(String name);

    public ServerResponse<Set<UserVo>> searchUserCategoryList(Integer category, Integer orgId);

    public ServerResponse<Set<QualityVo>> getQualityCategoryList(Integer status, Integer questionType, Integer orgId);

    public ServerResponse<Set<ProductCollectVo>> searchProIdList(Integer status, Integer workerId, String workerCode,Integer orgId);

    public ServerResponse getQualityCollectInfo(String workerCode, Integer workerId, Integer orgId);

    public ServerResponse<String> updateCount(String collectId, Integer workerId, Integer count, Integer orgId);

    public ServerResponse getQualityCollectDetail(Integer orgId, Integer workerId) throws GeneralSecurityException;
}
