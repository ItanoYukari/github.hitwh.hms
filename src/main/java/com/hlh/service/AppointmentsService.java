package com.hlh.service;

import java.sql.Date;
import java.util.List;

import com.hlh.pojo.Appointments;
import com.hlh.pojo.Plan;

public interface AppointmentsService {
	public void addAppointments(Appointments appointments) ;
	public List<Appointments> findAppointments(int uid) ;
	public void changeStatus(int id); 
	public void changeStatusBa(int id); 
	public List<Plan> findAppointmentsByDoctor(int hid,int iddoctors,Date date) ;
}
