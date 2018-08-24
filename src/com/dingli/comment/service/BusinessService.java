package com.dingli.comment.service;

import java.util.List;

import com.dingli.comment.bean.Ad;
import com.dingli.comment.bean.AdDto;
import com.dingli.comment.bean.Business;
import com.dingli.comment.bean.BusinessDto;


public interface BusinessService {
         
	
	
	public List<Business> getall();

	public void adAdd(BusinessDto addto);

	public void shanchu(int i);

	public List<Business> chaxun(String s);

	public void xiugai(BusinessDto addto);
	
}
