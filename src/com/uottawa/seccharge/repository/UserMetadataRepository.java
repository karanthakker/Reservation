//created by "Mehdi Semsarzadeh" - Core Development team - Dec. 04 2014
package com.uottawa.seccharge.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.uottawa.seccharge.dataobjects.UserMetadata;

public interface UserMetadataRepository extends CrudRepository<UserMetadata, Serializable> {
	List<UserMetadata> findByuserSalt(String userSalt);

}
