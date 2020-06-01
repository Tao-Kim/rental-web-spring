package com.tao.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tao.domain.ItemVO;
import com.tao.mapper.ItemMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class MainServiceImpl implements MainService{
	private ItemMapper mapper;
	
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
		log.info("list by cat2 started !!!!!!!!!!!!!");
		log.info("cat1 : " + category1);
		log.info("cat2 : "+ category2);

		return mapper.getListByCategory2(category1, category2);
	}
	
	@Override
	public ItemVO read(long ino) {
		// TODO Auto-generated method stub
		return mapper.getItem(ino);
	}

}
