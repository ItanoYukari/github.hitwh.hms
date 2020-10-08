package com.hlh.config;

public class Node {
	public String user;		
	boolean isj;
	int count;
	int status;//0δ���1������2����
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Node(String user, boolean isj, int count,int status) {
		super();
		this.user = user;
		this.isj = isj;
		this.count = count;
		this.status=status;
		
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public boolean isIsj() {
		return isj;
	}
	public void setIsj(boolean isj) {
		this.isj = isj;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	public void addCount() {
		this.count++;
	}
}
