package com.hlh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hlh.mapper.DepartmentsMapper;
import com.hlh.pojo.Departments;
import com.hlh.service.DepartmentsService;

@Service
@Transactional
public class DepartmentsServiceImpl implements DepartmentsService{
	@Autowired
	DepartmentsMapper departmentsMapper;

	@Override
	public List<Departments> findDepartmentsByHid(Integer hid) {
		// TODO Auto-generated method stub
		return this.departmentsMapper.selectDepartmentsByHid(hid);
	}
}
