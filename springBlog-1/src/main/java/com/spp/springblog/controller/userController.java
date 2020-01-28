package com.spp.springblog.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spp.springblog.service.UserService;
import com.spp.springblog.vo.UserVO;
@Controller
@RequestMapping("/user")
public class userController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value="/login",method = RequestMethod.GET)
	public String login() {
		return "Login";
	}
	@RequestMapping(value="/singUp",method = RequestMethod.GET)
	public String singUp(Model model) {
		return "SingUp";
	}
	@RequestMapping(value="/singUpConfirm",method = RequestMethod.POST)
	public String singUpConfirm(UserVO userVo, RedirectAttributes redirectAttributes) {
		int result = userService.idchk(userVo);
		String error = "중복된ID 입니다.";
		if(result == 1){
			redirectAttributes.addFlashAttribute("error", true);
			return "redirect:/user/singUp";
		} else {
			userService.saveUser(userVo,"ROLE_USER");
			return "redirect:/user/login";
		}
	}
	@RequestMapping(value="/userDeleteConfirm",method = RequestMethod.POST)
	public String userDeleteConfirm(HttpServletRequest request,UserVO userVo,RedirectAttributes redirectAttributes) {
		System.out.println(userVo.getVusername());
		Boolean result = userService.userDelete(userVo);
		if(result) {
			return "redirect:/user/logout";
		} else {
			redirectAttributes.addFlashAttribute("error", true);
			return "redirect:/user/mypage";
		}
		
	}
	@RequestMapping(value="/userUpdateConfirm",method = RequestMethod.POST)
	public String userUpdateConfirm(HttpServletRequest request,UserVO userVo,RedirectAttributes redirectAttributes) {
		String oldVpassword = request.getParameter("oldVpassword");
		boolean result = userService.userUpdate(userVo,oldVpassword);
		if(result) {
			return "redirect:/";
		} else {
			redirectAttributes.addFlashAttribute("updateError", true);
			return "redirect:/user/mypage";
		}
		
	}
	
	@RequestMapping(value="/mypage",method = RequestMethod.GET)
	public String mypage(Principal principal,Model model) {
		model.addAttribute("user",principal);
		return "MyPage";
	}
}


