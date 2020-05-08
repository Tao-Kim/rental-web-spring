package com.tao.service;

import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j;

@Log4j
@Service
public class LoginServiceImpl implements LoginService{

	@Override
	public boolean checkLogin(String id, String password) {
		// TODO Auto-generated method stub
		log.info("" +id+"  "+ id.equals("admin"));
		log.info("" +password+"  "+ password.equals("1234"));
		if(id.equals("admin") && password.equals("1234")) return true;
		else return false;
	}

}
