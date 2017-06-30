package org.igeek.service;

import com.github.pagehelper.PageInfo;
import org.igeek.common.ServerResponse;
import org.igeek.pojo.Quality;

import java.util.List;

/**
 * Created by Gyges on 2017/6/28.
 */
public interface IQualityService {

    public ServerResponse<String> updateOrAddQuality(Quality quality);

    public ServerResponse<PageInfo> getQualityInfoList(int pageNum, int pageSize,Integer status);

    public ServerResponse<String> updateQualityStatus(Integer qualityId, Integer status);

    public ServerResponse<List<String>> getUserList(Integer status);



}
