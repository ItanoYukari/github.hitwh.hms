package com.hlh.pojo;

import java.sql.Date;



public class Ois {
	public Ois(int eid,int uid, String phonenumber, int id, int did, String email, Date date, String code, String issue,
			String filepath, String reply, int reward, int status) {
		super();
		this.eid=eid;
		this.uid = uid;
		this.phonenumber = phonenumber;
		this.id = id;
		this.did = did;
		this.email = email;
		this.date = date;
		this.code = code;
		this.issue = issue;
		this.filepath = filepath;
		this.reply = reply;
		this.reward = reward;
		this.status = status;
	}

	int uid;
	String phonenumber;
	int id;	
	int did;
	int eid;	
	String email;
	Date date;
	String code;
	String issue;
	String filepath;
	String reply;
	int reward;
	int status;
	
	public int getEid() {
		return eid;
	}



	public void setEid(int eid) {
		this.eid = eid;
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



	public int getDid() {
		return did;
	}



	public void setDid(int did) {
		this.did = did;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public Date getDate() {
		return date;
	}



	public void setDate(Date date) {
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



	public int getReward() {
		return reward;
	}



	public void setReward(int reward) {
		this.reward = reward;
	}



	public int getStatus() {
		return status;
	}



	public void setStatus(int status) {
		this.status = status;
	}

	
	public Ois(){
		super();
	}
	
}
