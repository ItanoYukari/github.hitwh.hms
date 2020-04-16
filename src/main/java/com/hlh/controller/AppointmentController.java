package com.hlh.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.druid.util.MapComparator;
import com.hlh.pojo.Appointments;
import com.hlh.pojo.Cities;
import com.hlh.pojo.Departments;
import com.hlh.pojo.Hospitals;
import com.hlh.pojo.Plan;
import com.hlh.pojo.Schedule;
import com.hlh.pojo.TempA;
import com.hlh.pojo.Users;
import com.hlh.service.AppointmentsService;
import com.hlh.service.CitiesService;
import com.hlh.service.DepartmentsService;
import com.hlh.service.DoctorsService;
import com.hlh.service.HospitalsService;
import com.hlh.service.ScheduleService;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("/users")
public class AppointmentController {
	@Autowired
	private HospitalsService h;
	
	@RequestMapping("/queryHospitalsJson")
	@ResponseBody
	public String queryHospitalsJson(Integer pid,Integer cid) {
		List<Hospitals> hItems = h.findHospitalsByPid(pid,cid);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("h", hItems);
		JSONObject jsonObject = new JSONObject();
		jsonObject.accumulateAll(map);
		return jsonObject.toString();

	}
	
	@Autowired
	private CitiesService c;
	@RequestMapping("/queryCitiesJson")
	@ResponseBody
	public String queryCitiesJson(Integer pid) {

		List<Cities> cItems = c.findCitiesByPid(pid);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("c", cItems);
		JSONObject jsonObject = new JSONObject();
		jsonObject.accumulateAll(map);
		return jsonObject.toString();

	}
	
	@Autowired
	private DepartmentsService d;
	@RequestMapping("/queryDepartmentsJson")
	@ResponseBody
	public String queryDepartmentsJson(Integer hid) {
		
		List<Departments> dItems = d.findDepartmentsByHid(hid);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("d", dItems);
		JSONObject jsonObject = new JSONObject();
		jsonObject.accumulateAll(map);
		return jsonObject.toString();

	}

	@Autowired
	private ScheduleService scheduleService;
	@RequestMapping("/queryScheduleJson")
	@ResponseBody
	public String queryScheduleJson(Integer hid,Integer did,Date date) {
		
		List<Schedule> schedules=scheduleService.findSchedule(hid, did, date);		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("s", schedules);
		JSONObject jsonObject = new JSONObject();
		jsonObject.accumulateAll(map);
		
		return jsonObject.toString();

	}
	

	@RequestMapping("/queryPlanJson")
	@ResponseBody
	public String queryPlanJson(Integer hid,Integer iddoctors,Date date) {
		List<Plan> appointments=a.findAppointmentsByDoctor(hid, iddoctors, date);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("a", appointments);
		JSONObject jsonObject = new JSONObject();
		jsonObject.accumulateAll(map);
		
		return jsonObject.toString();

	}
	
	@RequestMapping("/ba")
	@ResponseBody
	public void ba(Integer id) {
		a.changeStatusBa(id);

	}
	
	@RequestMapping("/getSession")
	@ResponseBody
	public String getSession(HttpSession session) {
	
				Users users=(Users)session.getAttribute("users");
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("u", users);
				JSONObject jsonObject = new JSONObject();
				//jsonObject.accumulateAll(map);
				jsonObject.accumulate("u", users);
				return jsonObject.toString();
	}
	
	@RequestMapping("/fii")
	public String fii() {
		return "fii";

	}
	
	@Autowired
	AppointmentsService a;
	@RequestMapping("/confirmappointment")
	public String confirmAppointment(Appointments appointment) {
		a.addAppointments(appointment);
		Map<String, Object> map = new HashMap<String, Object>();
		switch (appointment.getTime()) {
		case 1:
			 map.put("span", "span1");
			break;
			case 2:
				map.put("span", "span2");
				break;
			case 3:
				map.put("span", "span3");
				break;
			case 4:
				map.put("span", "span4");
				break;
			case 5:
				map.put("span", "span5");
				break;
			case 6:
				map.put("span", "span6");
				break;
			case 7:
				map.put("span", "span7");
				break;
			case 8:
				map.put("span", "span8");
				break;
			case 9:
				map.put("span", "span9");
				break;
			case 10:
				map.put("span", "span10");
				break;
			case 11:
				map.put("span", "span11");
				break;
			case 12:
				map.put("span", "span12");
				break;
			case 13:
				map.put("span", "span13");
				break;
			case 14:
				map.put("span", "span14");
				break;
			case 15:
				map.put("span", "span15");
				break;
			case 16:
				map.put("span", "span16");
				break;
			case 17:
				map.put("span", "span17");
				break;
			case 18:
				map.put("span", "span18");
				break;
			case 19:
				map.put("span", "span19");
				break;
			case 20:
				map.put("span", "span20");
				break;
			case 21:
				map.put("span", "span21");
				break;
			case 22:
				map.put("span", "span22");
				break;
			case 23:
				map.put("span", "span23");
				break;
			case 24:
				map.put("span", "span24");
				break;
			case 25:
				map.put("span", "span25");
				break;
			case 26:
				map.put("span", "span26");
				break;
		default:
			break;
		}
		map.put("hid", appointment.getHid());
		map.put("iddoctors", appointment.getIddoctors());
		map.put("date", appointment.getDate());
		scheduleService.updateSchedule(map);
		return "ok";
	}
	
