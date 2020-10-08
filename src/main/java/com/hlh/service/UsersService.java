package com.hlh.service;

import java.util.List;

import com.hlh.pojo.Users;

public interface UsersService {
	public void addUser(Users users);
	public List<Users> findUserAll();
	public void updateUser(Users users);
	public Users findUserInfo(int id); 
	public void updateUserBac(int id);
	public void updateUserMoney(int id,int reward);
	public void updateUserMoneyCon(int id,int reward);
	public void updateUserMoneyCo(int id,int reward);
	
}
