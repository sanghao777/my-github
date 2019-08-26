package com.wlw02.zhly.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.wlw02.zhly.po.Spot;
import com.wlw02.zhly.po.User;

@Repository
public interface SpotMapper {
	
    Spot selectUserByName(@Param("username")String username);
	
	
	
    int deleteByPrimaryKey(String spId);

    int insert(Spot record);

    int insertSelective(Spot record);

    Spot selectByPrimaryKey(String spId);

    int updateByPrimaryKeySelective(Spot record);

    int updateByPrimaryKey(Spot record);
    List<Spot>   queryAll();
}