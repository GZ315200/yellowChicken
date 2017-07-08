package org.igeek.dao;

import org.apache.ibatis.annotations.Param;
import org.igeek.pojo.User;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);


    List<User> getUserList(@Param("username") String username,@Param("orgId") Integer orgId);

    List<User> getUserCategoryList(@Param("category") Integer category , @Param("orgId") Integer orgId);

}