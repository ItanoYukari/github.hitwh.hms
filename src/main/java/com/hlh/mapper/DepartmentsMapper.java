package com.hlh.mapper;

import java.util.List;

import com.hlh.pojo.Departments;

public interface DepartmentsMapper {
	List<Departments> selectDepartmentsByHid(Integer hid);
}
