package com.hlh.pojo;

import java.sql.Date;

public class Appointments {
	int uid;
	String phonenumber;
	int status;
	int id;
	boolean isba;	
	int hid;
	int did;
	int iddoctors;
	String idnumber;
	Date date;
	int time;
	public boolean isIsba() {
		return isba;
	}
	public void setIsba(boolean isba) {
		this.isba = isba;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public int getHid() {
		return hid;
	}
	public void setHid(int hid) {
		this.hid = hid;
	}
	public int getDid() {
		return did;
	}
	public void setDid(int did) {
		this.did = did;
	}
	public int getIddoctors() {
		return iddoctors;
	}
	public void setIddoctors(int iddoctors) {
		this.iddoctors = iddoctors;
	}
	public String getIdnumber() {
		return idnumber;
	}
	public void setIdnumber(String idnumber) {
		this.idnumber = idnumber;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
