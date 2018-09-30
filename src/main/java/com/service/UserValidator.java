package com.service;

import com.dao.RegistrationDao;
import com.model.User;

public class UserValidator {
	public boolean validate(User user, String confirmPassword){
		RegistrationDao registrationDao=new RegistrationDao();
		if(registrationDao.read(user)){
			return false;
		}
		else if(!user.getPassword().equals(confirmPassword)){
			return false;
		}
		else{
			registrationDao	.create(user);
			return true;
		}
	}
}
