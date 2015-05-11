//created by "Mehdi Semsarzadeh" - Core Development team - Dec. 04 2014
package com.uottawa.seccharge.dao;

import java.util.List;

import com.uottawa.seccharge.dataobjects.UserMetadata;

public interface UserMetadataDAO {
	public List<UserMetadata>  findByuserSalt (String userSalt);
}