	@Autowired
	private DoctorsService doctorsService;
	@RequestMapping("/queryappointmengs")
	@ResponseBody
	public String queryAppointmengs(int hid,int iddoctors) {
		
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("hname", h.findHospitalsName(hid));
		map.put("doctorname", doctorsService.findDoctorsNameIsp(iddoctors,hid).getName());
		map.put("isp", doctorsService.findDoctorsNameIsp(iddoctors,hid).getIsp());
		map.put("departmentname", doctorsService.findDoctorsDepartment(iddoctors,hid));
		JSONObject jsonObject = new JSONObject();
		jsonObject.accumulateAll(map);
		return jsonObject.toString();
	}
	
	@RequestMapping("/qaa")
	@ResponseBody
	public String qa(Integer uid) {
		
		List<Appointments> aList=a.findAppointments(uid);
		List<TempA> tempAs=new ArrayList<TempA>();
		for (int i = 0; i < aList.size(); i++) {
			String hname=h.findHospitalsName(aList.get(i).getHid());
			String departmentname=doctorsService.findDoctorsDepartment(aList.get(i).getIddoctors(),aList.get(i).getHid());
			String doctorname = doctorsService.findDoctorsNameIsp(aList.get(i).getIddoctors(),aList.get(i).getHid()).getName();
			boolean isp=doctorsService.findDoctorsNameIsp(aList.get(i).getIddoctors(),aList.get(i).getHid()).getIsp();
			Date date=new Date(aList.get(i).getDate().getTime());
			int time=aList.get(i).getTime();
			int status=aList.get(i).getStatus();
			int id=aList.get(i).getId();
			int iddoctors=aList.get(i).getIddoctors();
			int hid=aList.get(i).getHid();
			
			tempAs.add(new TempA(hname, departmentname, doctorname, isp, date.toString(), time,status,id,iddoctors,hid));
		}

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("a", tempAs);
		JSONObject jsonObject = new JSONObject();
		jsonObject.accumulateAll(map);
		return jsonObject.toString();
	}
	
	@ResponseBody
	@RequestMapping("/cona")
	public void cona(int id,int hid,int iddoctors,Date date,int time) {
		a.changeStatus(id);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("hid", hid);
		map.put("iddoctors",  iddoctors);
		map.put("date", date);
		switch (time) {
		case 1:
			 map.put("span", "span1");
			break;
			case 2:
				map.put("span", "span2");
				break;
			case 3:
				map.put("span", "span3");
				break;
			case 4:
				map.put("span", "span4");
				break;
			case 5:
				map.put("span", "span5");
				break;
			case 6:
				map.put("span", "span6");
				break;
			case 7:
				map.put("span", "span7");
				break;
			case 8:
				map.put("span", "span8");
				break;
			case 9:
				map.put("span", "span9");
				break;
			case 10:
				map.put("span", "span10");
				break;
			case 11:
				map.put("span", "span11");
				break;
			case 12:
				map.put("span", "span12");
				break;
			case 13:
				map.put("span", "span13");
				break;
			case 14:
				map.put("span", "span14");
				break;
			case 15:
				map.put("span", "span15");
				break;
			case 16:
				map.put("span", "span16");
				break;
			case 17:
				map.put("span", "span17");
				break;
			case 18:
				map.put("span", "span18");
				break;
			case 19:
				map.put("span", "span19");
				break;
			case 20:
				map.put("span", "span20");
				break;
			case 21:
				map.put("span", "span21");
				break;
			case 22:
				map.put("span", "span22");
				break;
			case 23:
				map.put("span", "span23");
				break;
			case 24:
				map.put("span", "span24");
				break;
			case 25:
				map.put("span", "span25");
				break;
			case 26:
				map.put("span", "span26");
				break;
		default:
			break;
		}
		scheduleService.updateScheduleCon(map);
	
	}
	
	
}
