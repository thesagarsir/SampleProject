package com.sagar.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mysql.jdbc.log.Log;
import com.sagar.entity.Login;

@Repository
public class SpringDao {
	
	@Autowired
	SessionFactory sessionFactory;

	public boolean loginCheck(Login user) {
		System.out.println(user.getUsername());
		System.out.println(user.getPassword());
		
		String username = user.getUsername();
		String password = user.getPassword();
		
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Login.class);
		criteria.add(Restrictions.eq("username", username));
		criteria.add(Restrictions.eq("password", password));
		List<Login> userList = criteria.list();
		if(!userList.isEmpty()) {
			return true;
		}else {
			return false;
		}
		
	}

	public List<Login> getUser() {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Login.class);
		List<Login> userList = criteria.list();
		return userList;
	}

	public boolean deleteUser(int userid) {
		System.out.println("Id DAO userID for Deletion :"+userid);
		Session session = sessionFactory.openSession();
		
		Transaction transaction = session.beginTransaction();
		Login user = session.get(Login.class, userid);
		session.delete(user);
		transaction.commit();
		return true;
	}

	public boolean adduser(Login user) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(user);
		transaction.commit();
		return true;
	}

}
