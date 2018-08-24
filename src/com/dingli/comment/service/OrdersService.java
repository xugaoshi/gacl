package com.dingli.comment.service;

import java.util.List;

import com.dingli.comment.bean.CommentDto;

public interface OrdersService {
   public List<CommentDto> select();
   public CommentDto phone(long i);
}
