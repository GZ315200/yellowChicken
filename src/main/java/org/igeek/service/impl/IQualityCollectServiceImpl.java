package org.igeek.service.impl;

import org.igeek.common.ServerResponse;
import org.igeek.dao.ProductMapper;
import org.igeek.dao.QualityCollectionMapper;
import org.igeek.dao.UserMapper;
import org.igeek.pojo.QualityQuestion;
import org.igeek.pojo.User;
import org.igeek.service.IQualityCollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Gyges on 2017/6/29.
 */
@Service(value = "iQualityCollectService")
public class IQualityCollectServiceImpl implements IQualityCollectService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private QualityCollectionMapper collectionMapper;
    @Autowired
    private ProductMapper productMapper;

    @Override
    public ServerResponse<String> addOrUpdateInfo(QualityQuestion qualityQuestion) {

        return null;
    }




    public ServerResponse<List<User>> searchUserList(String name) {
        if (name != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("%").append(name).append("%");
            name = sb.toString();
        }
        List<User> userList = userMapper.getUserList(name);
        if (userList.size() > 0){
            return ServerResponse.createBySuccess(userList);
        }
        return ServerResponse.createByErrorMsg("无法获得该姓名列表");
    }


    public ServerResponse<List<String>> searchProIdList(Integer status){

// TODO: 2017/6/30 查出产品代号，而且是成型工的.

        return null;
    }







}
