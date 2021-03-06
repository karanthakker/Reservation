package com.uottawa.seccharge.dataobjects;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * TransactionHistroyId generated by hbm2java
 */
@Embeddable
public class TransactionHistroyId implements Serializable {

	private Long id;
	private Long userMetadataId;

	public TransactionHistroyId() {
	}

	public TransactionHistroyId(Long id, Long userMetadataId) {
		this.id = id;
		this.userMetadataId = userMetadataId;
	}

	@Column(name = "ID", nullable = false, precision = 32, scale = 0)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "USER_METADATAID", nullable = false, precision = 32, scale = 0)
	public Long getUserMetadataId() {
		return this.userMetadataId;
	}

	public void setUserMetadataId(Long userMetadataId) {
		this.userMetadataId = userMetadataId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof TransactionHistroyId))
			return false;
		TransactionHistroyId castOther = (TransactionHistroyId) other;

		return ((this.getId() == castOther.getId()) || (this.getId() != null && castOther.getId() != null && this.getId()
				.equals(castOther.getId())))
				&& ((this.getUserMetadataId() == castOther.getUserMetadataId()) || (this.getUserMetadataId() != null
						&& castOther.getUserMetadataId() != null && this.getUserMetadataId().equals(
						castOther.getUserMetadataId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getId() == null ? 0 : this.getId().hashCode());
		result = 37 * result + (getUserMetadataId() == null ? 0 : this.getUserMetadataId().hashCode());
		return result;
	}

	@Override
	public String toString() {
		return "TransactionHistroyId [id=" + id + ", userMetadataId=" + userMetadataId + "]";
	}

}
