package com.spp.springblog.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spp.springblog.vo.boardVO;
import com.spp.springblog.vo.naviVO;

@Repository
public class boardDao implements IBoardDao {
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public void write(boardVO boardVo) {
		sqlSession.insert("boardMapper.insertBoard",boardVo);
	}

	@Override
	public List<boardVO> viewList() {
		return sqlSession.selectList("boardMapper.selectBoard");
	}

	@Override
	public boardVO viewDetailes(int ino) {
		return sqlSession.selectOne("boardMapper.selectOnePost",ino);	
	}

	@Override
	public void delete(int ino) {
		sqlSession.delete("boardMapper.deleteBoard",ino);
	}

	@Override
	public boardVO modify(int ino) {
		return sqlSession.selectOne("boardMapper.selectOnePost",ino);
	}

	@Override
	public void update(boardVO boardVO) {
		sqlSession.update("boardMapper.updateBoard",boardVO);
	}

	@Override
	public List<naviVO> viewNavi() {
		return sqlSession.selectList("boardMapper.selectTagList");
	}
	
	@Override
	public List<boardVO> selectTag(String tag) {
		return sqlSession.selectList("boardMapper.selectTag",tag);
	}

	@Override
	public List<boardVO> searchBoard(String search) {
		return sqlSession.selectList("boardMapper.searchBoard",search);
	}

}
