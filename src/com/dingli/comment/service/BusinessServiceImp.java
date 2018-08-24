package com.dingli.comment.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.dingli.comment.bean.Ad;
import com.dingli.comment.bean.AdDto;
import com.dingli.comment.bean.Business;
import com.dingli.comment.bean.BusinessDto;
import com.dingli.comment.dao.BusinessMapper;


@Service
public class BusinessServiceImp implements BusinessService {
	  @Value("${File}")
	     private String filePath;    
	
	  @Autowired
	     private BusinessMapper businessMapper;
 
	  @Override
	            public List<Business> getall() {
		  
	                   List<Business> s=businessMapper.selectAllbusiness();
		                  return s;
	}

	@Override
	            public void adAdd(BusinessDto addto) {
		
                        Business ad=new  Business();
		
		              //ҳ���ϴ�������ͼƬռʱ���浽�ڴ���
		               MultipartFile imgs=addto.getImgFile();
		  
		              //�洢ͼƬλ�� �Լ�����ͼƬ����
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
		  
		               //��addto���Ƶ�ad����
			                 BeanUtils.copyProperties(addto, ad);
			
			             ad.setImgFileName(imgs.getOriginalFilename()); 
	                 	businessMapper.insert(ad);
	
		
		
	}

	@Override
	public void shanchu(int i) {
	
		businessMapper.deleteByPrimaryKey(i);
	}

	@Override
	public List<Business> chaxun(String s) {
		List<Business> w=businessMapper.selectBytitle(s);
		return w;
	}

	@Override
	public void xiugai(BusinessDto addto) {
		  Business ad=new  Business();
		  MultipartFile imgs=addto.getImgFile();
		  File savefile=new File(filePath+System.currentTimeMillis()+"-"+imgs.getOriginalFilename());
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
			businessMapper.updateByPrimaryKeySelective(ad);
	}
	
        
}
