package com.tao.controller;

import java.io.File;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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


	@PostMapping(value="/shop/register", produces="text/plain;charset=UTF-8")
	public String register(ItemVO vo, @RequestParam("img") MultipartFile img,@RequestParam("imgDetail") MultipartFile imgDetail) throws Exception {
		log.info("register(post) started!!!!!!!!!!!!!!!!");
		String imgName = null;
		String imgDetailName = null;
		log.info("uploadPaht :" + uploadPath);
		
		if(!img.isEmpty()) {
			imgName = ImgUtils.imgUpload(uploadPath, img.getOriginalFilename(), img.getBytes());
		} else {
			imgName = "none.png";
		}
		
		if(!imgDetail.isEmpty()) {
			imgDetailName = ImgUtils.imgDetailUpload(uploadPath, imgDetail.getOriginalFilename(), imgDetail.getBytes());
		} else {
			imgDetailName = "none.png";
		}	
		//private String itemImg;
		//private String ThumbItemImg;
		//private String itemDetailImg;
		
		vo.setItemImg(uploadPath + File.separator + "images" + File.separator +imgName);
		vo.setThumbItemImg(uploadPath + File.separator + "images" + File.separator +"s_"+imgName);
		vo.setItemDetailImg(uploadPath + File.separator + "images" + File.separator +imgDetailName);
		
		log.info("ino : "+ vo.getIno());
		log.info("category1 : "+ vo.getCategory1());
		log.info("category2 : "+ vo.getCategory2());
		log.info("title : "+ vo.getTitle());
		log.info("itemFee : "+ vo.getItemFee());
		log.info("itemFeatures : "+ vo.getItemFeatures());
		log.info("itemSize : "+ vo.getItemSize());
		log.info("inforamtion : "+ vo.getInformation());
		log.info("itemImg : "+ vo.getItemImg());
		log.info("thumbItemImg : "+ vo.getThumbItemImg());
		log.info("itemDetailImg : "+ vo.getItemDetailImg());
		adminService.register(vo);
		return "redirect:/admin/index";
		
	}

}
