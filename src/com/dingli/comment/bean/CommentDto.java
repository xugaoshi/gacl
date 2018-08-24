package com.dingli.comment.bean;

import java.math.BigDecimal;

public class CommentDto extends Comment {
	private Long phone;
	private int num;
	 private BigDecimal price;
	 
	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public Long getPhone() {
		return phone;
	}

	public void setPhone(Long phone) {
		this.phone = phone;
	}

}
