package com.service;


import com.dao.LoginDao;
import com.model.User;

public class LoginValidator {
	LoginDao loginDao= new LoginDao();
	public boolean validate(User user){
		if(loginDao.readLogin(user).equals(" ")){
			return false;
		}
		else{
			return true;
		}
	}
}
