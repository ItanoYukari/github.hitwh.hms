package com.hlh.pojo;



public class TempA {
	
	String hname;	
	int status;
	int id;
	int iddoctors;
	int hid;
	String departmentname;
	String doctorname;
	boolean isp;
	String date;
	int time;
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
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
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
	public int getIddoctors() {
		return iddoctors;
	}
	public void setIddoctors(int iddoctors) {
		this.iddoctors = iddoctors;
	}
	public int getHid() {
		return hid;
	}
	public void setHid(int hid) {
		this.hid = hid;
	}
	public TempA(String hname, String departmentname, String doctorname, boolean isp, String date, int time,int status,int id,int iddoctors,int hid) {
		super();
		this.hname = hname;
		this.departmentname = departmentname;
		this.doctorname = doctorname;
		this.isp = isp;
		this.date = date;
		this.time = time;
		this.status=status;
		this.id=id;
		this.hid=hid;
		this.iddoctors=iddoctors;
	}
	
}
