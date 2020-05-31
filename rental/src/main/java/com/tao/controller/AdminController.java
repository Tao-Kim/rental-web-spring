package com.tao.controller;

import java.io.File;
import java.net.URLEncoder;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.tao.domain.ItemVO;
import com.tao.service.AdminService;
import com.tao.service.MainService;
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
	MainService mainService;

	@Resource(name="uploadPath")
	private String uploadPath;
	/**
	 * Simply selects the home view to render by returning its name.
	 * @throws Exception 
	 */

	@GetMapping("/shop/item/delete")
	public String delete(HttpServletRequest request) throws Exception {

		long ino = Long.parseLong(request.getParameter("ino"));
		ItemVO vo = mainService.read(ino);
		String itemImg = vo.getItemImg();
		String itemThumbImg = vo.getItemThumbImg();
		String itemDetailImg = vo.getItemDetailImg();
		String category2 = vo.getCategory2();
		String category1 = vo.getCategory1();
		if(itemImg != null) {
			ImgUtils.imgDelete(uploadPath, itemImg);
		}
		if(itemThumbImg != null) {
			ImgUtils.imgDelete(uploadPath, itemThumbImg);
		}
		if(itemDetailImg != null) {
			ImgUtils.imgDelete(uploadPath, itemDetailImg);
		}
		adminService.delete(ino);

		if(category2 != null) {
			return "redirect:/shop/list?category1="+URLEncoder.encode(category1, "UTF-8")+"&category2="+URLEncoder.encode(category2, "UTF-8");
		} else {
			return "redirect:/shop/list?category1="+URLEncoder.encode(category1, "UTF-8");
		}
	}
	
	@GetMapping("/shop/item/modify")
	public String modify(HttpServletRequest request, Model model) {
		int ino = Integer.parseInt(request.getParameter("ino"));
		ItemVO vo = mainService.read(ino);
		model.addAttribute("item", vo);
		
		return "shop/modify";
	}
	
	@PostMapping("/shop/item/modify")
	public String modifyPost(@RequestParam("ino") long ino, @RequestParam("originalImg") String originalImg, 
			@RequestParam("originalThumbImg") String originalThumbImg, @RequestParam("originalDetailImg") String originalDetailImg, 
			ItemVO vo, @RequestParam("img") MultipartFile img, @RequestParam("imgDetail") MultipartFile imgDetail) throws Exception {
		log.info("modify started!!!!!!!!!!!!!!!!");
		log.info("originalImg : " + originalImg);
		log.info("originalThumbImg : " + originalThumbImg);
		log.info("originalDetailImg : " + originalDetailImg);
		String imgName = null;
		String imgDetailName = null;
		
		if(!img.isEmpty()) {
			//삭제
			ImgUtils.imgDelete(uploadPath, originalImg);
			ImgUtils.imgDelete(uploadPath, originalThumbImg);
			log.info("!img.isEmpty() is true ");
			imgName = ImgUtils.imgUpload(uploadPath, img.getOriginalFilename(), img.getBytes());
			vo.setItemImg(File.separator +"img"+ File.separator +imgName);
			vo.setItemThumbImg(File.separator +"img"+ File.separator +"s_"+imgName);
		} else {
			vo.setItemImg(originalImg);
			vo.setItemThumbImg(originalThumbImg);
		}
		
		if(!imgDetail.isEmpty()) {
			//삭제
			log.info("!imgDetail.isEmptyh() is true ");
			ImgUtils.imgDelete(uploadPath, originalDetailImg);
			imgDetailName = ImgUtils.imgDetailUpload(uploadPath, imgDetail.getOriginalFilename(), imgDetail.getBytes());
			vo.setItemDetailImg(File.separator +"img" + File.separator +imgDetailName);
		} else {
			vo.setItemDetailImg(originalDetailImg);			
		}


		vo.setIno(ino);
		log.info("ino : "+ vo.getIno());
		log.info("category1 : "+ vo.getCategory1());
		log.info("category2 : "+ vo.getCategory2());
		log.info("title : "+ vo.getTitle());
		log.info("itemFee : "+ vo.getItemFee());
		log.info("itemFeatures : "+ vo.getItemFeatures());
		log.info("itemSize : "+ vo.getItemSize());
		log.info("inforamtion : "+ vo.getInformation());
		log.info("itemImg : "+ vo.getItemImg());
		log.info("thumbItemImg : "+ vo.getItemThumbImg());
		log.info("itemDetailImg : "+ vo.getItemDetailImg());
		adminService.modify(vo);
		return "redirect:/shop/item?ino="+Long.toString(ino);
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
		
		vo.setItemImg(File.separator +"img"+ File.separator +imgName);
		vo.setItemThumbImg(File.separator +"img"+ File.separator +"s_"+imgName);
		vo.setItemDetailImg(File.separator +"img" + File.separator +imgDetailName);
		
		log.info("ino : "+ vo.getIno());
		log.info("category1 : "+ vo.getCategory1());
		log.info("category2 : "+ vo.getCategory2());
		log.info("title : "+ vo.getTitle());
		log.info("itemFee : "+ vo.getItemFee());
		log.info("itemFeatures : "+ vo.getItemFeatures());
		log.info("itemSize : "+ vo.getItemSize());
		log.info("inforamtion : "+ vo.getInformation());
		log.info("itemImg : "+ vo.getItemImg());
		log.info("thumbItemImg : "+ vo.getItemThumbImg());
		log.info("itemDetailImg : "+ vo.getItemDetailImg());
		adminService.register(vo);
		String category2 = vo.getCategory2();
		String category1 = vo.getCategory1();
		if(category2 != null) {
			return "redirect:/shop/list?category1="+URLEncoder.encode(category1, "UTF-8")+"&category2="+URLEncoder.encode(category2, "UTF-8");
		} else {
			return "redirect:/shop/list?category1="+URLEncoder.encode(category1, "UTF-8");
		}
		
		
	}

}
