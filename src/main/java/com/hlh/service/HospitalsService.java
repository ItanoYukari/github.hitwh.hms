package com.hlh.service;

import java.util.List;

import com.hlh.pojo.Hospitals;

public interface HospitalsService {
	public List<Hospitals> findHospitalsByPid(Integer pid,Integer cid) ;
	public String findHospitalsName(Integer hid);
}
