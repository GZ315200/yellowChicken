package org.igeek.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.igeek.common.ServerResponse;
import org.igeek.dao.OrganizationMapper;
import org.igeek.pojo.Organization;
import org.igeek.service.ILoginService;
import org.igeek.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * Created by Gyges on 2017/7/3.
 */
@Service(value = "iLoginService")
public class LoginServiceImpl implements ILoginService {


    @Autowired
    private OrganizationMapper organizationMapper;


    @Override
    public ServerResponse<Organization> login(String orgId, String username, String password) {
        int resultCount = organizationMapper.selectByOrgIdAndUsername(orgId, username);
        if (resultCount == 0) {
            return ServerResponse.createByErrorMsg("机构id或用户名错误");
        }
        String md5Password = MD5Util.MD5EncodeUtf8(password);
        Organization organization = organizationMapper.selectLogin(orgId, username, md5Password);
        if (Objects.isNull(organization)) {
            return ServerResponse.createBySuccess("密码错误");
        }
        organization.setPassword(StringUtils.EMPTY);
        return ServerResponse.createBySuccess("登录成功");
    }


    @Override
    public ServerResponse<Organization> addOrgInfo(Organization organization) {
        if (Objects.isNull(organization.getId())) {
            int resultCount = organizationMapper.selectByOrgId(organization.getOrgId());
            if (resultCount > 0) {
                return ServerResponse.createByErrorMsg("该机构信息已经存在");
            }
            String md5Password = MD5Util.MD5EncodeUtf8(organization.getPassword());
            organization.setPassword(md5Password);
            int rowCount = organizationMapper.insert(organization);
            if (rowCount > 0) {
                return ServerResponse.createBySuccess("插入机构信息成功");
            }
            return ServerResponse.createByErrorMsg("插入机构信息失败");
        } else {
            int count = organizationMapper.updateByPrimaryKeySelective(organization);
            if (count > 0) {
                return ServerResponse.createBySuccess("更新机构信息成功");
            }
            return ServerResponse.createByErrorMsg("更新机构信息失败");
        }
    }


}
