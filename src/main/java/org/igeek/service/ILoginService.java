package org.igeek.service;

import org.igeek.common.ServerResponse;
import org.igeek.pojo.Organization;

/**
 * Created by Gyges on 2017/7/3.
 */
public interface ILoginService {

    public ServerResponse<Organization> login(String orgId, String username, String password);

    public ServerResponse<Organization> addOrgInfo(Organization organization);
}
