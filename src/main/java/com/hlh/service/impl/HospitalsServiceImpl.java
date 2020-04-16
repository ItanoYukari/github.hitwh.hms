package com.hlh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hlh.mapper.HospitalsMapper;
import com.hlh.pojo.Hospitals;
import com.hlh.service.HospitalsService;

@Service
@Transactional
public class HospitalsServiceImpl implements HospitalsService{
	@Autowired
	private HospitalsMapper hospitalsMapper;

	@Override
	public List<Hospitals> findHospitalsByPid(Integer pid,Integer cid) {
		// TODO Auto-generated method stub
		return this.hospitalsMapper.selectHospitalsByPid(pid,cid);
	}

	@Override
	public String findHospitalsName(Integer hid) {
		// TODO Auto-generated method stub
		return hospitalsMapper.selectHospitalsName(hid);
	}
}
