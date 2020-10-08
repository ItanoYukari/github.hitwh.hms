package com.hlh.service.impl;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hlh.mapper.ExpertsMapper;
import com.hlh.mapper.HospitalsMapper;
import com.hlh.pojo.Experts;
import com.hlh.pojo.Hospitals;
import com.hlh.service.ExpertsService;


@Service
@Transactional
public class ExpertsServiceImpl implements ExpertsService{
	@Autowired
	private ExpertsMapper d;
	@Override
	public Experts findExpertsName(Integer eid) {
		// TODO Auto-generated method stub
		return d.selectExpertsName(eid);
	}
	@Override
	public String findExpertsDepartment(Integer eid) {
		// TODO Auto-generated method stub
		return d.selectExpertsDepartment(eid);
	}
	@Override
	public List<Experts> findAll() {
		// TODO Auto-generated method stub
		return d.selectAll();
	}
	@Override
	public List<Experts> findExperts(int did) {
		// TODO Auto-generated method stub
		return d.selectExperts(did);
	}
	@Override
	public void changeCount(int id) {
		// TODO Auto-generated method stub
		d.updateExpertsCount(id);
	}
	@Override
	public void changeScount(int id) {
		// TODO Auto-generated method stub
		d.updateExpertsScount(id);
	}
	@Override
	public void changeMoney(int id, int reward) {
		// TODO Auto-generated method stub
		d.updateExpertsMoney(id, reward);
	}
}
