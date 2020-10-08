package com.hlh.mapper;

import java.sql.Date;
import java.util.List;

import com.hlh.pojo.Ois;

public interface OisMapper {
	void insertOi(Ois oi);
	List<Ois> selectOisByUid(int uid);
	Ois selectOisById(int id);
	List<Ois> selectOisByEidDate(int eid,Date date);
	void updateOi(int id,String reply);
	void changeStatus(int id);
	void changeStatusBa(int id);
	void changeStatusRe(int id);
	void changeStatusCon(int id);
}
