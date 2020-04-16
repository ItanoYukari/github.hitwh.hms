package com.hlh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hlh.mapper.CitiesMapper;
import com.hlh.pojo.Cities;
import com.hlh.service.CitiesService;

@Service
@Transactional
public class CitiesServiceImpl implements CitiesService{
	@Autowired
	CitiesMapper citiesMapper;

	@Override
	public List<Cities> findCitiesByPid(Integer pid) {
		// TODO Auto-generated method stub
		List<Cities> list=citiesMapper.selectCitiesByPid(pid);
		return list;
	}
}
