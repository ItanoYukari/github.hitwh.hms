package com.hlh.pojo;

import java.sql.Date;

public class SqlRecords {
	int id;
	
	String sqls;
	Date date;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSqls() {
		return sqls;
	}
	public void setSqls(String sqls) {
		this.sqls = sqls;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
}
