package com.wlw02.zhly.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.wlw02.zhly.po.Role;
import com.wlw02.zhly.po.User;
@Repository
public interface RoleMapper {
    int deleteByPrimaryKey(String rId);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(String rId);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);
    Role selectUserByName(@Param("username")String username);
	
	List<Role>   queryAll();
}