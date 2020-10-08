package com.hlh.config;

public class edge {
	String user;
	double p;
	
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public double getP() {
		return p;
	}
	public void setP(double p) {
		this.p = p;
	}
	
	public edge(String user, double p) {
		super();
		this.user = user;
		this.p = p;
	}
}
