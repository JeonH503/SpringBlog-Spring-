package com.spp.springblog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spp.springblog.dao.boardDao;
import com.spp.springblog.vo.boardVO;
import com.spp.springblog.vo.naviVO;

@Service
public class boardService implements IBoardService {
	@Autowired
	private boardDao dao;
	
	@Override
	public void write(boardVO boardVo) {
		dao.write(boardVo);
	}

	@Override
	public List<boardVO> viewList(String tag,String search) {
		if(tag != null) {
			return dao.selectTag(tag);
		} else {
			if(search != null) {
				search = '%'+search+'%';
				return dao.searchBoard(search);
			} else {
				return dao.viewList();
			}
		}
		
	}

	@Override
	public boardVO viewDetailes(int ino) {
		return dao.viewDetailes(ino);
	}

	@Override
	public void delete(int ino) {
		dao.delete(ino);
	}

	@Override
	public boardVO modify(int ino) {
		return dao.modify(ino);
	}

	@Override
	public void update(boardVO boardVO) {
		dao.update(boardVO);
	}

	@Override
	public List<naviVO> viewNavi() {
		return dao.viewNavi();
	}

}
