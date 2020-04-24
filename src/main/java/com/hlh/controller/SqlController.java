package com.hlh.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hlh.pojo.Hospitals;
import com.hlh.pojo.SqlRecords;
import com.hlh.pojo.Temps;
import com.hlh.service.SqlService;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("/users")
public class SqlController {
	
	@Autowired
	private SqlService s;
	
	@RequestMapping("/querySqlJson")
	@ResponseBody
	public String querySqlJson(Date date) {
		List<Temps> sList=new ArrayList<Temps>();
		List<SqlRecords> hItems = s.selectAll(date);
		for (int i = 0; i < hItems.size(); i++) {
			sList.add(new Temps(hItems.get(i).getSqls(), date.toString()));
			
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("s", sList);
		JSONObject jsonObject = new JSONObject();
		jsonObject.accumulateAll(map);
		return jsonObject.toString();
		
	}
}
