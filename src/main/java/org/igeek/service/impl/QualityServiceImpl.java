package org.igeek.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.base.Objects;
import com.google.common.collect.Lists;
import org.igeek.common.ResponseCode;
import org.igeek.common.ServerResponse;
import org.igeek.dao.QualityMapper;
import org.igeek.dao.UserCategoryMapper;
import org.igeek.pojo.Quality;
import org.igeek.service.IQualityService;
import org.igeek.vo.QualityVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        Integer userId = userCategoryMapper.selectUserIdByUsername(quality.getUsername());
        if (Objects.equal(null, quality)) {
            return ServerResponse.createByErrorMsg("请输入完整的质量问题信息");
        }
        if (quality.getId() == null) {

//            遇到扣系数问题时，不输入钱数
            if (quality.getQuestionType() == 2) {
                quality.setUserId(userId);
                quality.setQuestionType(2);
                quality.setMoney(null);
                rowCount = qualityMapper.insert(quality);
                if (rowCount > 0) {
                    return ServerResponse.createBySuccess("质量问题信息插入成功");
                }
                return ServerResponse.createByErrorMsg("质量问题信息插入失败");
            } else {
                quality.setUserId(userId);
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
                quality.setUserId(userId);
                quality.setMoney(null);
                rowCount = qualityMapper.updateByPrimaryKey(quality);
                if (rowCount > 0) {
                    return ServerResponse.createBySuccess("质量问题信息更新成功");
                }
                return ServerResponse.createByErrorMsg("质量问题信息更新失败");
            } else {
                quality.setQuestionType(1);
                quality.setUserId(userId);
                rowCount = qualityMapper.updateByPrimaryKey(quality);
                if (rowCount > 0) {
                    return ServerResponse.createBySuccess("质量问题信息更新成功");
                }
                return ServerResponse.createByErrorMsg("质量问题信息更新失败");
            }
        }
    }


    public ServerResponse<PageInfo> getQualityInfoList(int pageNum, int pageSize,Integer status) {
        PageHelper.startPage(pageNum, pageSize);
        List<Quality> qualityList = qualityMapper.listAllQualityInfo(status);
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
     *
     * @param quality
     * @return
     */
    private QualityVo assembleQualityList(Quality quality) {
        QualityVo qualityVo = new QualityVo();
        qualityVo.setQualityId(quality.getId());
        qualityVo.setQualityName(quality.getTitle());
        qualityVo.setDescription(quality.getRemark());
        qualityVo.setAmount(quality.getMoney());
        qualityVo.setQuestionType(quality.getQuestionType());
        qualityVo.setWorkerType(quality.getUserId());
        return qualityVo;
    }


    public ServerResponse<String> updateQualityStatus(Integer qualityId, Integer status) {
        if (qualityId == null && status == null) {
            return ServerResponse.createByErrorCodeAndMsg(ResponseCode.ILLEGAL_ARGUMENT.getCode(), ResponseCode.ILLEGAL_ARGUMENT.getCodeDesc());
        }
        int rowCount = qualityMapper.updateStatusById(qualityId, status);
        if (rowCount > 0) {
            return ServerResponse.createBySuccess("删除质量问题信息成功");
        }
        return ServerResponse.createByErrorMsg("删除质量问题信息失败");
    }


    public ServerResponse<List<String>> getUserList(Integer status) {
        List<String> userList = userCategoryMapper.getUserList(status);
        if (!Objects.equal(null, userList)) {
            return ServerResponse.createBySuccess("获取工种类别列表成功", userList);
        }
        return ServerResponse.createByErrorMsg("获取工种类别列表失败");
    }


}
