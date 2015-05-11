package com.uottawa.seccharge.dataobjects;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Province generated by hbm2java
 */
@Entity
@Table(name = "PROVINCE")
public class Province implements Serializable {

	private long id;
	private Country country;
	private String provinceName;
	private Set<City> cities = new HashSet<City>(0);

	public Province() {
	}

	public Province(Country country, String provinceName) {
		this.country = country;
		this.provinceName = provinceName;
	}

	public Province(long id, Country country, String provinceName) {
		this(country, provinceName);
		this.id = id;
	}

	public Province(Country country, String provinceName, Set<City> cities) {
		this.country = country;
		this.provinceName = provinceName;
		this.cities = cities;
	}

	public Province(long id, Country country, String provinceName, Set<City> cities) {
		this(country, provinceName, cities);
		this.id = id;
	}

	@Id
	@GeneratedValue
	@Column(name = "ID", unique = true, nullable = false, precision = 10, scale = 0)
	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "COUNTRYID", nullable = false)
	public Country getCountry() {
		return this.country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	@Column(name = "PROVINCENAME", nullable = false, length = 40)
	public String getProvinceName() {
		return this.provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "province", cascade = CascadeType.ALL)
	public Set<City> getCities() {
		return this.cities;
	}

	public void setCities(Set<City> cities) {
		this.cities = cities;
	}

	@Override
	public String toString() {
		return "Province [id=" + id + ", country=" + country + ", provinceName=" + provinceName + ", cities=" + cities + "]";
	}

}
