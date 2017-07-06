package org.igeek.controller;

import org.igeek.common.Const;
import org.igeek.common.ServerResponse;
import org.igeek.pojo.Organization;
import org.igeek.service.ILoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * Created by Gyges on 2017/7/3.
 */
@Controller
@RequestMapping("/org/")
public class LoginController {

    public static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private ILoginService iLoginService;



    @RequestMapping(value = "login", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<Organization> login(String orgId, String username, String password, HttpSession session){
        ServerResponse<Organization> response = null;
        response = iLoginService.login(orgId, username, password);
        if(response.isSuccess()){
            session.setAttribute(Const.CURRENT_USER,response.getData());
        }
        return response;
    }


    /**
     * 退出
     * @param session
     * @return
     */
    @RequestMapping(value = "loginOut", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<Organization> loginOut(HttpSession session) {
        session.removeAttribute(Const.CURRENT_USER);
        return ServerResponse.createBySuccess();
    }


    /**
     * 注册机构信息
     * @param organization
     * @return
     */
    @RequestMapping(value = "register", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<Organization> register(Organization organization,HttpSession session){
//        ServerResponse<Organization> response = null;
//        organization = (Organization) session.getAttribute(Const.CURRENT_USER);
//        if (organization.getOrgId() == 1){
            return iLoginService.addOrgInfo(organization);
//        }
    }


}
