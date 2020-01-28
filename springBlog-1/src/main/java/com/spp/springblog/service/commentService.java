package com.spp.springblog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spp.springblog.vo.boardVO;
import com.spp.springblog.vo.commentVO;
import com.spp.springblog.dao.commentDao;

@Service
public class commentService implements ICommentService {
	
	@Autowired
	commentDao commentDao;
	
	@Override
	public void commentRegist(commentVO commentVo) {
		commentDao.commentRegist(commentVo);
	}

	@Override
	public List<commentVO> viewComments(String postNo) {
		return commentDao.viewComments(postNo);
	}

	@Override
	public void commentDelete(String ino) {
		commentDao.commentDelete(ino);
	}

	@Override
	public void commentUpdate(commentVO commentVo) {
		commentDao.commentUpdate(commentVo);
	}
	
}
