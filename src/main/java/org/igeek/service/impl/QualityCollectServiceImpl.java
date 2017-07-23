package org.igeek.service.impl;

import com.google.common.collect.Lists;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.igeek.common.ResponseCode;
import org.igeek.common.ServerResponse;
import org.igeek.dao.*;
import org.igeek.exception.GeneralServiceException;
import org.igeek.pojo.*;
import org.igeek.service.IQualityCollectService;
import org.igeek.util.CalenderUtil;
import org.igeek.vo.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.GeneralSecurityException;
import java.util.List;
import java.util.Objects;

/**
 * Created by Gyges on 2017/6/29.
 */
@Service(value = "iQualityCollectService")
public class QualityCollectServiceImpl implements IQualityCollectService {

    public static final Logger logger = LoggerFactory.getLogger(QualityCollectServiceImpl.class);

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private QualityCollectionMapper collectionMapper;
    @Autowired
    private QualityMapper qualityMapper;
    @Autowired
    private SpCollectMapper spCollectMapper;
    @Autowired
    private KilnMapper kilnMapper;
    @Autowired
    private RankMapper rankMapper;
    @Autowired
    private QualityQuestionMapper qualityQuestionMapper;


    /**
     * 更新增加
     *
     * @param qualityCollection
     * @return
     */
    @Override
    public ServerResponse<String> addOrUpdateInfo(QualityCollection qualityCollection) {
        if (qualityCollection.getId() == null) {
            qualityCollection.setCount(0);//次数默认为0
            qualityCollection.setStatus(1);
            int resultCount = collectionMapper.insert(qualityCollection);
            if (resultCount > 0) {
                return ServerResponse.createBySuccess("插入质量采集问题信息成功");
            }
            return ServerResponse.createBySuccess("插入质量采集问题信息失败");
        } else {
            qualityCollection.setStatus(2);
            int rowCount = collectionMapper.updateByPrimaryKeySelective(qualityCollection);
            if (rowCount > 0) {
                return ServerResponse.createBySuccess("更新质量采集问题成功");
            }
            return ServerResponse.createBySuccess("更新质量采集问题失败");
        }
    }


    /**
     * 修改页面显示采集信息。
     * @param workerId
     * @param orgId
     * @return
     */
    public ServerResponse getCollectInfoDetail(Integer workerId, Integer orgId,String startTime,String endTime) {
        if (workerId == null) {
            return ServerResponse.createByErrorCodeAndMsg(ResponseCode.ILLEGAL_ARGUMENT.getCode(), ResponseCode.ILLEGAL_ARGUMENT.getCodeDesc());
        }
        List<QualityCollection> collectionList = collectionMapper.getCollectInfoDetail(workerId, orgId,startTime,endTime);
        List<CollectEditVo> collectEditVoList = Lists.newArrayList();
        if (collectionList.size() > 0) {
            for (QualityCollection collection : collectionList){
                collectEditVoList.add(assembleCollectEditInfo(collection,orgId));
            }
            return ServerResponse.createBySuccess(collectionList);
        }
        return ServerResponse.createByErrorMsg("获取采集历史信息失败");
    }


    private CollectEditVo assembleCollectEditInfo(QualityCollection qualityCollection,Integer orgId){
        CollectEditVo collectEditVo = new CollectEditVo();
        collectEditVo.setId(qualityCollection.getId());
        collectEditVo.setWorkerId(qualityCollection.getUserId());
        collectEditVo.setWorkerName(qualityCollection.getUserName());
        collectEditVo.setCollectId(qualityCollection.getCollectId());
        collectEditVo.setWorkerCode(qualityCollection.getUserCode());
        Kiln kiln = kilnMapper.selectByPrimaryKey(qualityCollection.getYaoluId(),orgId);
        if (kiln == null){
            collectEditVo.setYaoluName(StringUtils.EMPTY);
            collectEditVo.setYaoluId(qualityCollection.getYaoluId());
        }else {
            collectEditVo.setYaoluId(qualityCollection.getYaoluId());
            collectEditVo.setYaoluName(kiln.getTitle());
        }
        Rank rank = rankMapper.selectByPrimaryKey(qualityCollection.getRankId(),orgId);
        if (rank == null){
            collectEditVo.setRankName(StringUtils.EMPTY);
            collectEditVo.setRankId(qualityCollection.getRankId());
        }else{
            collectEditVo.setRankId(qualityCollection.getRankId());
            collectEditVo.setRankName(rank.getTitle());
        }
        SpCollect spCollect = spCollectMapper.selectByPrimaryKey(qualityCollection.getProductId(),orgId);
        if (spCollect == null){
            collectEditVo.setProductId(qualityCollection.getProductId());
            collectEditVo.setProductName(StringUtils.EMPTY);
        }else {
            collectEditVo.setProductId(qualityCollection.getProductId());
            collectEditVo.setProductName(spCollect.getProCode());
        }
        collectEditVo.setCreateTime(qualityCollection.getCreated());
        collectEditVo.setUpdateTime(qualityCollection.getModified());
        collectEditVo.setQuantity(qualityCollection.getQuantity());
        return collectEditVo;
    }


