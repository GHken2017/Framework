/*
 * Copyright 2017 licensed to mbpsoft Co, Ltd;
 * You may not use this file except in compliance with the 'License' from mbpsoft company
 * Please contact at info@mbpsoft.com
 */
package com.microservice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.bean.SysUser;
import com.microservice.dao.SysUserDao;
import com.microservice.ifaces.hw.UserDto;
import com.microservice.service.UserService;
import com.microservice.util.BeanCopyUtil;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private SysUserDao sysUserDao; // 用户Dao

	@Override
	public UserDto getUser() {

		List<SysUser> sysUserList=sysUserDao.getUserList();

		UserDto userDto=BeanCopyUtil.copyProperties2Dto(sysUserList.get(0), UserDto.class);
		return userDto;
	}

}
