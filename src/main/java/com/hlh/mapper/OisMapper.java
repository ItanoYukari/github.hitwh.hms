package com.hlh.mapper;

import java.sql.Date;
import java.util.List;

import com.hlh.pojo.Ois;

public interface OisMapper {
	void insertOi(Ois oi);
	List<Ois> selectOisByUid(int uid);
	List<Ois> selectOisByHidIddoctors(int iddoctors,int hid,Date date);
	void updateOi(int id,String reply);
}
