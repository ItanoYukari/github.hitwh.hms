package com.hlh.service;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import com.hlh.pojo.Schedule;

public interface ScheduleService {
	public List<Schedule> findSchedule(Integer hid,Integer did,Date date) ;
	public void updateSchedule(Map<String, Object> map) ;
	public void updateScheduleCon(Map<String, Object> map) ;
	public void updateScheduleOi(Date date,int iddoctors,int hid); 
}
