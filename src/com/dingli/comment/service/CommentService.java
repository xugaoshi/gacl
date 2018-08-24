package com.dingli.comment.service;

import java.util.List;

import com.dingli.comment.bean.Comment;
import com.dingli.comment.bean.CommentDto;


public interface CommentService {

  public 	List<CommentDto> phone();
	public 	List<CommentDto> num();
	public 	List<CommentDto> chaxun(String str);
	
}
