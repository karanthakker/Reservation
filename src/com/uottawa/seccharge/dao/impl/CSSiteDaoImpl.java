package com.uottawa.seccharge.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.uottawa.seccharge.dao.CSSiteDao;
import com.uottawa.seccharge.dataobjects.CsSite;
import com.uottawa.seccharge.repository.CSSiteRepository;

@Transactional
@Component("CSSiteDao")

public class CSSiteDaoImpl implements CSSiteDao {

	
	@Autowired
	CSSiteRepository csSiteRepository;
	@Override
	public CsSite findByID(Long id) {
		return csSiteRepository.findById(id);


	}
	@Override
	public void emptyTable() {
		// TODO Auto-generated method stub
		csSiteRepository.deleteAll();
		
		
	}
	@Override
	public void updateEntries(CsSite csSite) {
		// TODO Auto-generated method stub
		csSiteRepository.save(csSite);
		
	}
	
}
