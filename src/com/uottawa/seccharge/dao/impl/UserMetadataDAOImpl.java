//created by "Mehdi Semsarzadeh" - Core Development team - Dec. 04 2014
package com.uottawa.seccharge.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.uottawa.seccharge.dao.UserMetadataDAO;
import com.uottawa.seccharge.dataobjects.UserMetadata;
import com.uottawa.seccharge.repository.UserMetadataRepository;

@Transactional
@Component("UserMetadataDao")
public class UserMetadataDAOImpl implements UserMetadataDAO{

	@Autowired
	private UserMetadataRepository userMetadataRepo;


	public List<UserMetadata>  findByuserSalt (String userSalt){
		return userMetadataRepo.findByuserSalt(userSalt);
	}


}
