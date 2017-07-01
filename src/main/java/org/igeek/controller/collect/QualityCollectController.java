package org.igeek.controller.collect;

import org.igeek.common.ServerResponse;
import org.igeek.pojo.QualityCollection;
import org.igeek.service.IKilnService;
import org.igeek.service.IQualityCollectService;
import org.igeek.service.IQualityService;
import org.igeek.service.IRankService;
import org.igeek.vo.KilnVo;
import org.igeek.vo.QualityVo;
import org.igeek.vo.RankVo;
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

    @Autowired
    private IRankService iRankService;

    @Autowired
    private IQualityService iQualityService;



    @RequestMapping("addOrUpdate")
    @ResponseBody
    public ServerResponse<String> addOrUpdateInfo(QualityCollection qualityCollection){

        return null;
    }


    @RequestMapping("addOrUpdate_question")
    @ResponseBody
    public ServerResponse<String> addOrUpdateQuestion(@RequestParam(value = "quality") Integer qualitys,
                                                      @RequestParam(value = "xishu",required = false) Double coefficients,
                                                      Integer q_id, Integer q_type) {
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
     * 获得窑炉信息列表
     * @param status
     * @return
     */
    @RequestMapping("get_kilnName_list")
    @ResponseBody
    public ServerResponse<Set<KilnVo>> getKilnList(@RequestParam(defaultValue = "1",required = false) Integer status){
        return iKilnService.searchKilnNameList(status);
    }


    /**
     * 获得等级标题
     * @param status
     * @return
     */
    @RequestMapping(value = "get_rank_title")
    @ResponseBody
    public ServerResponse<Set<RankVo>> getRankTitle(@RequestParam(value = "status",defaultValue = "1") Integer status){
        return iRankService.searchRankTitle(status);
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



    /**
     * 获取工种类别列表
     * @return
     */
    @RequestMapping(value = "get_userType_list")
    @ResponseBody
    public ServerResponse<Set<UserVo>> getUserList(@RequestParam(defaultValue = "1",required = false) Integer status){
        return iQualityService.getUserList(status);
    }



    /**
     * 获取质量类别列表
     * @param status 状态
     * @param question_type 所属问题类型
     * @return
     */
    @RequestMapping("get_quality_category")
    @ResponseBody
    public ServerResponse<Set<QualityVo>> getQualityCategoryList(Integer status,Integer question_type){
        return iQualityCollectService.getQualityCategoryList(status, question_type);
    }




}
