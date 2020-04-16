package com.hlh.pojo;

import java.sql.Date;



public class Ois {
	int uid;
	String phonenumber;
	int id;	
	int hid;
	int did;
	int iddoctors;
	String idnumber;
	Date date;
	String dig;
	String medicalrecord;
	String filepath;
	String reply;
	String aname;
	String age;
	String sex;
	
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
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
	public String getDig() {
		return dig;
	}
	public void setDig(String dig) {
		this.dig = dig;
	}
	public String getMedicalrecord() {
		return medicalrecord;
	}
	public void setMedicalrecord(String medicalrecord) {
		this.medicalrecord = medicalrecord;
	}
	public String getfilepath() {
		return filepath;
	}
	public void setfilepath(String filepath) {
		this.filepath = filepath;
	}
	
	public String getReply() {
		return reply;
	}
	public void setReply(String reply) {
		this.reply = reply;
	}	
	public Ois(){
		super();
	}
	public Ois(int uid, String phonenumber, int id, int hid, int did, int iddoctors, String idnumber, Date date,
			String dig, String medicalrecord, String filepath, String reply) {
		super();
		this.uid = uid;
		this.phonenumber = phonenumber;
		this.id = id;
		this.hid = hid;
		this.did = did;
		this.iddoctors = iddoctors;
		this.idnumber = idnumber;
		this.date = date;
		this.dig = dig;
		this.medicalrecord = medicalrecord;
		this.filepath = filepath;
		this.reply = reply;
	}
}
