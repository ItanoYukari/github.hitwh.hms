package com.hlh.mapper;

import java.sql.Date;
import java.util.List;

import com.hlh.pojo.Appointments;
import com.hlh.pojo.Plan;

public interface AppointmentsMapper {
	void insertAppointments(Appointments appointments);
	List<Appointments> selectAppointmentsByUid(int uid);
	void updateStatus(int id);
	void updateStatusBa(int id);
	List<Plan> selectAppointmentsByDoctor(int hid,int iddoctors,Date date);
}
