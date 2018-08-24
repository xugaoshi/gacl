package com.dingli.comment.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONObject;
import com.dingli.comment.bean.Ad;
import com.dingli.comment.bean.AdDto;
import com.dingli.comment.bean.Page;
import com.dingli.comment.service.LoginService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
public class advanceController {
      
	@Autowired
	private LoginService loginService;
	
	      @RequestMapping("getadList")
	      public String getAdlist(Model m,Page page){
	    	  
	    	  PageHelper.offsetPage(page.getStart(),5);
	    	  
	    	  List<Ad> adlist =  loginService.getAdlist();
	    	  
	    	  int total = (int) new PageInfo<>(adlist).getTotal();
	    	  
	          page.caculateLast(total);
	          
	          m.addAttribute("adlist", adlist);
	        
	           return "content/adList";
	           		
	      }
	      
	      @RequestMapping("adAdd1")
	      public String tiaozhuan(Model m){
	    
	           return "content/adAdd";    		
	      }
	      
	      @RequestMapping("adAdd2")
	      public String xiugai(Model m,AdDto addto){
	    	  
	    	  
	    	  return "content/adModify";  	
	      }
	      
	      
	      @RequestMapping("adAdd")
	      public String asAdd(Model m,AdDto a){
	    	  
	    	  loginService.adAdd(a);
	    
	    	  return "redirect:getadList";  
	           		
	      }
	      
	   
	      @RequestMapping("shanchu")
	      public void shanchuad(Model m,HttpServletRequest request, HttpServletResponse response){
	    	  
	    	String s=request.getParameter("key");
	    	
	    	System.out.println(s);
	    	
	    	int i=Integer.parseInt(s);
	    	
	    	loginService.shanchu(i);
	   
	    
	           		
	      }
	      
	      @RequestMapping("adAdd3")
	      public String xiugai2(Model m,AdDto addto){
	    	  
	    	  loginService.xiugai(addto);
	
	    	  return "redirect:getadList"; 		
	      }
	      
	   
	      @RequestMapping("chaxun")
	      public void chaxun(Model m,  HttpServletRequest request, HttpServletResponse response) throws IOException{
	    	
	    	    String s=request.getParameter("key");
	    	    System.out.println(s);
	    		PrintWriter out = response.getWriter();
	            List<Ad> adlis =  loginService.chaxun(s);
	            String json=JSONObject.toJSONString(adlis);
	            out.write(json);
	    
	    	  
	      }
	    
}
