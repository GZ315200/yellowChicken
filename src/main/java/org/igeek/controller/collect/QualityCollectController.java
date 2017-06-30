package org.igeek.controller.collect;

import org.igeek.common.ServerResponse;
import org.igeek.pojo.QualityQuestion;
import org.igeek.service.IKilnService;
import org.igeek.service.IQualityCollectService;
import org.igeek.vo.KilnVo;
import org.igeek.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Set;

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
     * @param name
     * @return
     */
    @RequestMapping("get_user_list")
    @ResponseBody
    public ServerResponse<Set<UserVo>> getUserList(String name){
        return iQualityCollectService.searchUserList(name);
    }




    /**
     *获取工种信息列表
     * @param category
     * @return
     */
    @RequestMapping("get_user_category")
    @ResponseBody
    public ServerResponse<Set<UserVo>> getUserCategoryList(Integer category){
        return iQualityCollectService.searchUserCategoryList(category);
    }




}
