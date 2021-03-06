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
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * ElectricalVehicle generated by hbm2java
 */
@Entity
@Table(name = "ELECTRICAL_VEHICLE")
public class ElectricalVehicle implements Serializable {

	private Long id;
	private String vehicleVin;
	private String plateNumber;
	private String make;
	private String model;
	private String year;
	private Set<EvBattery> evBatteries = new HashSet<EvBattery>(0);
	private Set<UserMetadataEv> userMetadataEvs = new HashSet<UserMetadataEv>(0);

	public ElectricalVehicle() {
	}

	public ElectricalVehicle(String vehicleVin, String plateNumber, String make, String model, String year) {
		this.vehicleVin = vehicleVin;
		this.plateNumber = plateNumber;
		this.make = make;
		this.model = model;
		this.year = year;
	}
	public ElectricalVehicle(Long id, String vehicleVin, String plateNumber, String make, String model, String year) {
		this(vehicleVin, plateNumber, make, model, year);
		this.id = id;
	}

	public ElectricalVehicle(String vehicleVin, String plateNumber, String make, String model, String year,
			Set<EvBattery> evBatteries, Set<UserMetadataEv> userMetadataEvs) {
		this(vehicleVin, plateNumber, make, model, year);
		this.evBatteries = evBatteries;
		this.userMetadataEvs = userMetadataEvs;
	}
	
	public ElectricalVehicle(Long id, String vehicleVin, String plateNumber, String make, String model, String year,
			Set<EvBattery> evBatteries, Set<UserMetadataEv> userMetadataEvs) {
		this(vehicleVin, plateNumber, make, model, year, evBatteries, userMetadataEvs);
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

	@Column(name = "VEHICLEVIN", nullable = false, length = 20)
	public String getVehicleVin() {
		return this.vehicleVin;
	}

	public void setVehicleVin(String vehicleVin) {
		this.vehicleVin = vehicleVin;
	}

	@Column(name = "PLATENUMBER", nullable = false, length = 12)
	public String getPlateNumber() {
		return this.plateNumber;
	}

	public void setPlateNumber(String plateNumber) {
		this.plateNumber = plateNumber;
	}

	@Column(name = "MAKE", nullable = false, length = 40)
	public String getMake() {
		return this.make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	@Column(name = "MODEL", nullable = false, length = 40)
	public String getModel() {
		return this.model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	@Column(name = "YEAR", nullable = false, length = 5)
	public String getYear() {
		return this.year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "electricalVehicle", cascade = CascadeType.ALL)
	public Set<EvBattery> getEvBatteries() {
		return this.evBatteries;
	}

	public void setEvBatteries(Set<EvBattery> evBatteries) {
		this.evBatteries = evBatteries;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "electricalVehicle", cascade = CascadeType.ALL)
	public Set<UserMetadataEv> getUserMetadataEvs() {
		return this.userMetadataEvs;
	}

	public void setUserMetadataEvs(Set<UserMetadataEv> userMetadataEvs) {
		this.userMetadataEvs = userMetadataEvs;
	}

	@Override
	public String toString() {
		return "ElectricalVehicle [id=" + id + ", vehicleVin=" + vehicleVin + ", plateNumber=" + plateNumber + ", make="
				+ make + ", model=" + model + ", year=" + year + ", evBatteries=" + evBatteries + ", userMetadataEvs="
				+ userMetadataEvs + "]";
	}

}
