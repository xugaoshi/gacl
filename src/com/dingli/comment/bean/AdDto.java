package com.dingli.comment.bean;

import org.springframework.web.multipart.MultipartFile;

public class AdDto extends Ad {
           
	private MultipartFile imgFile;
	
	private String  img;
	
	private String  imgurl;

	public String getImgurl() {
		return imgurl;
	}

	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public MultipartFile getImgFile() {
		return imgFile;
	}

	public void setImgFile(MultipartFile imgFile) {
		this.imgFile = imgFile;
	}
	
	
	
	
	
}
