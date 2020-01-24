package com.example.EVoucherSystem.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.EVoucherSystem.Model.Vouchers;

public interface VoucherDAO extends CrudRepository<Vouchers, Integer>{
	
}