    /**
     * 获取单个用户的采集信息。
     * @param workerId
     * @param collectId
     * @param orgId
     * @return
     */
    public ServerResponse getSingleCollectInfoDetail(Integer workerId, String collectId, Integer orgId) {
        if (workerId == null || StringUtils.isBlank(collectId)) {
            return ServerResponse.createByErrorCodeAndMsg(ResponseCode.ILLEGAL_ARGUMENT.getCode(), ResponseCode.ILLEGAL_ARGUMENT.getCodeDesc());
        }
        QualityCollection qualityCollection = collectionMapper.getSingleCollectInfoDetail(orgId, workerId, collectId);
        if (qualityCollection != null) {
            CollectEditVo collectEditVo = assembleCollectEditInfo(qualityCollection,orgId);
            return ServerResponse.createBySuccess(collectEditVo);
        }
        return ServerResponse.createByErrorMsg("无该用户的采集信息");
    }

    /**
     * 获取工人列表
     * @param category
     * @param orgId
     * @return
     */
    @Override
    public ServerResponse searchUserCategoryList(Integer category, Integer orgId) {
        if (category != null) {
            List<User> userList = userMapper.getUserCategoryList(category, orgId);
            if (userList.size() > 0) {
                return ServerResponse.createBySuccess("获取工人列表成功", userList);
            }
        }
        return ServerResponse.createByErrorMsg("获取工人列表失败");
    }


    private Integer getCollectCount(Integer orgId, Integer workerId) {
//        获取当月1号的时间，获取当月最后一天的时间。
        String firstDay = CalenderUtil.getFirstDayOfCurrentMonth();
        String lastDay = CalenderUtil.getLastDayOfCurrentMonth();
        int resultCount = collectionMapper.getCollectCount(orgId, workerId, firstDay, lastDay);
        if (resultCount > 0) {
            return resultCount;
        }
        return 0;
    }



    /**
     * 获取需要采集的成型工列表
     *
     * @param categoryType 用户类别，成型工：1
     * @param orgId
     * @return
     */
    public ServerResponse getCollectUserList(Integer categoryType, Integer orgId) {
        List<UserVo> list = Lists.newArrayList();
        if (categoryType != null) {
            List<User> userList = userMapper.getUserCategoryList(categoryType, orgId);
            if (userList.size() > 0) {
                for (User user : userList) {
                    UserVo userVo = new UserVo();
                    userVo.setWorkerId(user.getId());
                    userVo.setCollectCount(getCollectCount(orgId, user.getId()));
                    userVo.setWorkerName(user.getName());
                    userVo.setWorkerCode(user.getNumstr());
                    list.add(userVo);
                }
                return ServerResponse.createBySuccess("获取工人列表成功", list);
            }
        }
        return ServerResponse.createByErrorMsg("获取工人列表失败");
    }


    public ServerResponse getCollectUserListWithFilter(String workerCode, Integer orgId) {
        List<UserVo> list = Lists.newArrayList();
        if (workerCode.equals("empty") || workerCode.equals("")) {
            List<User> userList = userMapper.getUserList(null, orgId);
            if (userList.size() > 0) {
                for (User user : userList) {
                    UserVo userVo = new UserVo();
                    userVo.setWorkerId(user.getId());
                    userVo.setCollectCount(getCollectCount(orgId, user.getId()));
                    userVo.setWorkerName(user.getName());
                    userVo.setWorkerCode(user.getNumstr());
                    list.add(userVo);
                }
                return ServerResponse.createBySuccess("获取工人列表成功", list);
            }
        } else {
            List<User> userList = userMapper.getUserList(workerCode, orgId);
            if (userList.size() > 0) {
                for (User user : userList) {
                    UserVo userVo = new UserVo();
                    userVo.setWorkerId(user.getId());
                    userVo.setCollectCount(getCollectCount(orgId, user.getId()));
                    userVo.setWorkerName(user.getName());
                    userVo.setWorkerCode(user.getNumstr());
                    list.add(userVo);
                }
                return ServerResponse.createBySuccess("获取工人列表成功", list);
            }
        }
        return ServerResponse.createByErrorMsg("获取工人列表失败");
    }


    /**
     * 获取用户产品信息
     *
     * @param status   状态值
     * @param workerId 工人id
     * @param orgId    组织结构id
     * @return
     */
    public ServerResponse getWorkerProductCode(Integer status, Integer workerId, Integer orgId) {
        if (workerId == null) {
            return ServerResponse.createByErrorCodeAndMsg(ResponseCode.ILLEGAL_ARGUMENT.getCode(), ResponseCode.ILLEGAL_ARGUMENT.getCodeDesc());
        }

        List<SpCollect> productList = spCollectMapper.getSpCollectList(status, workerId, orgId);
        List<ProductCollectVo> ProductCollectVoList = Lists.newArrayList();
        if (productList.size() > 0) {
            for (SpCollect spCollect : productList) {
                ProductCollectVo productCollectVo = new ProductCollectVo();
                productCollectVo.setProductDetail(spCollect.getProCode());
                productCollectVo.setProductId(spCollect.getProId());
                productCollectVo.setWorkerName(spCollect.getUserName());
                productCollectVo.setWorkerId(spCollect.getUserId());
                productCollectVo.setWorkerCode(spCollect.getUserCode());
                ProductCollectVoList.add(productCollectVo);
            }
            return ServerResponse.createBySuccess(ProductCollectVoList);
        }
        return ServerResponse.createByErrorCodeAndMsg(ResponseCode.ERROR.getCode(), "不存在该工人的产品列表");
    }


