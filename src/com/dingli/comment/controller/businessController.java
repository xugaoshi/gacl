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
import com.dingli.comment.bean.Business;
import com.dingli.comment.bean.BusinessDto;
import com.dingli.comment.bean.Page;
import com.dingli.comment.service.BusinessService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
public class businessController {
	
@Autowired
private BusinessService businessService;
	
	
	
	 @RequestMapping("getbuList")
     public String getAdlist(Model m,Page page){
		 
   	      PageHelper.offsetPage(page.getStart(),5);
       	  List<Business> bulist =  businessService.getall();
  	    
  	      int total = (int) new PageInfo<>(bulist).getTotal();
          page.caculateLast(total);
          
          m.addAttribute("bulist", bulist);
          return "content/businessList";
          		
     }
	 
	 @RequestMapping("buAdd1")
     public String tiaozhuan(Model m){
   
          return "content/businessAdd";    		
     }
	 
	 @RequestMapping("xiugai")
     public String xiugai(Model m){
   
          return "content/businessModify";    		
     }
	 
	 
     @RequestMapping("buAdd")
     public String buAdd(Model m,BusinessDto a){
    	
   	  businessService.adAdd(a);
   	  return "redirect:getbuList";  
          		
     }
     @RequestMapping("bushanchu")
     public void shanchuad(Model m,HttpServletRequest request, HttpServletResponse response){
    	 
   	          String s=request.getParameter("key");
              int i=Integer.parseInt(s);
            
              businessService.shanchu(i);
  
   	
          		
     }
     @RequestMapping("buchaxun")
     public void chaxun(Model m,  HttpServletRequest request, HttpServletResponse response) throws IOException{
   	
   	                        String s=request.getParameter("key");
   	                        
   	                        System.out.println(s);
   	                        
   		                    PrintWriter out = response.getWriter();
   		                    
                            List<Business> adlis =  businessService.chaxun(s);
                            
                            String json=JSONObject.toJSONString(adlis);
                           
                            out.write(json);
   
   	  
     }
     
     @RequestMapping("xiugai1")
     public String xiugai2(Model m,BusinessDto addto){
   	  
                     businessService.xiugai(addto);

   	                   return "redirect:getbuList"; 		
     }
     
}
