package org.igeek.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.base.Objects;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import org.apache.commons.lang3.StringUtils;
import org.igeek.common.ResponseCode;
import org.igeek.common.ServerResponse;
import org.igeek.dao.RankMapper;
import org.igeek.pojo.Rank;
import org.igeek.service.IRankService;
import org.igeek.vo.RankVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * Created by Gyges on 2017/6/28.
 */
@Service(value = "iRankService")
public class RankServiceImpl implements IRankService {

    @Autowired
    private RankMapper rankMapper;


    @Override
    public ServerResponse<String> updateOrSaveKilnValue(Rank rank) {
        int rowCount = 0;
        if (Objects.equal(null, rank)) {
            return ServerResponse.createByErrorMsg("请输入完整等级信息");
        }
        if (rank.getId() == null) {
            int resultCount = rankMapper.selectByRankTitle(rank.getTitle());
            if (resultCount > 0) {
                return ServerResponse.createByErrorMsg("该等级信息已经存在");
            }
            rowCount = rankMapper.insert(rank);
            if (rowCount > 0) {
                return ServerResponse.createBySuccess("插入等级信息成功");
            }
            return ServerResponse.createByErrorMsg("插入等级信息失败");
        } else {
            rowCount = rankMapper.updateByPrimaryKey(rank);
            if (rowCount > 0) {
                return ServerResponse.createBySuccess("更新等级信息成功");
            }
            return ServerResponse.createByErrorMsg("更新等级信息失败");
        }
    }

    @Override
    public ServerResponse<PageInfo> getRankList(int pageNum, int pageSize,String status) {
        PageHelper.startPage(pageNum, pageSize);
        List<Rank> rankList = rankMapper.selectAllRankList(status);
        List<RankVo> rankVoList = Lists.newArrayList();
        for (Rank rankItem : rankList) {
            rankVoList.add(assembleRankVo(rankItem));
        }
        PageInfo<RankVo> pageInfo = new PageInfo<>(rankVoList);
        pageInfo.setList(rankVoList);
        return ServerResponse.createBySuccess(pageInfo);
    }

    /**
     * 组装等级信息
     *
     * @param rank
     * @return
     */
    private RankVo assembleRankVo(Rank rank) {
        RankVo rankVo = new RankVo();
        rankVo.setRankId(rank.getId());
        rankVo.setRankName(rank.getTitle());
        rankVo.setRemark(rank.getremark());
        return rankVo;
    }


    public ServerResponse<String> updateRankStatus(Integer rankId, String status) {
        if (rankId == null && StringUtils.isBlank(status)) {
            return ServerResponse.createByErrorCodeAndMsg(ResponseCode.ILLEGAL_ARGUMENT.getCode(), ResponseCode.ILLEGAL_ARGUMENT.getCodeDesc());
        }
        int rowCount = rankMapper.updateStatusById(rankId, status);
        if (rowCount > 0) {
            return ServerResponse.createBySuccess("删除等级信息成功");
        }
        return ServerResponse.createByErrorMsg("删除等级信息失败");
    }


    @Override
    public ServerResponse<Set<RankVo>> searchRankTitle(Integer status) {
        Set<RankVo> rankVoSet = Sets.newHashSet();
        List<Rank> rankTitle = rankMapper.getRankTitle(status);
        if(rankTitle.size() > 0){
            for(Rank rank : rankTitle) {
                RankVo rankVo = new RankVo();
                rankVo.setRankIdName(rank.getId()+"-"+rank.getTitle());
                rankVoSet.add(rankVo);
            }
            return ServerResponse.createBySuccess("查询等级信息成功",rankVoSet);
        }
        return ServerResponse.createByErrorMsg("查询等级信息成功");
    }


}
