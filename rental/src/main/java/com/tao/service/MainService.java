package com.tao.service;

import java.util.List;

import com.tao.domain.ItemVO;

public interface MainService {
	public List<ItemVO> getList();
	
	public List<ItemVO> getListByCategory1(String category1);
	
	public List<ItemVO> getListByCategory2(String category1, String category2);
	
	public ItemVO read(long ino);
}
