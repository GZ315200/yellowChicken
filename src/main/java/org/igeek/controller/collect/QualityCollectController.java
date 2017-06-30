package org.igeek.controller.collect;

import org.igeek.common.ServerResponse;
import org.igeek.pojo.Kiln;
import org.igeek.pojo.QualityQuestion;
import org.igeek.pojo.User;
import org.igeek.service.IKilnService;
import org.igeek.service.IQualityCollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Gyges on 2017/6/29.
 */
@Controller
@RequestMapping("/quality/collect/")
public class QualityCollectController {

    @Autowired
    private IQualityCollectService iQualityCollectService;

    @Autowired
    private IKilnService iKilnService;


    @RequestMapping("addOrUpdate")
    @ResponseBody
    public ServerResponse<String> addOrUpdateInfo(QualityQuestion qualityQuestion){

        return null;
    }


    /**
     * 获得用户id、姓名列表
     * @param username
     * @return
     */
    @RequestMapping("get_user_list")
    @ResponseBody
    public ServerResponse<List<User>> getUserList(String username){
        return iQualityCollectService.searchUserList(username);
    }


    /**
     * 获得窑炉信息列表
     * @param status
     * @return
     */
    @RequestMapping("get_kilnName_list")
    @ResponseBody
    public ServerResponse<List<Kiln>> getKilnList(@RequestParam(defaultValue = "1",required = false) Integer status){
        return iKilnService.searchKilnNameList(status);
    }




}
