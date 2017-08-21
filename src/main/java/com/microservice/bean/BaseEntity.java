/*
 * Copyright 2017 licensed to mbpsoft Co, Ltd;
 * You may not use this file except in compliance with the 'License' from mbpsoft company
 * Please contact at info@mbpsoft.com
 */
package com.microservice.bean;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

/**
 * entity - 基类
 * 
 * @author MBP.Jagger
 *
 */
public class BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	protected boolean deleteMark; // 删除标识：0：正常，1：删除
	protected boolean enableMark; // 启用标识：0：停用，1：启用
	protected String createUserId;// 记录创建者id
	protected String createUserName;// 记录创建者
	protected long createDate;// 记录创建时间
	protected long createTimeStamp;// 记录创建时间
	@NotNull
	protected String modifyUserId;// 记录修改者id
	@NotNull
	protected String modifyUserName;// 记录修改者
	@NotNull
	protected long modifyDate;// 记录修改时间
	@NotNull
	protected long modifyTimeStamp;// 记录修改时间
	@NotNull
	protected String tenantId;// saas系统租户id

	public boolean isDeleteMark() {
		return deleteMark;
	}

	public void setDeleteMark(boolean deleteMark) {
		this.deleteMark = deleteMark;
	}

	public boolean isEnableMark() {
		return enableMark;
	}

	public void setEnableMark(boolean enableMark) {
		this.enableMark = enableMark;
	}

	public String getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
	}

	public String getCreateUserName() {
		return createUserName;
	}

	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName;
	}

	public long getCreateDate() {
		return createDate;
	}

	public void setCreateDate(long createDate) {
		this.createDate = createDate;
	}

	public long getCreateTimeStamp() {
		return createTimeStamp;
	}

	public void setCreateTimeStamp(long createTimeStamp) {
		this.createTimeStamp = createTimeStamp;
	}

	public String getModifyUserId() {
		return modifyUserId;
	}

	public void setModifyUserId(String modifyUserId) {
		this.modifyUserId = modifyUserId;
	}

	public String getModifyUserName() {
		return modifyUserName;
	}

	public void setModifyUserName(String modifyUserName) {
		this.modifyUserName = modifyUserName;
	}

	public long getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(long modifyDate) {
		this.modifyDate = modifyDate;
	}

	public long getModifyTimeStamp() {
		return modifyTimeStamp;
	}

	public void setModifyTimeStamp(long modifyTimeStamp) {
		this.modifyTimeStamp = modifyTimeStamp;
	}

	public String getTenantId() {
		return tenantId;
	}

	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}
}
