package com.spp.springblog.service;

import java.util.List;

import com.spp.springblog.vo.commentVO;

public interface ICommentService {

	void commentRegist(commentVO commentVo);

	List<commentVO> viewComments(String postNo);

	void commentDelete(String ino);

	void commentUpdate(commentVO commentVo);

}
