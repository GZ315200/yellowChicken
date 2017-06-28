package org.igeek.common;

import eu.bitwalker.useragentutils.DeviceType;

import javax.servlet.http.HttpServletRequest;

import static org.igeek.util.UserAgentUtil.getDeviceType;

/**
 * Created by Gyges on 2017/5/29.
 */
public class Const {

    public static final String CURRENT_USER = "currentUser";

    public static final String EMAIL = "email";

    public static final String USERNAME = "username";

    public static final String PHONE = "phone";

    public interface Role {
        int ROLE_CUSTOMER = 0;
        int ROLE_ADMIN = 1;
    }

    /**
     * 是否是手机和平板
     * @param request
     * @return
     */
    public static boolean isMobileOrTablet(HttpServletRequest request){
        DeviceType deviceType = getDeviceType(request);
        return DeviceType.MOBILE.equals(deviceType) || DeviceType.TABLET.equals(deviceType);
    }


}
