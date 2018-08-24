package com.dingli.comment.service;

import java.util.List;

import com.dingli.comment.bean.Ad;
import com.dingli.comment.bean.AdDto;
import com.dingli.comment.bean.Member;

public interface LoginService {

	      public boolean checkLogin(Member m);
	    	  
	      public List<Ad> getAdlist();
	      
	      public void adAdd(AdDto addto);
	      
	      public void shanchu(Integer id);
	      
	      public void xiugai(AdDto addto);
	      
	      public  List<Ad> chaxun(String s);
	      
	     public List<AdDto> getAdlistForApi();
	     
	     public int password(Member m);
	     
	          
}
