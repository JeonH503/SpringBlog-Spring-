package com.spp.springblog.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.spp.springblog.service.boardService;
import com.spp.springblog.service.commentService;
import com.spp.springblog.vo.boardVO;
@Controller
public class boardController {
	@Autowired
	private boardService boardService;
	@Autowired
	private commentService commentService;
	@RequestMapping(value="/",method = RequestMethod.GET)
	public String viewList(Model model,HttpServletRequest request,Principal principal) {
		String tag = request.getParameter("tag");
		String search = request.getParameter("search");
		model.addAttribute("boardData",boardService.viewList(tag,search));
		model.addAttribute("naviData",boardService.viewNavi());
		model.addAttribute("user",principal);
		return "viewList";
	}
	@RequestMapping(value="/write",method = RequestMethod.GET)
	public String insertPost() {
		return "writeView";
	}
	@RequestMapping(value="/writeConfirm",method = RequestMethod.POST)
	public String insertPostConfirm(boardVO boardVo) {
		String imgTag = null;
		// 이미지 태그를 추출하기 위한 정규식.
		Pattern pattern  =  Pattern.compile("<img[^>]*src=[\"']?([^>\"']+)[\"']?[^>]*>");
		// 추출할 내용.
		String content = boardVo.getVcontents();
		// 내용 중에서 이미지 태그를 찾아라!
		Matcher match = pattern.matcher(content);
		if(match.find()){ // 이미지 태그를 찾았다면,,
		    imgTag = match.group(0); // 글 내용 중에 첫번째 이미지 태그를 뽑아옴.
		    boardVo.setVfirstimg(imgTag);
		} else {
			 boardVo.setVfirstimg("<img alt=\"\" src=\"/resources/image/no-img.jpg\"/>");
		}
		
		boardService.write(boardVo);
		return "redirect:/";
	}
	@RequestMapping(value="/post",method = RequestMethod.GET)
	public String viewDetails(@RequestParam("postNo") int ino,Model model, Principal principal,HttpServletRequest request) {
		model.addAttribute("postData",boardService.viewDetailes(ino));
		model.addAttribute("user",principal);
		model.addAttribute("commentData",commentService.viewComments(request.getParameter("postNo")));
		return "viewDetailes";
	}
	
	@RequestMapping(value="/postDel",method = RequestMethod.GET)
	public String deletePost(@RequestParam("postNo") int ino) {
		boardService.delete(ino);
		return "redirect:/";
	}
	
	@RequestMapping(value="/postMod",method = RequestMethod.GET)
	public String modify(@RequestParam("postNo") int ino,Model model) {
		model.addAttribute("postData",boardService.viewDetailes(ino));
		return "viewMod";
	}
	
	@RequestMapping(value="/postModConfirm",method = RequestMethod.POST)
	public String modifyConfirm(boardVO boardVo,HttpServletRequest request) {
		String postNo = request.getParameter("ino");
		String imgTag = null;
		Pattern pattern  =  Pattern.compile("<img[^>]*src=[\"']?([^>\"']+)[\"']?[^>]*>");
		String content = boardVo.getVcontents();
		Matcher match = pattern.matcher(content);
		if(match.find()){ 
		    imgTag = match.group(0);
		    boardVo.setVfirstimg(imgTag);
		} else {
			 boardVo.setVfirstimg("<img alt=\"\" src=\"/resources/image/no-img.jpg\"/>");
		}
		boardService.update(boardVo);
		return "redirect:/post?postNo="+postNo;
	}
	
	
}