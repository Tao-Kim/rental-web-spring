package com.tao.utils;

import java.io.File;
import java.util.UUID;

import org.springframework.util.FileCopyUtils;

import net.coobird.thumbnailator.Thumbnails;

public class ImgUtils {
  
	 static final int THUMB_WIDTH = 300;
	 static final int THUMB_HEIGHT = 300;
	 
	 public static String imgUpload(String uploadPath,
	         String fileName,
	         byte[] fileData) throws Exception {

	  UUID uid = UUID.randomUUID();
	  
	  String newFileName = uid + "_" + fileName;
	  File target = new File(uploadPath, newFileName);
	  FileCopyUtils.copy(fileData, target);
	  
	  String thumbFileName = "s_" + newFileName;
	  File image = new File(uploadPath + File.separator + newFileName);
	  File thumbnail = new File(uploadPath + File.separator + thumbFileName);

	  if (image.exists()) {
	   Thumbnails.of(image).size(THUMB_WIDTH, THUMB_HEIGHT).toFile(thumbnail);
	  }
	  return newFileName;
	 }
	 public static String imgDetailUpload(String uploadPath,
	         String fileName,
	         byte[] fileData) throws Exception {

	  UUID uid = UUID.randomUUID();
	  
	  String newFileName = uid + "_" + fileName;
	  File target = new File(uploadPath, newFileName);
	  FileCopyUtils.copy(fileData, target);
	  
	  return newFileName;
	 }
}