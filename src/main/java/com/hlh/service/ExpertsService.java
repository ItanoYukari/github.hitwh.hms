package com.hlh.service;

import java.sql.Date;
import java.util.List;

import com.hlh.pojo.Experts;
import com.hlh.pojo.Hospitals;

public interface ExpertsService {
	public String findExpertsDepartment(Integer eid);
	public Experts findExpertsName(Integer eid);
	public List<Experts> findAll();
	public List<Experts> findExperts(int did);
	public void changeCount(int id) ;
	public void changeScount(int id) ;
	public void changeMoney(int id,int reward) ;
}
