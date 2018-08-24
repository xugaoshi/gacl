package com.dingli.comment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dingli.comment.bean.CommentDto;
import com.dingli.comment.dao.OrdersMapper;

@Service
public class OrdersServiceImp implements OrdersService {

     @Autowired
     private OrdersMapper ordersMapper;
	
	@Override
	public List<CommentDto> select() {
		List<CommentDto> com=ordersMapper.select();
		return com;
	}

	@Override
	public CommentDto phone(long i) {
		CommentDto com=ordersMapper.phone(i);
		return com;
	}

}
