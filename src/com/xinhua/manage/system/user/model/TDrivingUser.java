package com.xinhua.manage.system.user.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.xinhua.manage.exam.model.DrivingReport;

/**
 * TDrivingUser entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_driving_user", catalog = "driving")
public class TDrivingUser implements java.io.Serializable {

	// Fields

	private Integer id;
	private TDrivingUserGroup TDrivingUserGroup;
	private String userName;
	private String userNickname;
	private String userPassword;
	private String userEmail;
	private String userTelephone;
	private Integer userSex;
	private String userProvince;
	private String userCity;
	private String userSection;
	private Date userLastlogintime;
	private Integer isDele;
	private List<DrivingReport> drivingReports;

	// Constructors

	/** default constructor */
	public TDrivingUser() {
	}

	/** minimal constructor */
	public TDrivingUser(String userName, String userNickname,
			String userPassword) {
		this.userName = userName;
		this.userNickname = userNickname;
		this.userPassword = userPassword;
	}

	/** full constructor */
	public TDrivingUser(TDrivingUserGroup TDrivingUserGroup, String userName,
			String userNickname, String userPassword, String userEmail,
			String userTelephone, Integer userSex, String userProvince,
			String userCity, String userSection, Date userLastlogintime,
			Integer isDele, List<DrivingReport> TDrivingReports) {
		this.TDrivingUserGroup = TDrivingUserGroup;
		this.userName = userName;
		this.userNickname = userNickname;
		this.userPassword = userPassword;
		this.userEmail = userEmail;
		this.userTelephone = userTelephone;
		this.userSex = userSex;
		this.userProvince = userProvince;
		this.userCity = userCity;
		this.userSection = userSection;
		this.userLastlogintime = userLastlogintime;
		this.isDele = isDele;
		this.drivingReports = TDrivingReports;
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_usergroup_id")
	public TDrivingUserGroup getTDrivingUserGroup() {
		return this.TDrivingUserGroup;
	}

	public void setTDrivingUserGroup(TDrivingUserGroup TDrivingUserGroup) {
		this.TDrivingUserGroup = TDrivingUserGroup;
	}

	@Column(name = "user_name", nullable = false)
	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "user_nickname", nullable = false)
	public String getUserNickname() {
		return this.userNickname;
	}

	public void setUserNickname(String userNickname) {
		this.userNickname = userNickname;
	}

	@Column(name = "user_password", nullable = false, length = 50)
	public String getUserPassword() {
		return this.userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	@Column(name = "user_email", length = 50)
	public String getUserEmail() {
		return this.userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	@Column(name = "user_telephone", length = 20)
	public String getUserTelephone() {
		return this.userTelephone;
	}

	public void setUserTelephone(String userTelephone) {
		this.userTelephone = userTelephone;
	}

	@Column(name = "user_sex")
	public Integer getUserSex() {
		return this.userSex;
	}

	public void setUserSex(Integer userSex) {
		this.userSex = userSex;
	}

	@Column(name = "user_province", length = 20)
	public String getUserProvince() {
		return this.userProvince;
	}

	public void setUserProvince(String userProvince) {
		this.userProvince = userProvince;
	}

	@Column(name = "user_city", length = 20)
	public String getUserCity() {
		return this.userCity;
	}

	public void setUserCity(String userCity) {
		this.userCity = userCity;
	}

	@Column(name = "user_section", length = 20)
	public String getUserSection() {
		return this.userSection;
	}

	public void setUserSection(String userSection) {
		this.userSection = userSection;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "user_lastlogintime", length = 0)
	public Date getUserLastlogintime() {
		return this.userLastlogintime;
	}

	public void setUserLastlogintime(Date userLastlogintime) {
		this.userLastlogintime = userLastlogintime;
	}

	@Column(name = "is_dele")
	public Integer getIsDele() {
		return this.isDele;
	}

	public void setIsDele(Integer isDele) {
		this.isDele = isDele;
	}

	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
	public List<DrivingReport> getDrivingReports() {
		return drivingReports;
	}

	public void setDrivingReports(List<DrivingReport> drivingReports) {
		this.drivingReports = drivingReports;
	}


}