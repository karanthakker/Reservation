package com.uottawa.seccharge.dataobjects;

import java.sql.Blob;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * CsSite generated by hbm2java
 */
@Entity
@Table(name = "CS_SITE")
public class CsSite implements java.io.Serializable {

	private Long id;
	private String siteType;
	private String siteOwner;
	private String address1;
	private String address2;
	private String city;
	private String province;
	private String postalCode;
	private String country;
	private Blob sitePicture;
	private Set<SiteReservation> siteReservations = new HashSet<SiteReservation>(0);
	private Set<ChargingStation> chargingStations = new HashSet<ChargingStation>(0);
	private Set<SiteStatus> siteStatuses = new HashSet<SiteStatus>(0);

	public CsSite() {
	}

	public CsSite(String siteType, String siteOwner, String address1, String city, String province, String country) {
		this.siteType = siteType;
		this.siteOwner = siteOwner;
		this.address1 = address1;
		this.city = city;
		this.province = province;
		this.country = country;
	}

	public CsSite(Long id, String siteType, String siteOwner, String address1, String city, String province, String country) {
		this(siteType, siteOwner, address1, city, province, country);
		this.id = id;
	}

	public CsSite(String siteType, String siteOwner, String address1, String address2, String city, String province,
			String postalCode, String country, Blob sitePicture, Set<SiteReservation> siteReservations,
			Set<ChargingStation> chargingStations, Set<SiteStatus> siteStatuses) {
		this(siteType, siteOwner, address1, city, province, country);
		this.address2 = address2;
		this.postalCode = postalCode;
		this.sitePicture = sitePicture;
		this.siteReservations = siteReservations;
		this.chargingStations = chargingStations;
		this.siteStatuses = siteStatuses;
	}

	public CsSite(Long id, String siteType, String siteOwner, String address1, String address2, String city,
			String province, String postalCode, String country, Blob sitePicture, Set<SiteReservation> siteReservations,
			Set<ChargingStation> chargingStations, Set<SiteStatus> siteStatuses) {
		this(siteType, siteOwner, address1, address2, city, province, postalCode, country, sitePicture, siteReservations,
				chargingStations, siteStatuses);
		this.id = id;
	}

	@Id
	@GeneratedValue
	@Column(name = "ID", unique = true, nullable = false, precision = 32, scale = 0)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "SITETYPE", nullable = false, length = 20)
	public String getSiteType() {
		return this.siteType;
	}

	public void setSiteType(String siteType) {
		this.siteType = siteType;
	}

	@Column(name = "SITEOWNER", nullable = false, length = 510)
	public String getSiteOwner() {
		return this.siteOwner;
	}

	public void setSiteOwner(String siteOwner) {
		this.siteOwner = siteOwner;
	}

	@Column(name = "ADDRESS1", nullable = false)
	public String getAddress1() {
		return this.address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	@Column(name = "ADDRESS2")
	public String getAddress2() {
		return this.address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	@Column(name = "CITY", nullable = false, length = 40)
	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Column(name = "PROVINCE", nullable = false, length = 40)
	public String getProvince() {
		return this.province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	@Column(name = "POSTALCODE", length = 10)
	public String getPostalCode() {
		return this.postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	@Column(name = "COUNTRY", nullable = false, length = 40)
	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Column(name = "SITEPICTURE")
	public Blob getSitePicture() {
		return this.sitePicture;
	}

	public void setSitePicture(Blob sitePicture) {
		this.sitePicture = sitePicture;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "csSite", cascade = CascadeType.ALL)
	public Set<SiteReservation> getSiteReservations() {
		return this.siteReservations;
	}

	public void setSiteReservations(Set<SiteReservation> siteReservations) {
		this.siteReservations = siteReservations;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "csSite", cascade = CascadeType.ALL)
	public Set<ChargingStation> getChargingStations() {
		return this.chargingStations;
	}

	public void setChargingStations(Set<ChargingStation> chargingStations) {
		this.chargingStations = chargingStations;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "csSite", cascade = CascadeType.ALL)
	public Set<SiteStatus> getSiteStatuses() {
		return this.siteStatuses;
	}

	public void setSiteStatuses(Set<SiteStatus> siteStatuses) {
		this.siteStatuses = siteStatuses;
	}

	@Override
	public String toString() {
		return "CsSite [id=" + id + ", siteType=" + siteType + ", siteOwner=" + siteOwner + ", address1=" + address1
				+ ", address2=" + address2 + ", city=" + city + ", province=" + province + ", postalCode=" + postalCode
				+ ", country=" + country + ", sitePicture=" + sitePicture + ", siteReservations=" + siteReservations
				+ ", chargingStations=" + chargingStations + ", siteStatuses=" + siteStatuses + "]";
	}

}