package com.dingli.comment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dingli.comment.bean.Comment;
import com.dingli.comment.bean.CommentDto;
import com.dingli.comment.dao.CommentMapper;

@Service
public class CommentServiceImp implements CommentService {
	@Autowired
	private CommentMapper commentmapper;

	@Override
	public List<CommentDto> phone() {
		List<CommentDto> s=commentmapper.phone();
		return s;
	}

	@Override
	public List<CommentDto> num() {
		List<CommentDto> s=commentmapper.num();
		return s;
	}

	@Override
	public List<CommentDto> chaxun(String str) {
		List<CommentDto> s=commentmapper.chaxun(str);
		return s;
	}

}
