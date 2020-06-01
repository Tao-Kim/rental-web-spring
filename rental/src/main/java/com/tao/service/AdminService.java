package com.tao.service;

import com.tao.domain.ItemVO;

public interface AdminService {
	public void register(ItemVO vo);
	
	public void modify(ItemVO vo);
	
	public void delete(long ino);

}
