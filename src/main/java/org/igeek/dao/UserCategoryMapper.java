package org.igeek.dao;

import org.igeek.pojo.UserCategory;

public interface UserCategoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserCategory record);

    int insertSelective(UserCategory record);

    UserCategory selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserCategory record);

    int updateByPrimaryKey(UserCategory record);
}