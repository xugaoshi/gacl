package com.dingli.comment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dingli.comment.bean.CommentDto;
import com.dingli.comment.bean.Member;
import com.dingli.comment.service.OrdersService;

@Controller
public class OrdersController {
	@Autowired
	private OrdersService orderservice;
	
	 @RequestMapping("getorList")
     public String getAdlist(Model m){
		 
		  List<CommentDto> orr= orderservice.select();
		
		  m.addAttribute("orr", orr);
		  
          return "content/orderList";
          
          		
     }
	 
	 @RequestMapping("shouji")
     public String getchauxn(Model m,Member me){
		 
		  Long i=me.getPhone();
		
		  CommentDto x= orderservice.phone(i);
		 
		  System.out.println(x);
		 
		  m.addAttribute("phone", x);
		  
		  return "content/orderList";
          		
     }
	
	
	
}
