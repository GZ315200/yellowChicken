package org.igeek.service;

import com.github.pagehelper.PageInfo;
import org.igeek.common.ServerResponse;
import org.igeek.pojo.Rank;

import java.util.List;

/**
 * Created by Gyges on 2017/6/28.
 */
public interface IRankService {


    public ServerResponse<String> updateOrSaveKilnValue(Rank rank);

    public ServerResponse<PageInfo> getRankList(int pageNum, int pageSize,String status);

    public ServerResponse<String> updateRankStatus(Integer rankId, String status);

    public ServerResponse<List<Rank>> searchRankList(Integer status);


}
