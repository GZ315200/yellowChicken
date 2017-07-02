package org.igeek.controller.initData;

import com.github.pagehelper.PageInfo;
import org.igeek.common.ServerResponse;
import org.igeek.pojo.Rank;
import org.igeek.service.IRankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Gyges on 2017/6/28.
 */
@Controller
@RequestMapping(value = "/rank/")
public class RankController {


    @Autowired
    private IRankService iRankService;

    /**
     * 增加和更新等级信息
     * @param rank
     * @return
     */
    @RequestMapping(value = "addOrUpdate", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> updateOrSaveRankValue(Rank rank) {
        return iRankService.updateOrSaveKilnValue(rank);
    }

    /**
     * 获得等级信息列表
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "get_rank_list")
    @ResponseBody
    public ServerResponse<PageInfo> getRankList(@RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                                                @RequestParam(value = "pageSize", defaultValue = "10") int pageSize,
                                                @RequestParam(value = "status",defaultValue = "1",required = false) String status) {
        return iRankService.getRankList(pageNum, pageSize,status);
    }

    /**
     * 更新等级状态
     * @param rankId
     * @param status
     * @return
     */
    @RequestMapping(value = "update_status")
    @ResponseBody
    public ServerResponse<String> updateRankStatus(Integer rankId,String status){
        return iRankService.updateRankStatus(rankId, status);
    }



}
