package org.igeek.service.impl;

import com.google.common.collect.Sets;
import org.igeek.common.ServerResponse;
import org.igeek.dao.ProductMapper;
import org.igeek.dao.QualityCollectionMapper;
import org.igeek.dao.UserMapper;
import org.igeek.pojo.QualityQuestion;
import org.igeek.pojo.User;
import org.igeek.service.IQualityCollectService;
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
    @Autowired
    private ProductMapper productMapper;

    @Override
    public ServerResponse<String> addOrUpdateInfo(QualityQuestion qualityQuestion) {


        return null;
    }


    public ServerResponse<Set<UserVo>> searchUserList(String name) {
        Set<UserVo> userVoList = Sets.newHashSet();
        if (name != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("%").append(name).append("%");
            name = sb.toString();
        }
        List<User> userList = userMapper.getUserList(name);
        if (userList.size() > 0) {
            for(User user : userList){
                UserVo userVo = new UserVo();
                userVo.setUserNameCode(user.getNumstr()+"-"+user.getName());
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
            if (userList.size() > 0){
                for(User user:userList){
                    UserVo userVo = new UserVo();
                    userVo.setUserNameCode(user.getNumstr()+"-"+user.getName());
                    userVoList.add(userVo);
                }
                return ServerResponse.createBySuccess("获取工人列表成功",userVoList);
            }
        }
        return ServerResponse.createByErrorMsg("获取工人列表失败");
    }








    public ServerResponse<List<String>> searchProIdList(Integer status) {

// TODO: 2017/6/30 查出产品代号，而且是成型工的.

        return null;
    }


}
