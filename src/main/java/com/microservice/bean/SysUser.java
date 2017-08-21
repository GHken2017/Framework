/*
 * Copyright 2017 licensed to mbpsoft Co, Ltd;
 * You may not use this file except in compliance with the 'License' from mbpsoft company
 * Please contact at info@mbpsoft.com
 */
package com.microservice.bean;

import javax.validation.constraints.NotNull;


/**
 * 用户表 - entity类
 * 
 * @author MBP.Jagger
 *
 */
public class SysUser extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@NotNull
	private String userId; // 用户标识
	@NotNull
	private String loginName; // 登录名称
	@NotNull
	private String password; // 密码
	@NotNull
	private String userName; // 姓名
	private String headIcon; // 头像地址
	private String simpleSpelling; // 拼音简称
	private String genderCode; // 性别标识
	private String genderName; // 性别
	private String mobile; // 手机
	private String tel; // 电话
	private String email; // 邮箱
	private String wechat; // 微信
	private String qq; // QQ
	private String manageId; // 上级标识
	private String manager; // 上级
	private String organizeId; // 组织
	private String departmentId; // 部门
	@NotNull
	private int isLicenseCheck; // 是否允许授权登录
	private long firstVisit; // 首次登录日期
	private long previousVisit; // 第二次登录日期
	private long lastVisit; // 最近一次登录日期
	private String employeeState; // 员工状态：1、在职，2、停职，3、离职
	private String employeeStateDec; // 员工状态说明
	private String userState; // 用户状态
	private String userStateDec; // 用户状态说明
	private int isManager; // 是否管理员
	private String description; // 描述

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getHeadIcon() {
		return headIcon;
	}

	public void setHeadIcon(String headIcon) {
		this.headIcon = headIcon;
	}

	public String getSimpleSpelling() {
		return simpleSpelling;
	}

	public void setSimpleSpelling(String simpleSpelling) {
		this.simpleSpelling = simpleSpelling;
	}

	public String getGenderCode() {
		return genderCode;
	}

	public void setGenderCode(String genderCode) {
		this.genderCode = genderCode;
	}

	public String getGenderName() {
		return genderName;
	}

	public void setGenderName(String genderName) {
		this.genderName = genderName;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getWechat() {
		return wechat;
	}

	public void setWechat(String wechat) {
		this.wechat = wechat;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getManageId() {
		return manageId;
	}

	public void setManageId(String manageId) {
		this.manageId = manageId;
	}

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

	public String getOrganizeId() {
		return organizeId;
	}

	public void setOrganizeId(String organizeId) {
		this.organizeId = organizeId;
	}

	public String getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}

	public int getIsLicenseCheck() {
		return isLicenseCheck;
	}

	public void setIsLicenseCheck(int isLicenseCheck) {
		this.isLicenseCheck = isLicenseCheck;
	}

	public long getFirstVisit() {
		return firstVisit;
	}

	public void setFirstVisit(long firstVisit) {
		this.firstVisit = firstVisit;
	}

	public long getPreviousVisit() {
		return previousVisit;
	}

	public void setPreviousVisit(long previousVisit) {
		this.previousVisit = previousVisit;
	}

	public long getLastVisit() {
		return lastVisit;
	}

	public void setLastVisit(long lastVisit) {
		this.lastVisit = lastVisit;
	}

	public String getEmployeeState() {
		return employeeState;
	}

	public void setEmployeeState(String employeeState) {
		this.employeeState = employeeState;
	}

	public String getEmployeeStateDec() {
		return employeeStateDec;
	}

	public void setEmployeeStateDec(String employeeStateDec) {
		this.employeeStateDec = employeeStateDec;
	}

	public String getUserState() {
		return userState;
	}

	public void setUserState(String userState) {
		this.userState = userState;
	}

	public String getUserStateDec() {
		return userStateDec;
	}

	public void setUserStateDec(String userStateDec) {
		this.userStateDec = userStateDec;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getIsManager() {
		return isManager;
	}

	public void setIsManager(int isManager) {
		this.isManager = isManager;
	}

}
