//created by "Mehdi Semsarzadeh" - Core Development team - Dec. 04 2014
package com.uottawa.seccharge.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uottawa.seccharge.dao.SecchuserDAO;
import com.uottawa.seccharge.dao.UserMetadataDAO;
import com.uottawa.seccharge.dataobjects.SecChargeUser;
import com.uottawa.seccharge.dataobjects.UserMetadata;
import com.uottawa.seccharge.service.SecchuserService;

@Service("secchuserService")
public class SecchuserServiceImpl implements SecchuserService {

	private SecchuserDAO secchuserDao;
	private UserMetadataDAO userMetadataDAO;

	

	@Autowired
	public void setsecchuserDao(SecchuserDAO secchuserDao) {
		this.secchuserDao = secchuserDao;
	}
	
	@Autowired
	public void setUserMetadataDAO(UserMetadataDAO userMetadataDAO) {
		this.userMetadataDAO = userMetadataDAO;
	}
	public Iterable<SecChargeUser> getSecchuserList() {
		return secchuserDao.getSecchuserList();
	}

	public Iterable<UserMetadata> getSecchuserWithMetadataList() {
		return secchuserDao.getSecchuserWithMetadataList();
	}

	public void createNewUser(SecChargeUser secchuser) {
		secchuserDao.createSecchuser(secchuser);
	}

	public void createNewUserWithMetadata(UserMetadata userMetadata) {
		secchuserDao.createSecchuserwithMetadata(userMetadata);
	}

	public boolean isSecchuserExist(String username) {
		List<SecChargeUser> secchuser = secchuserDao.findByusername(username);

		if (secchuser.isEmpty())
			return false;
		else
			return true;
	}

	public SecChargeUser finduser(String username) {
		List<SecChargeUser> secchuser = secchuserDao.findByusername(username);
		if (secchuser.size() == 0)
			return null;
		else if (secchuser.size() > 1) {
			System.out
					.println("error: only one user with an specific username has to exist");
			return null;
		} else
			return secchuser.get(0);
	}
	
	public List<UserMetadata>  findByuserSalt (String userSalt){
		return userMetadataDAO.findByuserSalt(userSalt);
	}
	public void delete(SecChargeUser secchuser) {
		secchuserDao.delete(secchuser);
	}

	public void deleteByusername(String username) {
		SecChargeUser secchuser = finduser(username);
		secchuserDao.delete(secchuser);
	}

	public void emptyTable() {
		secchuserDao.emptyTable();
	}
}
