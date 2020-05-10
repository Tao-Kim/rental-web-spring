package com.tao.controller;

import java.io.File;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.tao.domain.ItemVO;
import com.tao.service.AdminService;
import com.tao.utils.ImgUtils;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

/**
 * Handles requests for the application home page.
 */
@Log4j
@Controller
@RequestMapping("/admin")
@AllArgsConstructor
public class AdminController {
	
	AdminService adminService;

	@Resource(name="uploadPath")
	private String uploadPath;
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


	@PostMapping("/shop/register")
	public String register(ItemVO vo, MultipartFile img, MultipartFile imgDetail) throws Exception {
		String imgName = null;
		String imgDetailName = null;
		
		if(img != null) {
			imgName = ImgUtils.imgUpload(uploadPath, img.getOriginalFilename(), img.getBytes());
		} else {
			imgName = uploadPath + File.separator + "images" + File.separator + "none.png";
		}
		
		if(imgDetail != null) {
			imgDetailName = ImgUtils.imgDetailUpload(uploadPath, imgDetail.getOriginalFilename(), imgDetail.getBytes());
		} else {
			imgDetailName = uploadPath + File.separator + "images" + File.separator + "none.png";
		}	
		//private String itemImg;
		//private String ThumbItemImg;
		//private String itemDetailImg;
		
		vo.setItemImg(File.separator+"img"+File.separator+imgName);
		vo.setThumbItemImg(File.separator+"img"+File.separator+"s_"+imgName);
		vo.setItemDetailImg(File.separator+"img"+File.separator+imgDetailName);
		adminService.register(vo);
		return "redirect:/admin/index";
		
	}

}
