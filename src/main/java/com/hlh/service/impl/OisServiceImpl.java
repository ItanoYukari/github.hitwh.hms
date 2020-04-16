package com.hlh.service.impl;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hlh.mapper.OisMapper;
import com.hlh.pojo.Ois;
import com.hlh.service.OisService;

@Service
@Transactional
public class OisServiceImpl implements OisService {
	
	@Autowired
	OisMapper o;
	@Override
	public void addOis(Ois ois) {
		// TODO Auto-generated method stub
		o.insertOi(ois);
	}
	@Override
	public List<Ois> findOisByUid(int uid) {
		// TODO Auto-generated method stub
		return o.selectOisByUid(uid);
	}
	@Override
	public List<Ois> findOisByHidIddoctors(int iddoctors, int hid,Date date) {
		// TODO Auto-generated method stub
		return o.selectOisByHidIddoctors(iddoctors, hid,date);
	}
	@Override
	public void changeOi(int id,String reply) {
		// TODO Auto-generated method stub
		o.updateOi(id,reply);
	}

}
