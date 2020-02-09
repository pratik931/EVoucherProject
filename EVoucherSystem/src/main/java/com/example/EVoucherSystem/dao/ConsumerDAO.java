package com.example.EVoucherSystem.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.EVoucherSystem.Model.Consumer;

public interface ConsumerDAO extends CrudRepository<Consumer, Integer>{
	Consumer findByUserName(String userName);
	
	@Query(" from Consumer where  user_name=?1 and user_pwd=?2")
	Consumer findConsumer(String userName, String pwd);
}
