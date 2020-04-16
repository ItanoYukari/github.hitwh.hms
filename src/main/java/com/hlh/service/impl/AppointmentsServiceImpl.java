package com.hlh.service.impl;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hlh.mapper.AppointmentsMapper;
import com.hlh.pojo.Appointments;
import com.hlh.pojo.Plan;
import com.hlh.service.AppointmentsService;

@Service
@Transactional
public class AppointmentsServiceImpl implements AppointmentsService{

	
	@Autowired
	AppointmentsMapper a;
	@Override
	public void addAppointments(Appointments appointments) {
		// TODO Auto-generated method stub
		a.insertAppointments(appointments);
	}
	@Override
	public List<Appointments> findAppointments(int uid) {
		// TODO Auto-generated method stub
		return a.selectAppointmentsByUid(uid);
	}
	@Override
	public void changeStatus(int id) {
		// TODO Auto-generated method stub
		a.updateStatus(id);
	}
	@Override
	public List<Plan> findAppointmentsByDoctor(int hid, int iddoctors, Date date) {
		// TODO Auto-generated method stub
		return a.selectAppointmentsByDoctor(hid, iddoctors, date);
	}
	@Override
	public void changeStatusBa(int id) {
		// TODO Auto-generated method stub
		a.updateStatusBa(id);
	}

}
