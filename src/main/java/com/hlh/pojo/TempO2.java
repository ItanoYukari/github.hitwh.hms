package com.hlh.pojo;

import java.sql.Date;


public class TempO2 {
	int uid;
	
	public TempO2(int uid, String phonenumber, int id, String departmentname, String expertname, String email,
			String date, String code, String issue, String filepath, String reply, String uname, int reward,int status) {
		super();
		this.uid = uid;
		this.phonenumber = phonenumber;
		this.id = id;
		this.departmentname = departmentname;
		this.expertname = expertname;
		this.email = email;
		this.date = date;
		this.code = code;
		this.issue = issue;
		this.filepath = filepath;
		this.reply = reply;
		this.uname = uname;
		this.reward = reward;
		this.status=status;
	}
	String phonenumber;
	int id;	
	String departmentname;
	String expertname;
	String email;
	String date;
	String code;
	String issue;
	String filepath;
	String reply;
	String uname;
	int reward;
	int status;
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDepartmentname() {
		return departmentname;
	}
	public void setDepartmentname(String departmentname) {
		this.departmentname = departmentname;
	}
	public String getExpertname() {
		return expertname;
	}
	public void setExpertname(String expertname) {
		this.expertname = expertname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getIssue() {
		return issue;
	}
	public void setIssue(String issue) {
		this.issue = issue;
	}
	public String getFilepath() {
		return filepath;
	}
	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}
	public String getReply() {
		return reply;
	}
	public void setReply(String reply) {
		this.reply = reply;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public int getReward() {
		return reward;
	}
	public void setReward(int reward) {
		this.reward = reward;
	}
}
