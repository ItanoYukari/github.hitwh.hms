package com.hlh.pojo;

public class enode {
	String name;
	
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

	public int getSymbolSize() {
		return symbolSize;
	}

	public void setSymbolSize(int symbolSize) {
		this.symbolSize = symbolSize;
	}

	public int getCategory() {
		return category;
	}

	public void setCategory(int category) {
		this.category = category;
	}

	String deString;
	int symbolSize;
	int category;
	
	public enode(String name, String deString, int symbolSize, int category) {
		super();
		this.name = name;
		this.deString = deString;
		this.symbolSize = symbolSize;
		this.category = category;
	}
}
