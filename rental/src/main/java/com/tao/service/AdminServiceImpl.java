package com.tao.service;

import org.springframework.stereotype.Service;

import com.tao.domain.ItemVO;
import com.tao.mapper.ItemMapper;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AdminServiceImpl implements AdminService {

	private ItemMapper mapper;

	/*
	 * public void insertItem(ItemVO vo);
	 * 
	 * public List<ItemVO> getList();
	 * 
	 * public List<ItemVO> getListByCategory1(String category1);
	 * 
	 * public List<ItemVO> getListByCategory2(String category1, String category2);
	 * 
	 * public void updateItem(ItemVO vo);
	 * 
	 * public void deleteItem(int ino);
	 * 
	 * public ItemVO getItem(int ino);
	 */

	@Override
	public void register(ItemVO vo) {
		// TODO Auto-generated method stub
		mapper.insertItem(vo);
	}

	@Override
	public void modify(ItemVO vo) {
		// TODO Auto-generated method stub
		mapper.updateItem(vo);
	}

	@Override
	public void delete(long ino) {
		// TODO Auto-generated method stub
		mapper.deleteItem(ino);
	}


}
