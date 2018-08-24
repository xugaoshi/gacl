package com.dingli.comment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dingli.comment.bean.Comment;
import com.dingli.comment.bean.CommentDto;
import com.dingli.comment.service.CommentService;


@Controller
public class CommentController {
	
	@Autowired
	private CommentService commentservice;
	
	 @RequestMapping("getcoList")
     public String getAdlist(Model m){
		 
		List<CommentDto> s= commentservice.phone();
		
		List<CommentDto> n= commentservice.num();
		
		  m.addAttribute("s", s);
		  
		  m.addAttribute("n", n);
		  
      
          return "content/commentList";
          		
     }
	 @RequestMapping("chazhao")
     public String getchauxn(Model m,Comment com){
		 
		String s=com.getComment();
		
		List<CommentDto> x= commentservice.chaxun(s);
	
		  m.addAttribute("x", x);
      
          return "content/commentList";
          		
     }
}
