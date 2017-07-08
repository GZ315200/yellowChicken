package org.igeek.controller.collect;

import org.igeek.common.Const;
import org.igeek.common.ServerResponse;
import org.igeek.pojo.Organization;
import org.igeek.pojo.QualityCollection;
import org.igeek.pojo.QualityQuestion;
import org.igeek.service.IKilnService;
import org.igeek.service.IQualityCollectService;
import org.igeek.service.IQualityQuestionService;
import org.igeek.service.IRankService;
import org.igeek.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Set;

/**
 * Created by Gyges on 2017/6/29.
 * 质量采集的所有接口
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
    private IQualityQuestionService iQualityQuestionService;


    /**
     * 获取质量采集的页面显示信息
     * 调通
     *
     * @param workerCode 成型工的工号 ,如果不输入查询所有的该成型工的采集信息.
     * @param workerId   workerId 成型工的id 用于判定成型工采集的唯一性
     * @return 采集的id，成型工姓名，成型工工号，采集的次数。
     */
    @RequestMapping("get_quality_collect_info")
    @ResponseBody
    public ServerResponse getQualityCollectInfo(@RequestParam(required = false) String workerCode,
                                                @RequestParam(required = false) Integer workerId,
                                                HttpSession session) {
        Organization organization = (Organization) session.getAttribute(Const.CURRENT_USER);
        if (organization == null) {
            return ServerResponse.createByErrorMsg("当前用户不存在");
        }
        return iQualityCollectService.getQualityCollectInfo(workerCode, workerId, organization.getOrgId());
    }


    /**
     * 获取成型工的产品信息
     * 获取成型工信息，
     * <p>
     * 默认输入，查出成型工的所有，id、员工代号，姓名，注浆过的产品
     *
     * @param status   已调通，
     * @param workerId 成型工的id
     * @return
     */
    @RequestMapping("get_product_code")
    @ResponseBody
    public ServerResponse<Set<ProductCollectVo>> getProductCode(@RequestParam(defaultValue = "1", required = false) Integer status,
                                                                @RequestParam(required = false) Integer workerId,
                                                                HttpSession session) {
        Organization organization = (Organization) session.getAttribute(Const.CURRENT_USER);
        if (organization == null) {
            return ServerResponse.createByErrorMsg("当前用户不存在");
        }
        return iQualityCollectService.searchProIdList(status, workerId, organization.getOrgId());
    }


    /**
     * 更新和增加质量采集问题的员工信息、质量信息，等级、数量、
     * typeId 传参时将问题类型id,用, 逗号连接。也可以不输入
     *
     * @param qualityCollection
     * @return
     */
    @RequestMapping("addOrUpdate")
    @ResponseBody
    public ServerResponse<String> addOrUpdateInfo(QualityCollection qualityCollection, HttpSession session) {
        Organization organization = (Organization) session.getAttribute(Const.CURRENT_USER);
        if (organization == null) {
            return ServerResponse.createByErrorMsg("当前用户不存在");
        }
        qualityCollection.setOrgId(organization.getOrgId());
        return iQualityCollectService.addOrUpdateInfo(qualityCollection);
    }


    /**
     * 增加或先修改问题信息
     * <p>
     * qualityId    质量问题id
     * quantity     数量
     * questionType 问题类型
     * coefficient  系数
     *
     * @return
     */
    @RequestMapping("addOrUpdate_question")
    @ResponseBody
    public ServerResponse<String> addOrUpdateQuestion(QualityQuestion qualityQuestion, HttpSession session) {
        Organization organization = (Organization) session.getAttribute(Const.CURRENT_USER);
        if (organization == null) {
            return ServerResponse.createByErrorMsg("当前用户不存在");
        }
        qualityQuestion.setOrgId(organization.getOrgId());
        return iQualityQuestionService.addOrUpdateQuestion(qualityQuestion);
    }


    /**
     * 更新采集的次数
     *
     * @param collectId 采集id
     * @param workerId  工人id
     * @param count     采集次数 + 1, count 为之前的次数
     * @return 调通
     */
    @RequestMapping("update_collect_count")
    @ResponseBody
    public ServerResponse<String> updateCollectCount(Integer collectId,
                                                     Integer workerId, Long count,
                                                     HttpSession session) {
        Organization organization = (Organization) session.getAttribute(Const.CURRENT_USER);
        if (organization == null) {
            return ServerResponse.createByErrorMsg("当前用户不存在");
        }
        return iQualityCollectService.updateCount(collectId, workerId, count, organization.getOrgId());
    }


    /**
     * 获取质量采集问题的数量和系数列表
     *
     * @param collectType 采集问题类型（1： 成型问题， 2 修坯问题， 3，喷釉，4，）
     * @param workerId    工人id
     * @return 员工id 一直不变，以不变应万变。
     * @<code> 当输入collectType时，只查出所有的问题类型的信息，没有员工的限制
     * 当输入collectType 、workId  查出该员工所对应的指定的问题信息。
     * 当输入workId 时 查出该员工下所有的问题信息。
     * </code>
     * 调通
     */

    @RequestMapping("get_quality_question_list")
    @ResponseBody
    public ServerResponse getQualityQuestionList(@RequestParam(required = false) Integer collectType,
                                                 @RequestParam(required = false) Integer workerId,
                                                 HttpSession session) {
        Organization organization = (Organization) session.getAttribute(Const.CURRENT_USER);
        if (organization == null) {
            return ServerResponse.createByErrorMsg("当前用户不存在");
        }
        return iQualityQuestionService.getQualityQuestionList(collectType, workerId, organization.getOrgId());
    }
