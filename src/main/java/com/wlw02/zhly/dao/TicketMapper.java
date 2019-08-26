package com.wlw02.zhly.dao;

import java.util.List;


import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.wlw02.zhly.po.Ticket;


@Repository
public interface TicketMapper {
    int deleteByPrimaryKey(String tId);

    int insert(Ticket record);

    int insertSelective(Ticket record);

    Ticket selectByPrimaryKey(String tId);

    int updateByPrimaryKeySelective(Ticket record);

    int updateByPrimaryKey(Ticket record);
    Ticket selectUserByName(@Param("username")String username);
	void updateUser(Ticket user);
	List<Ticket> queryAll();
}