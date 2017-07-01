package org.igeek.controller.initData;

import com.github.pagehelper.PageInfo;
import org.igeek.common.ServerResponse;
import org.igeek.pojo.Quality;
import org.igeek.service.IQualityService;
import org.igeek.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Set;

/**
 * Created by Gyges on 2017/6/28.
 */
@Controller
@RequestMapping(value = "/quality/")
public class QualityController {


    @Autowired
    private IQualityService iQualityService;

    /**
     * 更新增加质量信息
     * @param quality
     * @return
     */
    @RequestMapping(value = "addOrUpdate")
    @ResponseBody
    public ServerResponse<String> updateOrAddQuality(Quality quality) {
        return iQualityService.updateOrAddQuality(quality);
    }

    /**
     * 获得质量信息的列表
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "get_info_list")
    @ResponseBody
    public ServerResponse<PageInfo> getQualityInfoList(@RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                                                       @RequestParam(value = "pageSize", defaultValue = "10") int pageSize,
                                                       @RequestParam(value = "status",defaultValue = "1") Integer status,
                                                       @RequestParam(value = "userType",required = false) Integer userType) {
        return iQualityService.getQualityInfoList(pageNum, pageSize,status,userType);
    }



    /**
     *逻辑更新质量问题信息（逻辑删除）
     * @param qualityId
     * @return
     */
    @RequestMapping(value = "update_status")
    @ResponseBody
    public ServerResponse<String> updateQualityStatus(Integer qualityId,Integer status){
        return iQualityService.updateQualityStatus(qualityId, status);
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


}
