package org.igeek.service;

import org.igeek.common.ServerResponse;
import org.igeek.pojo.QualityCollection;
import org.igeek.vo.ProductVo;
import org.igeek.vo.QualityVo;
import org.igeek.vo.UserVo;

import java.util.Set;

/**
 * Created by Gyges on 2017/6/29.
 */
public interface IQualityCollectService {

    public ServerResponse<String> addOrUpdateInfo(QualityCollection qualityCollection);

    public ServerResponse<String> addOrUpdateQuestion(Integer qualitys, Double coefficients, Integer q_id, Integer q_type);

    public ServerResponse<Set<UserVo>> searchUserList(String name);

    public ServerResponse<Set<UserVo>> searchUserCategoryList(Integer category);

    public ServerResponse<Set<QualityVo>> getQualityCategoryList(Integer status, Integer questionType);

    public ServerResponse<Set<ProductVo>> searchProIdList(Integer status);
}
