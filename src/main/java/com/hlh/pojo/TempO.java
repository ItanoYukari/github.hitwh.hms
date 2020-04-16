package com.hlh.pojo;

import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;

public class TempO {
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
	public MultipartFile getfile() {
		return file;
	}
	public void setfile(MultipartFile filepath) {
		this.file = filepath;
	}
	String phonenumber;
	int id;	
	int hid;
	int did;
	int iddoctors;
	String idnumber;
	Date date;
	String dig;
	String medicalrecord;
	MultipartFile file;
	String reply;
	public String getReply() {
		return reply;
	}
	public void setReply(String reply) {
		this.reply = reply;
	}
}
