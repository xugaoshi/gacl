package com.dingli.comment.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.dingli.comment.bean.Ad;
import com.dingli.comment.bean.AdDto;
import com.dingli.comment.bean.Member;
import com.dingli.comment.dao.AdMapper;
import com.dingli.comment.dao.MemberMapper;

@Service
public class LoginServiceImp implements LoginService {
     @Value("${File}")
     private String filePath;
     
	@Autowired
	private MemberMapper  memberdao;
	@Autowired
	private AdMapper   adMapper;
	
	
	@Override
	public boolean checkLogin(Member m) {
	List<Member> s=	memberdao.selectByMember(m);
		return s.size()>0?true:false;
	}


	@Override
	public List<Ad> getAdlist() {
		
		List<Ad> s= adMapper.selectByallAd();
		return s;
		
	}


	@Override
	public void adAdd(AdDto addto) {
		Ad ad=new  Ad();
		
		//页面上传过来的图片占时保存到内存中
		  MultipartFile imgs=addto.getImgFile();
		  
		  //存储图片位置 以及设置图片名称
		  File savefile=new File(filePath+imgs.getOriginalFilename());
		  
		  if(!savefile.exists()){
			  
			  savefile.mkdirs();
		  }
		  
		  try {
			imgs.transferTo(savefile);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
		//将addto复制到ad里面
			BeanUtils.copyProperties(addto, ad);
			
			ad.setImgFileName(imgs.getOriginalFilename()); 
		adMapper.insert(ad);
		
	}


	@Override
	public void shanchu(Integer id) {
		adMapper.deleteByPrimaryKey(id);
		
	}


	@Override
	public void xiugai(AdDto addto) {
		Ad ad=new  Ad();
		  MultipartFile imgs=addto.getImgFile();
		  File savefile=new File(filePath+imgs.getOriginalFilename());
		  if(!savefile.exists()){
			  
			  savefile.mkdirs();
		  }
		  
		  try {
			imgs.transferTo(savefile);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			ad.setImgFileName(imgs.getOriginalFilename()); 
			BeanUtils.copyProperties(addto, ad);
		   adMapper.updateByPrimaryKeySelective(ad);
		
		
	}


	@Override
	public  List<Ad> chaxun(String s) {
		 List<Ad> w=adMapper.selectBytitle(s);
		return w;
	}


	@Override
	public List<AdDto> getAdlistForApi() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public int password(Member m) {
		memberdao.password(m);
		return 0;
	}




	



}
