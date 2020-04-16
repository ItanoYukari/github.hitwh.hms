package com.hlh.mapper;

import java.util.List;

import com.hlh.pojo.Users;

public interface UsersMapper {
	void insertUser(Users users);
	List<Users> selectUsersAll();
	void  updateUsers(Users users);
	Users selectUsersInfo(int id);
	void updateUsersBac(int id);
}