//    /**
//     * 获得用户id、姓名列表
//     *
//     * @param name
//     * @return
//     */
//    @RequestMapping("get_user_list")
//    @ResponseBody
//    public ServerResponse<Set<UserVo>> getUserList(String name) {
//        return iQualityCollectService.searchUserList(name);


//    }


    /**
     * 获得窑炉信息列表
     *
     * @param status
     * @return 调通
     */
    @RequestMapping("get_kilnName_list")
    @ResponseBody
    public ServerResponse<Set<KilnVo>> getKilnList(@RequestParam(defaultValue = "1", required = false) Integer status,
                                                   HttpSession session) {

        Organization organization = (Organization) session.getAttribute(Const.CURRENT_USER);
        if (organization == null) {
            return ServerResponse.createByErrorMsg("当前用户不存在");
        }
        Integer orgId = organization.getOrgId();
        return iKilnService.searchKilnNameList(status, orgId);
    }


    /**
     * 获得等级标题
     *
     * @param status 已调通
     * @return
     */
    @RequestMapping(value = "get_rank_title")
    @ResponseBody
    public ServerResponse<Set<RankVo>> getRankTitle(@RequestParam(value = "status", defaultValue = "1") Integer status,
                                                    HttpSession session) {
        Organization organization = (Organization) session.getAttribute(Const.CURRENT_USER);
        if (organization == null) {
            return ServerResponse.createByErrorMsg("当前用户不存在");
        }
        return iRankService.searchRankTitle(status, organization.getOrgId());
    }


    /**
     * 获取工种信息列表
     *
     * @param category 输入员工类别（如：成型工=1）
     * @return 已经调通
     */
    @RequestMapping("get_user_category")
    @ResponseBody
    public ServerResponse<Set<UserVo>> getUserCategoryList(Integer category, HttpSession session) {
        Organization organization = (Organization) session.getAttribute(Const.CURRENT_USER);
        if (organization == null) {
            return ServerResponse.createByErrorMsg("当前用户不存在");
        }
        return iQualityCollectService.searchUserCategoryList(category, organization.getOrgId());
    }


    /**
     * 获取质量问题类别列表
     *
     * @param status              状态
     * @param questionCollectType 所属问题类型 1：成型问题，2：修坯 3：喷窑 4，登窑，5 烧窑。
     * @return 已调通
     */
    @RequestMapping("get_quality_category")
    @ResponseBody
    public ServerResponse<Set<QualityVo>> getQualityCategoryList(@RequestParam(defaultValue = "1", required = false) Integer status,
                                                                 Integer questionCollectType,
                                                                 HttpSession session) {
        Organization organization = (Organization) session.getAttribute(Const.CURRENT_USER);
        if (organization == null) {
            return ServerResponse.createByErrorMsg("当前用户不存在");
        }
        return iQualityCollectService.getQualityCategoryList(status, questionCollectType, organization.getOrgId());
    }


    /**
     * 获取质量采集信息详情
     * @param orgId
     * @param status
     * @param session
     * @return
     */
    public ServerResponse getQualityCollectDetail(Integer orgId, Integer status,
                                                  Integer userId,
                                                  HttpSession session) {
        Organization organization = (Organization) session.getAttribute(Const.CURRENT_USER);
        if (organization == null) {
            return ServerResponse.createByErrorMsg("当前用户不存在");
        }
        return null;
    }


}
