package com.hlh.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hlh.pojo.Doctors;
import com.hlh.pojo.Users;
import com.hlh.service.AppointmentsService;
import com.hlh.service.DoctorsService;
import com.hlh.service.UsersService;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("/users")
public class UsersController {
	@Autowired
	private UsersService usersService;
	
	@RequestMapping("/{page}")
	public String showPage(@PathVariable String page) {
		System.out.print("a");
		return page;
	}
	
	@RequestMapping("/addUser")
	public String addUser(Users users) {
		System.out.print("a");
		this.usersService.addUser(users);
		return "OK";
	}
	
	@RequestMapping("/login")
	public String login(Users users,HttpSession session) {
		boolean judge=false;
		List<Users> list=this.usersService.findUserAll();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getName().equals(users.getName())&&list.get(i).getPassword().equals(users.getPassword())) {
				session.setAttribute("users", list.get(i));
				if (list.get(i).getType()==0) {
					return "userspage";
				}
				else if(list.get(i).getType()==1) {
					return "doctorspage";
				}
				else {
					return "managerpage";
				}
				
			}
		}
		return "index";
	}
	
	@RequestMapping("/makeappointment")
	public String makeAppointment() {
		
		return "china";
	}
	
	@RequestMapping("/makeoi")
	public String makeOi() {
		
		return "chinaoi";
	}
	
	@RequestMapping("/quit")
	public String quit(HttpSession session) {
		
		session.invalidate();
		return "index";
	}
	
	@RequestMapping("/changeinfo")
	public String changeInfo(Users users,HttpSession session) {
		Users u=(Users)session.getAttribute("users");
		users.setId(u.getId());
		
		usersService.updateUser(users);
		return "pc";
	}
	
	@RequestMapping("/findinfo")
	@ResponseBody
	public String findInfo(HttpSession session) {	
		Users u=(Users)session.getAttribute("users");
		int id = u.getId();
		Users users=usersService.findUserInfo(id);		
		JSONObject jsonObject = new JSONObject();
		jsonObject.accumulate("u", users);
		return jsonObject.toString();
		

	}
	@Autowired
	DoctorsService d;
	@RequestMapping("/findall")
	@ResponseBody
	public String findAll() {	
		List<Doctors> list=this.d.findAll();		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("u", list);
		JSONObject jsonObject = new JSONObject();
		jsonObject.accumulateAll(map);
		return jsonObject.toString();
	}
	@Autowired
	AppointmentsService a;
	@RequestMapping("/bac")
	@ResponseBody
	public void bac(Integer id) {	
		usersService.updateUserBac(id);
		a.changeStatusBa(id);
	}
}
