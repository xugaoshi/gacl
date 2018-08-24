package com.dingli.comment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dingli.comment.bean.Member;
import com.dingli.comment.service.LoginService;

@Controller
public class LoginController {

	@Autowired
	private LoginService loginservice;
	
	@RequestMapping("perLogin")
	public String perLogin(){
		
		return "system/login";
		
	} 
	
	@RequestMapping("checklogin")
	public String login(Model s,Member m){
		 
		s.addAttribute("name",m.getName());
		
		if(loginservice.checkLogin(m)){
			return "system/index";
			  
	}else{
	     return "system/login";
	}
		
}
	@RequestMapping("password")
	public String name(Member m){
		loginservice.password(m);   
		return "system/login";
		
	} 
	@RequestMapping("error")
	public String error(){
	
		return "system/error";
		
	} 
}