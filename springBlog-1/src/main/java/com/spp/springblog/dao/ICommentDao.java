package com.spp.springblog.dao;

import java.util.List;

import com.spp.springblog.vo.commentVO;

public interface ICommentDao {

	void commentRegist(commentVO commentVo);

	List<commentVO> viewComments(String postNo);

	void commentDelete(String ino);

	void commentUpdate(commentVO commentVo);

}
