package com.hlh.mapper;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import com.hlh.pojo.Schedule;

public interface ScheduleMapper {
	List<Schedule> selectSchedule(Integer hid,Integer did,Date date);
	void updateSchedule(Map<String, Object> map);
	void updateScheduleCon(Map<String, Object> map);
	void updateScheduleOi(Date date,int iddoctors,int hid);
}
