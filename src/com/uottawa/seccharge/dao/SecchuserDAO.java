//created by "Mehdi Semsarzadeh" - Core Development team - Dec. 04 2014
package com.uottawa.seccharge.dao;

import java.util.List;

import com.uottawa.seccharge.dataobjects.SecChargeUser;
import com.uottawa.seccharge.dataobjects.UserMetadata;

public interface SecchuserDAO {

	public Iterable<SecChargeUser> getSecchuserList();

	public Iterable<UserMetadata> getSecchuserWithMetadataList();

	public void createSecchuser(SecChargeUser secchuser);

	public void createSecchuserwithMetadata(UserMetadata userMetadata);

	public void delete(SecChargeUser secchuser);
	
	public List<SecChargeUser> findByusername(String username);

	public void emptyTable();

}
