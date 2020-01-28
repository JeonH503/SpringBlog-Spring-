package com.spp.springblog.service;

import java.util.List;

import com.spp.springblog.vo.boardVO;
import com.spp.springblog.vo.naviVO;

public interface IBoardService {
	public void write (boardVO boardVO);
	public List<boardVO> viewList(String tag,String search);
	public List<naviVO> viewNavi();
	public boardVO viewDetailes(int ino);
	public void delete(int ino);
	public boardVO modify(int ino);
	public void update(boardVO boardVO);
}
