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

import com.hlh.pojo.Departments;
import com.hlh.pojo.Experts;
import com.hlh.pojo.Hospitals;
import com.hlh.pojo.Plan;
import com.hlh.pojo.Schedule;
import com.hlh.pojo.TempA;
import com.hlh.pojo.TempO;
import com.hlh.pojo.TempO2;
import com.hlh.pojo.Users;
import com.hlh.pojo.Ois;
import com.hlh.service.AppointmentsService;

import com.hlh.service.DepartmentsService;
import com.hlh.service.ExpertsService;

import com.hlh.service.OisService;
import com.hlh.service.ScheduleService;
import com.hlh.service.UsersService;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("/users")
public class OIController {
	
	
	@Autowired
	private ExpertsService d;
	@RequestMapping("/queryExpertsJson")
	@ResponseBody
	public String queryExpertsJson(Integer did) {

		List<Experts> dItems = d.findExperts(did);
		
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
	public String fileUpload(TempO oi,HttpServletRequest request,HttpSession session) throws Exception{
		Cookie[] cookies = request.getCookies();
		int uid=0;
		if (cookies != null && cookies.length > 0) {
		for (Cookie c : cookies) {
		 switch (c.getName()) {
		case "uid":
				uid=Integer.parseInt(c.getValue());
				oi.setUid(Integer.parseInt(c.getValue()));
				break;
		case "did":
			oi.setDid(Integer.parseInt(c.getValue()));
			break;
		case "eid":
			oi.setEid(Integer.parseInt(c.getValue()));
			break;
		case "date":
			oi.setDate(Date.valueOf(c.getValue()));;
			break;
		default:
			break;
		}     
		
		}
		}
		Ois ois=new Ois(oi.getEid(),oi.getUid(), oi.getPhonenumber(), oi.getId(),  oi.getDid(), oi.getEmail(), oi.getDate(), oi.getCode(), oi.getIssue(), FileUtil.upload(oi.getFile(), request,uid), "",oi.getReward(),-1);
		if (u.findUserInfo(oi.getUid()).getMoney()<oi.getReward()) {
			return "failoi";
		}
		else {
			o.addOis(ois);		
			session.setAttribute("reward", oi.getReward());
			u.updateUserMoney(oi.getUid(), oi.getReward());
			//FileUtils.copyInputStreamToFile(oi.getfile().getInputStream(), new File(FileUtil.upload2(oi.getfile(), request)));
			return "okoi";
		}
		
	}
	
	@RequestMapping("/qep")
	@ResponseBody
	public String qep(int uid)  {		
		
		List<Ois> oItems = o.findOisByUid(uid);
		List<TempO2> oList=new ArrayList<>();
		for (int i = 0; i < oItems.size(); i++) {
			String departmentname=d.findExpertsDepartment(oItems.get(i).getEid());
			String expertname = d.findExpertsName(oItems.get(i).getEid()).getName();
			String uname=u.findUserInfo(oItems.get(i).getUid()).getName();
			oList.add(new TempO2(oItems.get(i).getUid(), oItems.get(i).getPhonenumber(), oItems.get(i).getId(), departmentname, expertname, oItems.get(i).getEmail(), oItems.get(i).getDate().toString(), oItems.get(i).getCode(), oItems.get(i).getIssue(), oItems.get(i).getFilepath(), oItems.get(i).getReply(),uname,oItems.get(i).getReward(),oItems.get(i).getStatus()));
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("o", oList);
		JSONObject jsonObject = new JSONObject();
		jsonObject.accumulateAll(map);
		return jsonObject.toString();
		
	}
	
	@Autowired
	private UsersService u;
	@RequestMapping("/qepexpert")
	@ResponseBody
	public String qepexpert(int eid,Date date)  {		
		
		List<Ois> oItems = o.findOisByEidDate(eid,date);
		List<TempO2> oList=new ArrayList<>();
		for (int i = 0; i < oItems.size(); i++) {			
			String departmentname=d.findExpertsDepartment(eid);
			String expertname = d.findExpertsName(eid).getName();
			String uname=u.findUserInfo(oItems.get(i).getUid()).getName();
			oList.add(new TempO2(oItems.get(i).getUid(), oItems.get(i).getPhonenumber(), oItems.get(i).getId(), departmentname, expertname, oItems.get(i).getEmail(), oItems.get(i).getDate().toString(), oItems.get(i).getCode(), oItems.get(i).getIssue(), oItems.get(i).getFilepath(), oItems.get(i).getReply(),uname,oItems.get(i).getReward(),oItems.get(i).getStatus()));
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("o", oList);
		JSONObject jsonObject = new JSONObject();
		jsonObject.accumulateAll(map);
		return jsonObject.toString();
		
	}
	@Autowired
	private ExpertsService e;
	@RequestMapping("/reply")
	@ResponseBody
	public void reply(int id,String reply)  {		
		if (o.findOisById(id).getStatus()==0) {
			e.changeCount(id);
			o.changeStatusRe(id);
		}
		
		o.changeOi(id,reply);		
	}
	
	@ResponseBody
	@RequestMapping("/cona")
	public void cona(int id,int reward,int uid) {
		o.changeStatus(id);	
		u.updateUserMoneyCo(uid, reward);
	}
	
	@ResponseBody
	@RequestMapping("/concept")
	public void concept(int id,int uid,int reward) {
		//System.out.println(reward);
		o.changeStatusCon(id);	
		u.updateUserMoneyCon(uid, reward);
		e.changeScount(id);
		e.changeMoney(id, reward);
	}

	
	
	
}
