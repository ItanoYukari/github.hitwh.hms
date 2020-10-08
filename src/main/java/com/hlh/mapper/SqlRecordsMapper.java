package com.hlh.mapper;

import java.sql.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;


import com.hlh.pojo.SqlRecords;
@Mapper
public interface SqlRecordsMapper {
	List<SqlRecords> selectAll(Date date);
	void insertSql(String sql,Date date);
}
