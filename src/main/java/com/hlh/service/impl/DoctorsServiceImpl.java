package com.hlh.service.impl;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hlh.mapper.DoctorsMapper;
import com.hlh.mapper.HospitalsMapper;
import com.hlh.pojo.Doctors;
import com.hlh.pojo.Hospitals;
import com.hlh.service.DoctorsService;
import com.hlh.service.HospitalsService;

@Service
@Transactional
public class DoctorsServiceImpl implements DoctorsService{
	@Autowired
	private DoctorsMapper d;
	@Override
	public Doctors findDoctorsNameIsp(Integer iddoctors,Integer hid) {
		// TODO Auto-generated method stub
		return d.selectDoctorsNameIsp(iddoctors,hid);
	}
	@Override
	public String findDoctorsDepartment(Integer iddoctors,Integer hid) {
		// TODO Auto-generated method stub
		return d.selectDoctorsDepartment(iddoctors,hid);
	}
	@Override
	public List<Doctors> findAll() {
		// TODO Auto-generated method stub
		return d.selectAll();
	}
	@Override
	public List<Doctors> findDoctors(int hid, int did,Date date) {
		// TODO Auto-generated method stub
		return d.selectDoctors(hid, did ,date);
	}
}
