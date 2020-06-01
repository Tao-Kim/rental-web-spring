package com.tao.controller;



import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tao.domain.ItemVO;
import com.tao.service.MainService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

/**
 * Handles requests for the application home page.
 */
@Log4j
@Controller
@RequestMapping("/")
@AllArgsConstructor
public class MainController {
	MainService mainService;

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@GetMapping("*")

	public String home(Model model) {
		List<ItemVO> items = mainService.getList();
		model.addAttribute("items", items);
		
		return "index";
	}
	
	@GetMapping("/shop/list")
	public String list(HttpServletRequest request, Model model) {
		List<ItemVO> items = null;
		String category1 = request.getParameter("category1");
		String category2 = request.getParameter("category2");
		log.info("category1 : " + category1);
		log.info("category2 : " + category2);
		if(category2 == null) {
			items = mainService.getListByCategory1(category1);
		} else if(category1 == null) {
			return "/";
		} else {
			items = mainService.getListByCategory2(category1,category2);
		}
		model.addAttribute("items", items);

		return "shop/list";
	}
	
	@GetMapping("/shop/item")

	public String item(HttpServletRequest request, Model model) {
		Long ino = Long.parseLong(request.getParameter("ino"));
		ItemVO item = mainService.read(ino);
		model.addAttribute("item", item);
		return "shop/item";
	}
}


