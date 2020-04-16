package com.hlh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DemoController {
	@RequestMapping("/show")
	public String showInfo(Model model) {
		model.addAttribute("msg","Thyeleaf");
		return "china";
	}
}
