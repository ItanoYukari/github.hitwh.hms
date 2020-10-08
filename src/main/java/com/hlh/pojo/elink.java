package com.hlh.pojo;

public class elink {
	String source;
    public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getTarget() {
		return target;
	}
	public void setTarget(String target) {
		this.target = target;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDeString() {
		return deString;
	}
	public void setDeString(String deString) {
		this.deString = deString;
	}
	public elink(String source, String target, String name, String deString) {
		super();
		this.source = source;
		this.target = target;
		this.name = name;
		this.deString = deString;
	}
	String target;
    String name;
    String deString;
    
}
