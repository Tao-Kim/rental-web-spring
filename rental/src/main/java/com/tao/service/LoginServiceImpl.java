package com.tao.service;

import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService{

	@Override
	public boolean checkLogin(String id, String password) {
		// TODO Auto-generated method stub
		if(id.equals("admin") && password.equals("1234")) return true;
		else return false;
	}

}
