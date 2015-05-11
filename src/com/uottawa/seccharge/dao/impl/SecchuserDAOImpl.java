//created by "Mehdi Semsarzadeh" - Core Development team - Dec. 04 2014
package com.uottawa.seccharge.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.uottawa.seccharge.dao.SecchuserDAO;
import com.uottawa.seccharge.dataobjects.SecChargeUser;
import com.uottawa.seccharge.dataobjects.UserMetadata;
import com.uottawa.seccharge.repository.SecchuserRepository;
import com.uottawa.seccharge.repository.UserMetadataRepository;

@Transactional
@Component("SecchuserDao")
public class SecchuserDAOImpl implements SecchuserDAO {

	@Autowired
	private SecchuserRepository secchuserRepo;
	@Autowired
	private UserMetadataRepository userMetadataRepo;

	public Iterable<SecChargeUser> getSecchuserList() {

		return secchuserRepo.findAll();

	}

	public Iterable<UserMetadata> getSecchuserWithMetadataList() {
		return userMetadataRepo.findAll();
	}

	public void createSecchuser(SecChargeUser secchuser) {

		secchuserRepo.save(secchuser);
	}

	public void createSecchuserwithMetadata(UserMetadata userMetadata) {

		// secchuserRepo.save(secchuser);
		userMetadataRepo.save(userMetadata);
	}

	public void delete(SecChargeUser secchuser) {

		secchuserRepo.delete(secchuser);
	}

	public List<SecChargeUser> findByusername(String username) {
		return secchuserRepo.findByusername(username);
	}
	
	
	public void emptyTable() {
		userMetadataRepo.deleteAll();
		secchuserRepo.deleteAll();
	}
}
