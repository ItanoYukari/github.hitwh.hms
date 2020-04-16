package com.hlh.controller;

import java.io.File;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.druid.util.MapComparator;
import com.hlh.config.FileUtil;
import com.hlh.pojo.Appointments;
import com.hlh.pojo.Cities;
import com.hlh.pojo.Departments;
import com.hlh.pojo.Doctors;
import com.hlh.pojo.Hospitals;
import com.hlh.pojo.Plan;
import com.hlh.pojo.Schedule;
import com.hlh.pojo.TempA;
import com.hlh.pojo.TempO;
import com.hlh.pojo.TempO2;
import com.hlh.pojo.Users;
import com.hlh.pojo.Ois;
import com.hlh.service.AppointmentsService;
import com.hlh.service.CitiesService;
import com.hlh.service.DepartmentsService;
import com.hlh.service.DoctorsService;
import com.hlh.service.HospitalsService;
import com.hlh.service.OisService;
import com.hlh.service.ScheduleService;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("/users")
public class OIController {
	
	
	@Autowired
	private DoctorsService d;
	@RequestMapping("/queryDoctorsJson")
	@ResponseBody
	public String queryCitiesJson(Integer hid,Integer did,Date date) {

		List<Doctors> dItems = d.findDoctors(hid, did, date);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("d", dItems);
		JSONObject jsonObject = new JSONObject();
		jsonObject.accumulateAll(map);
		return jsonObject.toString();

	}
	@Autowired
	private ScheduleService s;
	@Autowired
	private OisService o;
	@RequestMapping("/onlineinquiry")
	public String fileUpload(TempO oi,HttpServletRequest request) throws Exception{
				
		
		//System.out.print(FileUtil.upload(file, request));
		Cookie[] cookies = request.getCookies();
	
		if (cookies != null && cookies.length > 0) {
		for (Cookie c : cookies) {
		 switch (c.getName()) {
		case "hid":
			oi.setHid(Integer.parseInt(c.getValue()));
			break;
		case "uid":
			oi.setUid(Integer.parseInt(c.getValue()));
			break;
		case "did":
			oi.setDid(Integer.parseInt(c.getValue()));
			break;
		case "iddoctors":
			oi.setIddoctors(Integer.parseInt(c.getValue()));
			break;
		case "date":
			oi.setDate(Date.valueOf(c.getValue()));;
			break;
		default:
			break;
		}     
		
		}
		}
		Ois ois=new Ois(oi.getUid(), oi.getPhonenumber(), oi.getId(), oi.getHid(), oi.getDid(), oi.getIddoctors(), oi.getIdnumber(), oi.getDate(), oi.getDig(), oi.getMedicalrecord(), FileUtil.upload(oi.getfile(), request), null);
		o.addOis(ois);
		s.updateScheduleOi(oi.getDate(), oi.getIddoctors(), oi.getHid());
		//FileUtils.copyInputStreamToFile(oi.getfile().getInputStream(), new File(FileUtil.upload2(oi.getfile(), request)));
		return "okoi";
	}
	@Autowired
	private HospitalsService h;
	@RequestMapping("/qep")
	@ResponseBody
	public String qep(int uid)  {		
		
		List<Ois> oItems = o.findOisByUid(uid);
		List<TempO2> oList=new ArrayList<>();
		for (int i = 0; i < oItems.size(); i++) {
			String hname=h.findHospitalsName(oItems.get(i).getHid());
			String departmentname=d.findDoctorsDepartment(oItems.get(i).getIddoctors(),oItems.get(i).getHid());
			String doctorname = d.findDoctorsNameIsp(oItems.get(i).getIddoctors(),oItems.get(i).getHid()).getName();
			boolean isp=d.findDoctorsNameIsp(oItems.get(i).getIddoctors(),oItems.get(i).getHid()).getIsp();
			oList.add(new TempO2(oItems.get(i).getUid(), oItems.get(i).getPhonenumber(), oItems.get(i).getId(), hname, departmentname, doctorname, oItems.get(i).getIdnumber(), oItems.get(i).getDate().toString(), oItems.get(i).getDig(), oItems.get(i).getMedicalrecord(), oItems.get(i).getfilepath(), oItems.get(i).getReply(),isp));
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("o", oList);
		JSONObject jsonObject = new JSONObject();
		jsonObject.accumulateAll(map);
		return jsonObject.toString();
		
	}
	
	@RequestMapping("/qepdoctor")
	@ResponseBody
	public String qepdoctor(int hid,int iddcotors,Date date)  {		
		
		List<Ois> oItems = o.findOisByHidIddoctors(iddcotors, hid,date);
		List<TempO2> oList=new ArrayList<>();
		for (int i = 0; i < oItems.size(); i++) {
			String hname=h.findHospitalsName(oItems.get(i).getHid());
			String departmentname=d.findDoctorsDepartment(oItems.get(i).getHid(),hid);
			String doctorname = d.findDoctorsNameIsp(oItems.get(i).getIddoctors(),hid).getName();
			boolean isp=d.findDoctorsNameIsp(oItems.get(i).getIddoctors(),hid).getIsp();
			oList.add(new TempO2(oItems.get(i).getUid(), oItems.get(i).getPhonenumber(), oItems.get(i).getId(), hname, departmentname, doctorname,isp, oItems.get(i).getIdnumber(), oItems.get(i).getDate().toString(), oItems.get(i).getDig(), oItems.get(i).getMedicalrecord(), oItems.get(i).getfilepath(), oItems.get(i).getReply(),oItems.get(i).getAname(),oItems.get(i).getSex(),oItems.get(i).getAge()));
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("o", oList);
		JSONObject jsonObject = new JSONObject();
		jsonObject.accumulateAll(map);
		return jsonObject.toString();
		
	}
	
	@RequestMapping("/reply")
	@ResponseBody
	public void reply(int id,String reply)  {		
		
		o.changeOi(id,reply);
		
		
	}
	
	
	
}
