package com.hlh.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.hlh.pojo.Cities;
@Mapper
public interface CitiesMapper {
	List<Cities> selectCitiesByPid(Integer pid);
}
