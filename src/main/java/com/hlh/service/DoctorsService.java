package com.hlh.service;

import java.sql.Date;
import java.util.List;

import com.hlh.pojo.Doctors;
import com.hlh.pojo.Hospitals;

public interface DoctorsService {
	public String findDoctorsDepartment(Integer iddoctors,Integer hid);
	public Doctors findDoctorsNameIsp(Integer iddoctors,Integer hid);
	public List<Doctors> findAll();
	public List<Doctors> findDoctors(int hid,int did,Date date);
}
