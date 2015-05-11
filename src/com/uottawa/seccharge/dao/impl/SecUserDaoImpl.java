package com.uottawa.seccharge.dao.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.uottawa.seccharge.dao.SecUserDao;
import com.uottawa.seccharge.dataobjects.SecChargeUser;
import com.uottawa.seccharge.repository.SecChargeUserRepository;

@Transactional
@Component("SecUserDao")
public class SecUserDaoImpl implements SecUserDao {

	@Autowired
	SecChargeUserRepository secChargeUserRepository;
	
	@Override
	public SecChargeUser findByID(Long id) {
		return secChargeUserRepository.findById(id);
	}

	@Override
	public void emptyTable() {
		// TODO Auto-generated method stub
		secChargeUserRepository.deleteAll();
		
	}

	@Override
	public void updateEntries(SecChargeUser secuser) {
		// TODO Auto-generated method stub
		
		secChargeUserRepository.save(secuser);
		
		
	}
	
}
