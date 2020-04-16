package com.hlh.pojo;

import java.sql.Date;


public class TempO2 {
	int uid;
	
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
	public String getHname() {
		return hname;
	}
	public void setHname(String hname) {
		this.hname = hname;
	}
	public String getDepartmentname() {
		return departmentname;
	}
	public void setDepartmentname(String departmentname) {
		this.departmentname = departmentname;
	}
	public String getDoctorname() {
		return doctorname;
	}
	public void setDoctorname(String doctorname) {
		this.doctorname = doctorname;
	}
	public boolean isIsp() {
		return isp;
	}
	public void setIsp(boolean isp) {
		this.isp = isp;
	}
	public String getIdnumber() {
		return idnumber;
	}
	public void setIdnumber(String idnumber) {
		this.idnumber = idnumber;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
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
	public String getFilepath() {
		return filepath;
	}
	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}

	String phonenumber;
	int id;	
	String hname;
	String departmentname;
	String doctorname;
	boolean isp;
	String idnumber;
	String date;
	String dig;
	String medicalrecord;
	String filepath;
	String reply;
	String aname;
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

	String sex;
	String age;
	public String getReply() {
		return reply;
	}
	public void setReply(String reply) {
		this.reply = reply;
	}
	
	public TempO2(int uid, String phonenumber, int id, String hname, String departmentname, String doctorname, String idnumber, String date,
			String dig, String medicalrecord, String filepath, String reply,boolean isp) {
		super();
		this.uid = uid;
		this.phonenumber = phonenumber;
		this.id = id;
		this.hname = hname;
		this.departmentname = departmentname;
		this.doctorname = doctorname;
		this.idnumber = idnumber;
		this.date = date;
		this.dig = dig;
		this.medicalrecord = medicalrecord;
		this.filepath = filepath;
		this.reply = reply;
		this.isp=isp;
	}
	
	public TempO2(int uid, String phonenumber, int id, String hname, String departmentname, String doctorname,
			boolean isp, String idnumber, String date, String dig, String medicalrecord, String filepath, String reply,
			String aname, String sex, String age) {
		super();
		this.uid = uid;
		this.phonenumber = phonenumber;
		this.id = id;
		this.hname = hname;
		this.departmentname = departmentname;
		this.doctorname = doctorname;
		this.isp = isp;
		this.idnumber = idnumber;
		this.date = date;
		this.dig = dig;
		this.medicalrecord = medicalrecord;
		this.filepath = filepath;
		this.reply = reply;
		this.aname = aname;
		this.sex = sex;
		this.age = age;
	}
}
