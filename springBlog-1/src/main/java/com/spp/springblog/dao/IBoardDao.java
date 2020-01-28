package com.spp.springblog.dao;

import java.util.List;

import com.spp.springblog.vo.boardVO;
import com.spp.springblog.vo.naviVO;

public interface IBoardDao {
	public void write(boardVO boardVO);
	public List<boardVO> viewList();
	public List<boardVO> searchBoard(String search);
	public List<boardVO> selectTag(String tag);
	public boardVO viewDetailes(int ino);
	public void delete(int ino);
	public boardVO modify(int ino);
	public void update(boardVO boardVO);
	public List<naviVO> viewNavi();
}
