package org.igeek.service;

import com.github.pagehelper.PageInfo;
import org.igeek.common.ServerResponse;
import org.igeek.pojo.Rank;

/**
 * Created by Gyges on 2017/6/28.
 */
public interface IRankService {


    public ServerResponse<String> updateOrSaveKilnValue(Rank rank);

    public ServerResponse<PageInfo> getRankList(int pageNum, int pageSize);

    public ServerResponse<String> updateRankStatus(Integer rankId, String status);


}
