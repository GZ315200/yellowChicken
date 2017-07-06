package org.igeek.dao;

import org.apache.ibatis.annotations.Param;
import org.igeek.pojo.Organization;

public interface OrganizationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Organization record);

    int insertSelective(Organization record);

    Organization selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Organization record);

    int updateByPrimaryKey(Organization record);

    int selectByOrgId(@Param("orgId") Integer orgId);

    int selectByOrgIdAndUsername(@Param("orgId") String orgId,@Param("username") String username);

    Organization selectLogin(@Param("orgId") String orgId,@Param("username") String username,@Param("password") String password);
}