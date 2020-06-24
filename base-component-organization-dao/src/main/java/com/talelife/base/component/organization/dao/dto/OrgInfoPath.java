package com.talelife.base.component.organization.dao.dto;

import java.io.Serializable;

/**
 * 组织路径
 * 
 * @author lwy
 * @email watye.qq.com
 * @date 2020-06-24 14:11:00
 */
public class OrgInfoPath implements Serializable {

	private static final long serialVersionUID = 2864900302640820231L;
	
	/**
	 * 原路径id
	 */
	private String oldIdPath;
	/**
	 * 原路径名称
	 */
	private String oldNamePath;
	/**
	 * 新路径id
	 */
	private String newIdPath;
	/**
	 * 新原路径名称
	 */
	private String newNamePath;
	public OrgInfoPath() {
		super();
	}
	public OrgInfoPath(String oldIdPath, String oldNamePath, String newIdPath, String newNamePath) {
		super();
		this.oldIdPath = oldIdPath;
		this.oldNamePath = oldNamePath;
		this.newIdPath = newIdPath;
		this.newNamePath = newNamePath;
	}

	public String getOldIdPath() {
		return oldIdPath;
	}
	public void setOldIdPath(String oldIdPath) {
		this.oldIdPath = oldIdPath;
	}
	public String getOldNamePath() {
		return oldNamePath;
	}
	public void setOldNamePath(String oldNamePath) {
		this.oldNamePath = oldNamePath;
	}
	public String getNewIdPath() {
		return newIdPath;
	}
	public void setNewIdPath(String newIdPath) {
		this.newIdPath = newIdPath;
	}
	public String getNewNamePath() {
		return newNamePath;
	}
	public void setNewNamePath(String newNamePath) {
		this.newNamePath = newNamePath;
	}
}