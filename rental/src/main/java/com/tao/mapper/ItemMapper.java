package com.tao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.tao.domain.ItemVO;

public interface ItemMapper {
	
	public void insertItem(ItemVO vo);
	
	public List<ItemVO> getList();
	
	public List<ItemVO> getListByCategory1(String category1);
	
	public List<ItemVO> getListByCategory2(@Param("cat1") String category1,@Param("cat2") String category2);	
	
	public void updateItem(ItemVO vo);
	
	public void deleteItem(long ino);
	
	public ItemVO getItem(long ino);
}
