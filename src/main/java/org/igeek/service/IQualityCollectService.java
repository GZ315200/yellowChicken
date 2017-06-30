package org.igeek.service;

import org.igeek.common.ServerResponse;
import org.igeek.pojo.QualityQuestion;

import java.util.List;

/**
 * Created by Gyges on 2017/6/29.
 */
public interface IQualityCollectService {

    public ServerResponse<String> addOrUpdateInfo(QualityQuestion qualityQuestion);
    public ServerResponse<List<String>> searchUserList(String name);
}
