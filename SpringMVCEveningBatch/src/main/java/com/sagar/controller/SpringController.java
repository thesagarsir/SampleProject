package com.sagar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sagar.entity.Login;
import com.sagar.service.SpringService;

@Controller
public class SpringController {

	@Autowired
	SpringService service;
	
	@RequestMapping("/loginpage")
	String opeanPage() {
		return "login";
	}
	
	@RequestMapping("/login")
	public ModelAndView loginCheck(@ModelAttribute Login user) {
		System.out.println("I am in LoginCheck Method...!!!");
		System.out.println("wertyuio");
		System.out.println(user.getUsername());
		System.out.println(user.getPassword());
		
		ModelAndView mv = new ModelAndView();
		
		boolean result = service.loginCheck(user);
		if(result) {
			
			System.out.println("Login Successs....!!");
			
			mv.setViewName("redirect:/home");
		}else {
			System.out.println("Login Fail...");
			mv.setViewName("login");
		}
		
		return mv;
	}
	
	@RequestMapping("/home")
	public ModelAndView openHomePage() {
		ModelAndView mv = new ModelAndView();
	List<Login>	userList = service.getUser();
	
	if(!userList.isEmpty()) {
		System.out.println("User Data : "+userList);
		mv.addObject("list", userList);
		mv.setViewName("home");
		
	}else {
		System.out.println("No Data Found...!!");
		mv.addObject("msg", "Data is not available");
		mv.setViewName("home");
	}
		
		return mv;
	}
	
	
	@RequestMapping("/deleteuser")
	public ModelAndView deleteUser(@RequestParam("id")String id) {
		
	int userid = Integer.parseInt(id);
	System.out.println(userid);
	ModelAndView mv = new ModelAndView();
	boolean result = service.deleteUser(userid);
	if(result) {
		List<Login>	userList = service.getUser();
		mv.addObject("list", userList);
		mv.setViewName("home");
	}else {
		System.out.println("No record available....");
		mv.addObject("msg", "No record available....");
	}
	
	return mv;
		
	}
	
	@RequestMapping("/siddhhesshhhh")
	String openAddUserPage() {
		return "adduser";
	}
	
	@RequestMapping("adduserintotable")
	public ModelAndView addUser(@ModelAttribute Login user) {
		ModelAndView mv = new ModelAndView();
		System.out.println(user.getName());
		System.out.println(user.getContact());
		System.out.println(user.getPassword());
		System.out.println(user.getAddress());
		System.out.println(user.getUsername());
		
	boolean result = service.adduser(user);
		if(result) {
			List<Login>	userList = service.getUser();
			mv.addObject("list", userList);
			mv.setViewName("home");
		}else {
			System.out.println("No record inserted....");
			mv.addObject("msg", "No record inserted....");
		}
		
		
		return mv;
	}
}
