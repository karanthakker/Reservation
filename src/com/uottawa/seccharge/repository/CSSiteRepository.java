package com.uottawa.seccharge.repository;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;

import com.uottawa.seccharge.dataobjects.CsSite;

public interface CSSiteRepository extends CrudRepository <CsSite, Serializable>{
	
	public CsSite findById (Long id);

}
