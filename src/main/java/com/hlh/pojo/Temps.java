package com.hlh.pojo;

public class Temps {
	String sql;
	
	String date;
	
	public Temps(String sql, String date) {
		super();
		this.sql = sql;
		this.date = date;
	}
	public String getSql() {
		return sql;
	}
	public void setSql(String sql) {
		this.sql = sql;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
}
