package com.tao.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tao.service.LoginService;

import lombok.AllArgsConstructor;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/admin")
@AllArgsConstructor
public class AdminController {
	private LoginService loginservice;
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@GetMapping("*")
	public String home() {
		return "index";
	}
	@GetMapping("/shop/list")
	public String list() {
		return "shop/list";
	}
	
	@GetMapping("/shop/item")
	public String item() {
		return "shop/item";
	}
	@GetMapping("/shop/register")
	public String register() {
		return "shop/register";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@PostMapping("/login")
	public String loginPost(@RequestParam("id") String id, @RequestParam("password") String password, Model model) {
		if(loginservice.checkLogin(id, password)) {
			;
		}
		
		return "redirect:index";
	}
}
