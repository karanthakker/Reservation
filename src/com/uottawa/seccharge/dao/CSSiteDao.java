package com.uottawa.seccharge.dao;

import com.uottawa.seccharge.dataobjects.CsSite;
import com.uottawa.seccharge.dataobjects.SecChargeUser;

public interface CSSiteDao {
	
	public CsSite findByID (Long id);
	
	public void emptyTable();

	public void updateEntries(CsSite csSite);

}
