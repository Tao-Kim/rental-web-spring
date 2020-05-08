package com.tao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

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
	

}
