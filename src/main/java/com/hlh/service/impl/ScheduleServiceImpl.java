package com.hlh.service.impl;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hlh.mapper.ScheduleMapper;
import com.hlh.pojo.Schedule;
import com.hlh.service.ScheduleService;

@Service
@Transactional
public class ScheduleServiceImpl implements ScheduleService{
	
	@Autowired
	private ScheduleMapper s;
	@Override
	public List<Schedule> findSchedule(Integer hid, Integer did, Date date) {
		// TODO Auto-generated method stub
		return this.s.selectSchedule(hid, did, date);
	}
	@Override
	public void updateSchedule(Map<String, Object> map) {
		// TODO Auto-generated method stub
		s.updateSchedule(map);
	}
	@Override
	public void updateScheduleCon(Map<String, Object> map) {
		// TODO Auto-generated method stub
		s.updateScheduleCon(map);
	}
	@Override
	public void updateScheduleOi(Date date, int iddoctors, int hid) {
		// TODO Auto-generated method stub
		s.updateScheduleOi(date, iddoctors, hid);
	}

}
