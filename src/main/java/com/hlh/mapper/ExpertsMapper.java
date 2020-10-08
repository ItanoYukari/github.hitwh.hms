package com.hlh.mapper;

import java.sql.Date;
import java.util.List;

import com.hlh.pojo.Hospitals;
import com.hlh.pojo.Users;
import com.hlh.pojo.Experts;

public interface ExpertsMapper {
	String selectExpertsDepartment(int eid);
	Experts selectExpertsName(int eid);
	List<Experts> selectAll();
	List<Experts> selectExperts(int fid);
	void updateExpertsCount(int id);
	void updateExpertsScount(int id);
	void updateExpertsMoney(int id,int reward);
}
