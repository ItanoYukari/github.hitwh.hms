package com.hlh.service;

import java.sql.Date;
import java.util.List;

import com.hlh.pojo.Ois;

public interface OisService {
	void addOis(Ois ois);
	List<Ois> findOisByUid(int uid);
	List<Ois> findOisByHidIddoctors(int iddoctors,int hid,Date date);
	void changeOi(int id,String reply);
}
