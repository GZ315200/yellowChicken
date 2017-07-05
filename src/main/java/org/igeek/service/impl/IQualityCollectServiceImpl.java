package org.igeek.service.impl;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import org.igeek.common.ResponseCode;
import org.igeek.common.ServerResponse;
import org.igeek.dao.QualityCollectionMapper;
import org.igeek.dao.QualityMapper;
import org.igeek.dao.SpCollectMapper;
import org.igeek.dao.UserMapper;
import org.igeek.pojo.Quality;
import org.igeek.pojo.QualityCollection;
import org.igeek.pojo.SpCollect;
import org.igeek.pojo.User;
import org.igeek.service.IQualityCollectService;
import org.igeek.vo.ProductVo;
import org.igeek.vo.QualityCollectVo;
import org.igeek.vo.QualityVo;
import org.igeek.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * Created by Gyges on 2017/6/29.
 */
@Service(value = "iQualityCollectService")
public class IQualityCollectServiceImpl implements IQualityCollectService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private QualityCollectionMapper collectionMapper;
    //    @Autowired
//    private ProductMapper productMapper;
//    @Autowired
//    private QualityQuestionMapper qualityQuestionMapper;
    @Autowired
    private QualityMapper qualityMapper;
    @Autowired
    private SpCollectMapper spCollectMapper;


    /**
     * 更新增加
     *
     * @param qualityCollection
     * @return
     */
    @Override
    public ServerResponse<String> addOrUpdateInfo(QualityCollection qualityCollection) {
//        String productList = String.valueOf(Splitter.on(",").splitToList(qualityCollection.getTypeId()));
//        if (StringUtils.isBlank(productList)) {
//            return ServerResponse.createByErrorCodeAndMsg(ResponseCode.ILLEGAL_ARGUMENT.getCode(), ResponseCode.ILLEGAL_ARGUMENT.getCodeDesc());
//        }
//        qualityCollection.setTypeId(productList);
        if (qualityCollection.getId() == null) {
            int resultCount = collectionMapper.insert(qualityCollection);
            if (resultCount > 0) {
                return ServerResponse.createBySuccess("插入质量采集问题信息成功");
            }
            return ServerResponse.createBySuccess("插入质量采集问题信息失败");
        } else {
            int rowCount = collectionMapper.updateByPrimaryKey(qualityCollection);
            if (rowCount > 0) {
                return ServerResponse.createBySuccess("更新质量采集问题成功");
            }
            return ServerResponse.createBySuccess("更新质量采集问题失败");
        }
    }


    /**
     * 1 扣系数 还是扣钱(1:扣款问题 2.扣系数问题)
     * 2.更新问题列表
     * 3.选择工种类型
     *
     * @param
     * @return
     */


    public ServerResponse<Set<UserVo>> searchUserList(String name) {
        Set<UserVo> userVoList = Sets.newHashSet();
        if (name != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("%").append(name).append("%");
            name = sb.toString();
        }
        List<User> userList = userMapper.getUserList(name);
        if (userList.size() > 0) {
            for (User user : userList) {
                UserVo userVo = new UserVo();
                userVo.setUserNameCode(user.getNumstr() + "-" + user.getName());
                userVoList.add(userVo);
            }
            return ServerResponse.createBySuccess(userVoList);
        }
        return ServerResponse.createByErrorMsg("无法获得该姓名列表");
    }


    @Override
    public ServerResponse<Set<UserVo>> searchUserCategoryList(Integer category) {
        Set<UserVo> userVoList = Sets.newHashSet();
        if (category != null) {
            List<User> userList = userMapper.getUserCategoryList(category);
            if (userList.size() > 0) {
                for (User user : userList) {
                    UserVo userVo = new UserVo();
                    userVo.setUserNameCode(user.getNumstr() + "-" + user.getName());
                    userVoList.add(userVo);
                }
                return ServerResponse.createBySuccess("获取工人列表成功", userVoList);
            }
        }
        return ServerResponse.createByErrorMsg("获取工人列表失败");
    }


    public ServerResponse<Set<ProductVo>> searchProIdList(Integer status) {
// TODO: 2017/6/30 查出产品代号，而且是成型工的.
        List<SpCollect> productList = spCollectMapper.getSpCollectList(status);
        Set<ProductVo> productVoSet = Sets.newHashSet();
        if (productList.size() > 0) {
            for (SpCollect spCollect : productList) {
                ProductVo productVo = new ProductVo();
                productVo.setProductDetail(spCollect.getProId() + "-" + spCollect.getProCode());
                productVo.setWorkerName(spCollect.getUserCode() + "-"+ spCollect.getUserName());
                productVoSet.add(productVo);
            }
            return ServerResponse.createBySuccess(productVoSet);
        }
        return ServerResponse.createByErrorMsg("查询成型工对应产品列表失败");
    }



    public ServerResponse<Set<QualityVo>> getQualityCategoryList(Integer status, Integer questionType) {
        List<Quality> qualityList = qualityMapper.selectAllQualityQuestion(status, questionType);
        Set<QualityVo> qualityVoList = Sets.newHashSet();
        if (qualityList.size() > 0) {
            for (Quality quality : qualityList) {
                QualityVo qualityVo = new QualityVo();
                qualityVo.setQualityIdName(quality.getTitle());
                qualityVo.setQuestionType(quality.getQuestionType());
                qualityVo.setQualityId(quality.getId());
                qualityVoList.add(qualityVo);
            }
            return ServerResponse.createBySuccess("获取质量问题列表成功", qualityVoList);
        }
        return ServerResponse.createByErrorMsg("获取质量问题列表失败");
    }


    @Override
    public ServerResponse<List<QualityCollectVo>> getQualityCollectInfo(Integer userId) {
        List<QualityCollection> qualityCollectionList = collectionMapper.getQualityCollection(userId);
        List<QualityCollectVo> qualityCollectVoList = Lists.newArrayList();
        if (qualityCollectionList.size() > 0) {
            for (QualityCollection collection : qualityCollectionList) {
                QualityCollectVo qualityCollectVo = assembleQualityInfo(collection);
                qualityCollectVoList.add(qualityCollectVo);
            }
            return ServerResponse.createBySuccess(qualityCollectVoList);
        }
        return ServerResponse.createByErrorMsg("获取质量采集信息失败");
    }


    /**
     * 组装数据
     * @param qualityCollection
     * @return
     */
    private QualityCollectVo assembleQualityInfo(QualityCollection qualityCollection) {
        QualityCollectVo qualityCollectVo = new QualityCollectVo();
        qualityCollectVo.setCollectId(qualityCollection.getId());
        qualityCollectVo.setFormWorkerName(qualityCollection.getUserName());
        qualityCollectVo.setFormWorkerNum(qualityCollection.getUserCode());
        qualityCollectVo.setCount(qualityCollection.getCount());
        return qualityCollectVo;
    }



    public ServerResponse<String> updateCount(Integer collectId){
        if(collectId != null) {
            int rowCount = collectionMapper.updateCollectCount(collectId);
            if (rowCount > 0){
                return ServerResponse.createBySuccess("更新采集次数成功");
            }
            return ServerResponse.createByErrorMsg("更新采集次数失败");
        }
        return ServerResponse.createByErrorCodeAndMsg(ResponseCode.ILLEGAL_ARGUMENT.getCode(),ResponseCode.ILLEGAL_ARGUMENT.getCodeDesc());
    }


}
