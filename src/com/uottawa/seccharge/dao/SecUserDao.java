/*
 * 
 * @Author Karan Thakker
 */

package com.uottawa.seccharge.dao;

import com.uottawa.seccharge.dataobjects.SecChargeUser;

public interface SecUserDao {

	 public SecChargeUser findByID (Long id);

	public void emptyTable();

	public void updateEntries(SecChargeUser secuser);
	
}
