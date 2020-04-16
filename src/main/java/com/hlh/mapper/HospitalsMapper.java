package com.hlh.mapper;

import java.util.List;

import com.hlh.pojo.Hospitals;
import com.hlh.pojo.Users;

public interface HospitalsMapper {
	List<Hospitals> selectHospitalsByPid(Integer pid,Integer cid);
	String selectHospitalsName(int hid);
}