    public ServerResponse getQualityCategoryList(Integer status, Integer questionCollectType, Integer orgId) {
        List<Quality> qualityList = qualityMapper.selectAllQualityQuestion(status, questionCollectType, orgId);
        List<QualityVo> qualityVoList = Lists.newArrayList();
        if (qualityList.size() > 0) {
            for (Quality quality : qualityList) {
                QualityVo qualityVo = new QualityVo();
                qualityVo.setQualityIdName(quality.getTitle());
                qualityVo.setCollectType(quality.getQuestionType());
                qualityVo.setQualityId(quality.getId());
                qualityVo.setWorkerId(quality.getUserId());
                qualityVoList.add(qualityVo);
            }
            return ServerResponse.createBySuccess("获取质量问题列表成功", qualityVoList);
        }
        return ServerResponse.createByErrorMsg("获取质量问题列表失败");
    }



    @Override
    public ServerResponse getQualityCollectDetail(Integer orgId, Integer workerId, String collectId) throws GeneralSecurityException {
        if (workerId == null) {
            return ServerResponse.createByErrorCodeAndMsg(ResponseCode.ILLEGAL_ARGUMENT.getCode(), ResponseCode.ILLEGAL_ARGUMENT.getCodeDesc());
        }
        CollectDetail collectDetail = null;
        QualityCollection qualityCollection = collectionMapper.getAllCollectionList(orgId, workerId, collectId);
        if (qualityCollection != null) {
            collectDetail = assembleCollectDetail(qualityCollection);
            return ServerResponse.createBySuccess(collectDetail);
        }
        return ServerResponse.createByErrorMsg("获取质量采集信息详情失败");
    }

    /**
     * 组装数据
     *
     * @param collection
     * @return
     */
    private CollectDetail assembleCollectDetail(QualityCollection collection) throws GeneralSecurityException {
        CollectDetail collectDetail = new CollectDetail();
        collectDetail.setId(collection.getId());//用于修改数据
        Kiln kiln = kilnMapper.selectByPrimaryKey(collection.getYaoluId(),collection.getOrgId());
        if (Objects.isNull(kiln)) {
            throw new GeneralServiceException("窑炉信息不存在");
        }
        collectDetail.setKilnName(kiln.getTitle());
        SpCollect spCollect = spCollectMapper.selectSpCollectByProductId(collection.getOrgId(), collection.getProductId(), collection.getUserId());
        if (Objects.isNull(spCollect)) {
            throw new GeneralServiceException("收坯采集的产品不存在");
        }
        collectDetail.setProductCode(spCollect.getProCode());
        collectDetail.setQuantity(collection.getQuantity());
        Rank rank = rankMapper.selectByPrimaryKey(collection.getRankId(),collection.getOrgId());
        if (Objects.isNull(rank)) {
            throw new GeneralServiceException("等级信息不存在");
        }
        collectDetail.setRankName(rank.getTitle());
        collectDetail.setWorkerName(collection.getUserName());
        collectDetail.setWorkerId(collection.getUserId());
        List<QualityTypeVo> qualityTypeVoList = Lists.newArrayList();
        List<QualityQuestion> qualityQuestionList = qualityQuestionMapper.getQualityQuestionList(null, collection.getUserId(), collection.getOrgId());
        if (CollectionUtils.isEmpty(qualityQuestionList)) {
            throw new GeneralServiceException("质量问题信息不存在");
        }
        for (QualityQuestion qualityQuestion : qualityQuestionList) {
            QualityTypeVo qualityTypeVo = new QualityTypeVo();
            qualityTypeVo.setId(qualityQuestion.getId());//用于修改数据
            qualityTypeVo.setQuestionType(qualityQuestion.getQuestionType());
            qualityTypeVo.setCoefficient(qualityQuestion.getCoefficient());
            qualityTypeVo.setCollectType(qualityQuestion.getCollectType());
            qualityTypeVo.setCollectId(qualityQuestion.getCollectId());
            qualityTypeVo.setQuestionId(qualityQuestion.getQuestionId());
            qualityTypeVo.setQuestionName(qualityQuestion.getQuestionName());
            qualityTypeVo.setQuestionWorkerName(qualityQuestion.getWorkName());
            qualityTypeVo.setQuestionQuantity(qualityQuestion.getQuantity());
            qualityTypeVoList.add(qualityTypeVo);
        }
        collectDetail.setQualityTypeVoList(qualityTypeVoList);
        return collectDetail;
    }

    /**
     * collectType
     * workerId
     */


}
