package org.igeek.dao;

import org.apache.ibatis.annotations.Param;
import org.igeek.pojo.Kiln;

import java.util.List;

public interface KilnMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Kiln record);

    int insertSelective(Kiln record);

    Kiln selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Kiln record);

    int updateByPrimaryKey(Kiln record);

    int selectByKilnName(@Param("kilnName") String kilnName);


    List<Kiln> selectAllList(@Param("status") String status,@Param("orgId") Integer orgId);

    int updateStatusById(@Param(value = "status") String status,
                         @Param(value = "kilnId") Integer id,
                         @Param("orgId") Integer orgId);

    List<Kiln> getKilnList(@Param("status") Integer status, @Param("orgId") Integer orgId);

}