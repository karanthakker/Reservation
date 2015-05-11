//created by "Mehdi Semsarzadeh" - Core Development team - Dec. 04 2014
package com.uottawa.seccharge.service;

import java.util.List;

import com.uottawa.seccharge.dao.SecchuserDAO;
import com.uottawa.seccharge.dataobjects.SecChargeUser;
import com.uottawa.seccharge.dataobjects.UserMetadata;

public interface SecchuserService {

	public void setsecchuserDao(SecchuserDAO secchuserDao);

	public Iterable<SecChargeUser> getSecchuserList();

	public Iterable<UserMetadata> getSecchuserWithMetadataList();

	public void createNewUser(SecChargeUser secchuser);

	public void createNewUserWithMetadata(UserMetadata userMetadata);

	public boolean isSecchuserExist(String username);

	public SecChargeUser finduser(String username);
	
	public List<UserMetadata>  findByuserSalt (String userSalt);

	public void delete(SecChargeUser secchuser);
	
	public void deleteByusername(String username);

	public void emptyTable();
}
