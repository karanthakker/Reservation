package com.uottawa.seccharge.dataobjects;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * SiteReservationId generated by hbm2java
 */
@Embeddable
public class SiteReservationId implements Serializable {

	private Long id;
	private Long csSiteId;
	private Long reservationId;

	public SiteReservationId() {
	}
	
	public SiteReservationId(Long csSiteId, Long reservationId) {
		this.csSiteId = csSiteId;
		this.reservationId = reservationId;
	}
	
	public SiteReservationId(Long id, Long csSiteId, Long reservationId) {
		this(csSiteId, reservationId);
		this.id = id;
	}

	@Column(name = "ID", nullable = false, precision = 32, scale = 0)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "CS_SITEID", nullable = false, precision = 32, scale = 0)
	public Long getCsSiteId() {
		return this.csSiteId;
	}

	public void setCsSiteId(Long csSiteId) {
		this.csSiteId = csSiteId;
	}

	@Column(name = "RESERVATIONID", nullable = false, precision = 32, scale = 0)
	public Long getReservationId() {
		return this.reservationId;
	}

	public void setReservationId(Long reservationId) {
		this.reservationId = reservationId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof SiteReservationId))
			return false;
		SiteReservationId castOther = (SiteReservationId) other;

		return ((this.getId() == castOther.getId()) || (this.getId() != null && castOther.getId() != null && this.getId()
				.equals(castOther.getId())))
				&& ((this.getCsSiteId() == castOther.getCsSiteId()) || (this.getCsSiteId() != null
						&& castOther.getCsSiteId() != null && this.getCsSiteId().equals(castOther.getCsSiteId())))
				&& ((this.getReservationId() == castOther.getReservationId()) || (this.getReservationId() != null
						&& castOther.getReservationId() != null && this.getReservationId().equals(
						castOther.getReservationId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getId() == null ? 0 : this.getId().hashCode());
		result = 37 * result + (getCsSiteId() == null ? 0 : this.getCsSiteId().hashCode());
		result = 37 * result + (getReservationId() == null ? 0 : this.getReservationId().hashCode());
		return result;
	}

	@Override
	public String toString() {
		return "SiteReservationId [id=" + id + ", csSiteId=" + csSiteId + ", reservationId=" + reservationId + "]";
	}

}
