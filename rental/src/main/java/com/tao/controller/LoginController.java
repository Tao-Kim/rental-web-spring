package com.tao.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.tao.domain.LoginVO;
import com.tao.service.LoginService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Controller
@AllArgsConstructor
public class LoginController {
	private LoginService loginservice;
	

	@GetMapping("/login")
	public String login() {
		return "login";
	}
		
	@PostMapping("/login")
	public String loginPost(LoginVO login, HttpSession session, RedirectAttributes reAttr) {
		log.info("loginPost !!!!---------------");
		if(loginservice.checkLogin(login.getId(), login.getPassword())) {
			session.setAttribute("admin", "true");
			log.info("loginSuccess");
			return "redirect:/admin";
		} else {
			reAttr.addFlashAttribute("loginFail", "true");
			log.info("loginfailed");
			return "redirect:/login";
		}
		

	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("admin");
		return "redirect:/";
	}
	
	@GetMapping("/deny")
	public String Deny(RedirectAttributes reAttr) {
		reAttr.addFlashAttribute("deny", "true");
		return "redirect:/";
	}


}
