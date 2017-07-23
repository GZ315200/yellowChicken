package org.igeek.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.base.Objects;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import org.apache.commons.collections.CollectionUtils;
import org.igeek.common.ResponseCode;
import org.igeek.common.ServerResponse;
import org.igeek.dao.QualityMapper;
import org.igeek.dao.UserCategoryMapper;
import org.igeek.pojo.Quality;
import org.igeek.pojo.UserCategory;
import org.igeek.service.IQualityService;
import org.igeek.vo.QualityVo;
import org.igeek.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * Created by Gyges on 2017/6/28.
 */
@Service
public class QualityServiceImpl implements IQualityService {

    @Autowired
    private QualityMapper qualityMapper;
    @Autowired
    private UserCategoryMapper userCategoryMapper;


    @Override
    public ServerResponse<String> updateOrAddQuality(Quality quality) {
        int rowCount = 0;
        String username = userCategoryMapper.selectUsernameByUserId(quality.getUserId());
        if (Objects.equal(null, quality)) {
            return ServerResponse.createByErrorMsg("请输入完整的质量问题信息");
        }
        if (quality.getId() == null) {
//            遇到扣系数问题时，不输入钱数
            if (quality.getQuestionType() == 2) {
                quality.setUsername(username);
                quality.setQuestionType(2);
                quality.setMoney(null);
                rowCount = qualityMapper.insert(quality);
                if (rowCount > 0) {
                    return ServerResponse.createBySuccess("质量问题信息插入成功");
                }
                return ServerResponse.createByErrorMsg("质量问题信息插入失败");
            } else {
                quality.setUsername(username);
                quality.setQuestionType(1);
                rowCount = qualityMapper.insert(quality);
                if (rowCount > 0) {
                    return ServerResponse.createBySuccess("质量问题信息插入成功");
                }
                return ServerResponse.createByErrorMsg("质量问题信息插入失败");
            }
        } else {
//            扣系数问题时不更新钱数
            if (quality.getQuestionType() == 2) {
                quality.setQuestionType(2);
                quality.setUsername(username);
                quality.setMoney(null);
                rowCount = qualityMapper.updateByPrimaryKey(quality);
                if (rowCount > 0) {
                    return ServerResponse.createBySuccess("质量问题信息更新成功");
                }
                return ServerResponse.createByErrorMsg("质量问题信息更新失败");
            } else {
                quality.setQuestionType(1);
                quality.setUsername(username);
                rowCount = qualityMapper.updateByPrimaryKey(quality);
                if (rowCount > 0) {
                    return ServerResponse.createBySuccess("质量问题信息更新成功");
                }
                return ServerResponse.createByErrorMsg("质量问题信息更新失败");
            }
        }
    }




    public ServerResponse<PageInfo> getQualityInfoList(int pageNum, int pageSize,
                                                       Integer status,Integer userType,Integer orgId) {
        PageHelper.startPage(pageNum, pageSize);
        List<Quality> qualityList = qualityMapper.listAllQualityInfo(status,userType,orgId);
        if(CollectionUtils.isEmpty(qualityList)){
            return ServerResponse.createByErrorMsg("获取该类型员工的问题信息列表失败");
        }
        List<QualityVo> qualityVoList = Lists.newArrayList();
        for (Quality quality : qualityList) {
            qualityVoList.add(assembleQualityList(quality));
        }
        PageInfo<QualityVo> pageInfo = new PageInfo<>(qualityVoList);
        pageInfo.setList(qualityVoList);
        return ServerResponse.createBySuccess(pageInfo);
    }





    /**
     * 组装信息
     * @param quality
     * @return
     */
    private QualityVo assembleQualityList(Quality quality) {
        QualityVo qualityVo = new QualityVo();
        qualityVo.setQualityId(quality.getId());
        qualityVo.setQualityName(quality.getTitle());
        qualityVo.setDescription(quality.getRemark());
        qualityVo.setAmount(quality.getMoney());
        qualityVo.setCollectType(quality.getQuestionType());
        qualityVo.setWorkerType(quality.getUserId());
        return qualityVo;
    }







    public ServerResponse<String> updateQualityStatus(Integer qualityId, Integer status,Integer orgId) {
        if (qualityId == null && status == null) {
            return ServerResponse.createByErrorCodeAndMsg(ResponseCode.ILLEGAL_ARGUMENT.getCode(), ResponseCode.ILLEGAL_ARGUMENT.getCodeDesc());
        }
        int rowCount = qualityMapper.updateStatusById(qualityId, status,orgId);
        if (rowCount > 0) {
            return ServerResponse.createBySuccess("删除质量问题信息成功");
        }
        return ServerResponse.createByErrorMsg("删除质量问题信息失败");
    }





    public ServerResponse<Set<UserVo>> getUserList(Integer status) {
        UserVo userVo = null;
        Set<UserVo> userVoSet = Sets.newHashSet();
        List<UserCategory> userList = userCategoryMapper.getUserList(status);
        if (!Objects.equal(null, userList)) {
            for(UserCategory userCategory : userList){
                userVo = new UserVo();
                userVo.setWorkerId(userCategory.getId());
                userVo.setWorkerName(userCategory.getTitle());
//                userVo.setUserNameCode(userCategory.getId()+"-"+userCategory.getTitle());
                userVoSet.add(userVo);
            }
            return ServerResponse.createBySuccess("获取工种类别列表成功", userVoSet);
        }
        return ServerResponse.createByErrorMsg("获取工种类别列表失败");
    }


}
