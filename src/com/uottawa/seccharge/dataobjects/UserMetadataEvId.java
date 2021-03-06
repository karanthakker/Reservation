package com.uottawa.seccharge.dataobjects;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * UserMetadataEvId generated by hbm2java
 */
@Embeddable
public class UserMetadataEvId implements Serializable {

	private Long userMetadataId;
	private Long electricalVehicleId;

	public UserMetadataEvId() {
	}

	public UserMetadataEvId(Long userMetadataId, Long electricalVehicleId) {
		this.userMetadataId = userMetadataId;
		this.electricalVehicleId = electricalVehicleId;
	}

	@Column(name = "USER_METADATAID", nullable = false, precision = 32, scale = 0)
	public Long getUserMetadataId() {
		return this.userMetadataId;
	}

	public void setUserMetadataId(Long userMetadataId) {
		this.userMetadataId = userMetadataId;
	}

	@Column(name = "ELECTRICAL_VEHICLEID", nullable = false, precision = 32, scale = 0)
	public Long getElectricalVehicleId() {
		return this.electricalVehicleId;
	}

	public void setElectricalVehicleId(Long electricalVehicleId) {
		this.electricalVehicleId = electricalVehicleId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof UserMetadataEvId))
			return false;
		UserMetadataEvId castOther = (UserMetadataEvId) other;

		return ((this.getUserMetadataId() == castOther.getUserMetadataId()) || (this.getUserMetadataId() != null
				&& castOther.getUserMetadataId() != null && this.getUserMetadataId().equals(castOther.getUserMetadataId())))
				&& ((this.getElectricalVehicleId() == castOther.getElectricalVehicleId()) || (this.getElectricalVehicleId() != null
						&& castOther.getElectricalVehicleId() != null && this.getElectricalVehicleId().equals(
						castOther.getElectricalVehicleId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getUserMetadataId() == null ? 0 : this.getUserMetadataId().hashCode());
		result = 37 * result + (getElectricalVehicleId() == null ? 0 : this.getElectricalVehicleId().hashCode());
		return result;
	}

	@Override
	public String toString() {
		return "UserMetadataEvId [userMetadataId=" + userMetadataId + ", electricalVehicleId=" + electricalVehicleId + "]";
	}

}
