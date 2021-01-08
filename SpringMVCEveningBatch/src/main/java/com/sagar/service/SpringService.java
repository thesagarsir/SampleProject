package com.sagar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sagar.dao.SpringDao;
import com.sagar.entity.Login;

@Service
public class SpringService {

	@Autowired
	SpringDao dao;
	
	
	public boolean loginCheck(Login user) {

		boolean result = dao.loginCheck(user);
		return result;
	}


	public List<Login> getUser() {
		List<Login> userList = dao.getUser();
		return userList;
	}


	public boolean deleteUser(int userid) {
		boolean result = dao.deleteUser(userid);
		return result;
	}


	public boolean adduser(Login user) {

		boolean result = dao.adduser(user);
		return result;
	}

}
