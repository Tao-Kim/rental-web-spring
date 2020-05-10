package com.tao.mapper;

import java.util.List;

import com.tao.domain.ItemVO;

public interface ItemMapper {
	
	public void insertItem(ItemVO vo);
	
	public List<ItemVO> getList();
	
	public List<ItemVO> getListByCategory1(String category1);
	
	public List<ItemVO> getListByCategory2(String category1, String category2);	
	
	public void updateItem(ItemVO vo);
	
	public void deleteItem(int ino);
	
	public ItemVO getItem(int ino);
}
