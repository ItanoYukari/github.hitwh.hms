package com.hlh.service;

import java.sql.Date;
import java.util.List;

import com.hlh.pojo.Ois;

public interface OisService {
	void addOis(Ois ois);
	List<Ois> findOisByUid(int uid);
	Ois findOisById(int id);
	List<Ois> findOisByEidDate(int eid,Date date);
	void changeOi(int id,String reply);
	void changeStatus(int id);
	void changeStatusBa(int id);
	void changeStatusRe(int id);
	void changeStatusCon(int id);
}
