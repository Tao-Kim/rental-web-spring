package com.tao.service;

import java.util.List;

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
	public List<ItemVO> getList() {
		// TODO Auto-generated method stub
		return mapper.getList();
	}

	@Override
	public List<ItemVO> getListByCategory1(String category1) {
		// TODO Auto-generated method stub
		return mapper.getListByCategory1(category1);
	}

	@Override
	public List<ItemVO> getListByCategory2(String category1, String category2) {
		// TODO Auto-generated method stub
		return mapper.getListByCategory2(category1, category2);
	}

	@Override
	public void modify(ItemVO vo) {
		// TODO Auto-generated method stub
		mapper.updateItem(vo);
	}

	@Override
	public void delete(int ino) {
		// TODO Auto-generated method stub
		mapper.deleteItem(ino);
	}

	@Override
	public ItemVO read(int ino) {
		// TODO Auto-generated method stub
		return mapper.getItem(ino);
	}

}
