package com.uottawa.seccharge.dataobjects;

import java.io.Serializable;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * UserMetadataEv generated by hbm2java
 */
@Entity
@Table(name = "USER_METADATA_EV")
public class UserMetadataEv implements Serializable {

	private UserMetadataEvId id;
	private ElectricalVehicle electricalVehicle;
	private SecChargeUser secChargeUser;
	private String licenceNumber;

	public UserMetadataEv() {
	}

	public UserMetadataEv(ElectricalVehicle electricalVehicle, SecChargeUser secChargeUser) {
		this.electricalVehicle = electricalVehicle;
		this.secChargeUser = secChargeUser;
	}

	public UserMetadataEv(UserMetadataEvId id, ElectricalVehicle electricalVehicle, SecChargeUser secChargeUser) {
		this(electricalVehicle, secChargeUser);
		this.id = id;
	}

	public UserMetadataEv(ElectricalVehicle electricalVehicle, SecChargeUser secChargeUser, String licenceNumber) {
		this.electricalVehicle = electricalVehicle;
		this.secChargeUser = secChargeUser;
		this.licenceNumber = licenceNumber;
	}

	public UserMetadataEv(UserMetadataEvId id, ElectricalVehicle electricalVehicle, SecChargeUser secChargeUser,
			String licenceNumber) {
		this(electricalVehicle, secChargeUser, licenceNumber);
		this.id = id;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "userMetadataid", column = @Column(name = "USER_METADATAID", nullable = false, precision = 32, scale = 0)),
			@AttributeOverride(name = "electricalVehicleid", column = @Column(name = "ELECTRICAL_VEHICLEID", nullable = false, precision = 32, scale = 0)) })
	public UserMetadataEvId getId() {
		return this.id;
	}

	public void setId(UserMetadataEvId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ELECTRICAL_VEHICLEID", nullable = false, insertable = false, updatable = false)
	public ElectricalVehicle getElectricalVehicle() {
		return this.electricalVehicle;
	}

	public void setElectricalVehicle(ElectricalVehicle electricalVehicle) {
		this.electricalVehicle = electricalVehicle;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SECCHARGE_USERID", nullable = false, insertable = false, updatable = false)
	public SecChargeUser getSecChargeUser() {
		return this.secChargeUser;
	}

	public void setSecChargeUser(SecChargeUser secChargeUser) {
		this.secChargeUser = secChargeUser;
	}

	@Column(name = "LICENCENUMBER", length = 40)
	public String getLicenceNumber() {
		return this.licenceNumber;
	}

	public void setLicenceNumber(String licenceNumber) {
		this.licenceNumber = licenceNumber;
	}

	@Override
	public String toString() {
		return "UserMetadataEv [id=" + id + ", electricalVehicle=" + electricalVehicle + ", secChargeUser=" + secChargeUser
				+ ", licenceNumber=" + licenceNumber + "]";
	}

}
