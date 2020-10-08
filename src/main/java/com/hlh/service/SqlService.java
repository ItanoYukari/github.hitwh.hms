package com.hlh.service;

import java.sql.Date;
import java.util.List;


import com.hlh.pojo.SqlRecords;

public interface SqlService {
	public List<SqlRecords> selectAll(Date date);
	void insertSql(String sql,Date date);
}
