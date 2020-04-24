package com.hlh.service.impl;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hlh.mapper.CitiesMapper;
import com.hlh.mapper.SqlRecordsMapper;
import com.hlh.pojo.Cities;
import com.hlh.pojo.SqlRecords;
import com.hlh.service.CitiesService;
import com.hlh.service.SqlService;

@Service
@Transactional
public class SqlServiceImpl implements SqlService{

	@Autowired
	SqlRecordsMapper s;
	@Override
	public List<SqlRecords> selectAll(Date date) {
		// TODO Auto-generated method stub
		return s.selectAll(date);
	}

	@Override
	public void insertSql(String sql,Date date) {
		// TODO Auto-generated method stub
		s.insertSql(sql, date);
	}
	
	


}
