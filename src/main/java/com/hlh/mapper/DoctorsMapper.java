package com.hlh.mapper;

import java.sql.Date;
import java.util.List;

import com.hlh.pojo.Hospitals;
import com.hlh.pojo.Users;
import com.hlh.pojo.Doctors;

public interface DoctorsMapper {
	String selectDoctorsDepartment(int iddoctors,int hid);
	Doctors selectDoctorsNameIsp(int iddoctors,int hid);
	List<Doctors> selectAll();
	List<Doctors> selectDoctors(int hid,int did,Date date);
}
