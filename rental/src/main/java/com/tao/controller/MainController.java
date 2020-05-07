package com.tao.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/")
public class MainController {
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
}
