package com.xinhua.manage.system.user.model;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * TDrivingUserGroup entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_driving_user_group", catalog = "driving")
public class TDrivingUserGroup implements java.io.Serializable {

	// Fields

	private Integer id;
	private Date createTime;
	private String groupName;
	private Integer isDele;
	private List<TDrivingUser> TDrivingUsers;

	// Constructors

	/** default constructor */
	public TDrivingUserGroup() {
	}

	/** full constructor */
	public TDrivingUserGroup(Date createTime, String groupName, Integer isDele,
			List<TDrivingUser> TDrivingUsers) {
		this.createTime = createTime;
		this.groupName = groupName;
		this.isDele = isDele;
		this.TDrivingUsers = TDrivingUsers;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "create_time", length = 0)
	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Column(name = "group_name")
	public String getGroupName() {
		return this.groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	@Column(name = "is_dele")
	public Integer getIsDele() {
		return this.isDele;
	}

	public void setIsDele(Integer isDele) {
		this.isDele = isDele;
	}

	

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TDrivingUserGroup")
	public List<TDrivingUser> getTDrivingUsers() {
		return TDrivingUsers;
	}

	public void setTDrivingUsers(List<TDrivingUser> tDrivingUsers) {
		TDrivingUsers = tDrivingUsers;
	}

}