//package org.igeek.service.impl;
//
//import org.igeek.common.ResponseCode;
//import org.igeek.common.ServerResponse;
//import org.igeek.dao.CollectHomepageMapper;
//import org.igeek.dao.UserMapper;
//import org.igeek.pojo.CollectHomepage;
//import org.igeek.pojo.User;
//import org.igeek.service.ICollectHomepageService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
///**
// * Created by Gyges on 2017/7/12.
// */
//@Service(value = "iCollectHomepageService")
//public class CollectHomepageServiceImpl implements ICollectHomepageService {
//
////    public static final Logger logger = LoggerFactory.getLogger(CollectHomepageServiceImpl.class);
//
//    @Autowired
//    private CollectHomepageMapper collectHomepageMapper;
//    @Autowired
//    private UserMapper userMapper;
//
//
//    @Override
//    public ServerResponse<String> addCollectWorkerInfoAndCount(CollectHomepage collectHomepage) {
//        User user = userMapper.selectByPrimaryKey(collectHomepage.getWorkerId());
//        if (user == null) {
//            ServerResponse.createByErrorMsg("该工人信息不存在");
//        }else {
//            collectHomepage.setWorkerCode(user.getNumstr());
//            collectHomepage.setWorkerName(user.getName());
//        }
//        int rowCount = collectHomepageMapper.insert(collectHomepage);
//        if (rowCount > 0) {
//            return ServerResponse.createBySuccess("保存信息成功");
//        }
//        return ServerResponse.createByErrorMsg("保存信息失败");
//    }
//
//
//
//
//    @Override
//    public ServerResponse<String> updateCollectWorkerCount(Integer orgId, Integer workerId) {
//        if (workerId == null) {
//            return ServerResponse.createByErrorCodeAndMsg(ResponseCode.ILLEGAL_ARGUMENT.getCode(), ResponseCode.ILLEGAL_ARGUMENT.getCodeDesc());
//        }
//        CollectHomepage collectHomepage = collectHomepageMapper.getCollectWorkerInfo(orgId, workerId);
//        if (collectHomepage == null) {
//            return ServerResponse.createByErrorMsg("该人员的信息不存在");
//        }
//        int collectCount = collectHomepage.getCollectCount();
//        int rowCount = collectHomepageMapper.updateCollectWorkerCount(workerId, orgId, collectCount);
//        if (rowCount > 0) {
//            return ServerResponse.createBySuccess("更新次数成功");
//        }
//        return ServerResponse.createByErrorMsg("更新次数失败");
//    }
//
//
//
//
//
//
//}
