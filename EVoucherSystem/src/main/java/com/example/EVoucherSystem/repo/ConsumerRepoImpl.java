package com.example.EVoucherSystem.repo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class ConsumerRepoImpl implements ConsumerRepo{
	public boolean authenticateUser(String userName, String pwd) {
		
		String getUserQuery = " from Consumer where username=? and userPwd=?";
		return true;
	}
}
