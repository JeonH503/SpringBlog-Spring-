package com.spp.springblog.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spp.springblog.vo.commentVO;

@Repository
public class commentDao implements ICommentDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public void commentRegist(commentVO commentVo) {
		sqlSession.insert("commentMapper.insertComment",commentVo);
	}

	@Override
	public List<commentVO> viewComments(String postNo) {
		return sqlSession.selectList("commentMapper.selectComment",postNo);
	}

	@Override
	public void commentDelete(String ino) {
		sqlSession.delete("commentMapper.deleteComment",ino);
	}

	@Override
	public void commentUpdate(commentVO commentVo) {
		sqlSession.update("commentMapper.updateComment",commentVo);
	}

}
