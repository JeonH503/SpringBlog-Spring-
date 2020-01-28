package com.spp.springblog.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.spp.springblog.service.commentService;
import com.spp.springblog.vo.commentVO;

@Controller
public class commentController {
	@Autowired
	commentService commentService;
	
	@RequestMapping(value="/commentRegist",method = RequestMethod.POST)
	public String commentRegist(commentVO commentVo) {
		commentService.commentRegist(commentVo);
		return "redirect:/post?postNo="+commentVo.getBoardNo();
	}
	
	@RequestMapping(value="/commentDelete",method = RequestMethod.POST)
	public String commentDelete(HttpServletRequest request) {
		String ino = request.getParameter("ino");
		String boardNo = request.getParameter("boardNo");
		commentService.commentDelete(ino);
		return "redirect:/post?postNo="+boardNo;
	}
	@RequestMapping(value="/commentUpdate",method = RequestMethod.POST)
	public String commentUpdate(commentVO commentVo,HttpServletRequest request) {
		String boardNo = request.getParameter("boardNo");
		commentService.commentUpdate(commentVo);
		return "redirect:/post?postNo="+boardNo;
	}
}
