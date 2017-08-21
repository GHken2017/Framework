/*
 * Copyright 2017 licensed to mbpsoft Co, Ltd;
 * You may not use this file except in compliance with the 'License' from mbpsoft company
 * Please contact at info@mbpsoft.com
 */
package com.microservice.dao;

import java.util.List;

import com.microservice.bean.SysUser;


/**
 * 用户 - Dao类
 * 
 * @author MBP.wuyuezhao
 *
 */
public interface SysUserDao {

	public List<SysUser> getUserList();

}
