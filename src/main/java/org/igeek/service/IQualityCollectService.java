package org.igeek.service;

import org.igeek.common.ServerResponse;
import org.igeek.pojo.QualityQuestion;
import org.igeek.vo.UserVo;

import java.util.Set;

/**
 * Created by Gyges on 2017/6/29.
 */
public interface IQualityCollectService {

    public ServerResponse<String> addOrUpdateInfo(QualityQuestion qualityQuestion);

    public ServerResponse<Set<UserVo>> searchUserList(String name);

    public ServerResponse<Set<UserVo>> searchUserCategoryList(Integer category);
}
