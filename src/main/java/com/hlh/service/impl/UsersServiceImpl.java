package com.hlh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hlh.mapper.UsersMapper;
import com.hlh.pojo.Users;
import com.hlh.service.UsersService;

@Service
@Transactional
public class UsersServiceImpl implements UsersService{
	@Autowired
	private UsersMapper usersMapper;
	@Override
	public void addUser(Users users) {
		// TODO Auto-generated method stub
		this.usersMapper.insertUser(users);
	}
	@Override
	public List<Users> findUserAll() {
		// TODO Auto-generated method stub
		return this.usersMapper.selectUsersAll();
	}
	@Override
	public void updateUser(Users users) {
		// TODO Auto-generated method stub
		this.usersMapper.updateUsers(users);
	}
	@Override
	public Users findUserInfo(int id) {
		// TODO Auto-generated method stub
		return usersMapper.selectUsersInfo(id);
	}
	@Override
	public void updateUserBac(int id) {
		// TODO Auto-generated method stub
		usersMapper.updateUsersBac(id);
	}

}
