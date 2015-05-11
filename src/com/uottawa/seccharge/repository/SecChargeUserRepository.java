/*
 * @Author: Karan Thakker
 * 
 */


package com.uottawa.seccharge.repository;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;

import com.uottawa.seccharge.dataobjects.SecChargeUser;


public interface SecChargeUserRepository extends CrudRepository <SecChargeUser, Serializable>{

	public SecChargeUser findById (Long id);
	
}
