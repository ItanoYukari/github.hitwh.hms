package com.hlh.service;

import java.util.List;

import com.hlh.pojo.Cities;

public interface CitiesService {
	public List<Cities> findCitiesByPid(Integer pid);
}
