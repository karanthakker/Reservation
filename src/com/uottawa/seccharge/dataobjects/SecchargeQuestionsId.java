package com.uottawa.seccharge.dataobjects;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * SecchargeQuestionsId generated by hbm2java
 */
@Embeddable
public class SecchargeQuestionsId implements Serializable {

	private Long secChargeUserId;
	private int securityQuestionsId;

	public SecchargeQuestionsId() {
	}

	public SecchargeQuestionsId(Long secChargeUserId, int securityQuestionsId) {
		this.secChargeUserId = secChargeUserId;
		this.securityQuestionsId = securityQuestionsId;
	}

	@Column(name = "SECCHARGE_USERID", nullable = false, precision = 32, scale = 0)
	public Long getSecChargeUserId() {
		return this.secChargeUserId;
	}

	public void setSecChargeUserId(Long secChargeUserId) {
		this.secChargeUserId = secChargeUserId;
	}

	@Column(name = "SECURITY_QUESTIONSID", nullable = false, precision = 5, scale = 0)
	public int getSecurityQuestionsId() {
		return this.securityQuestionsId;
	}

	public void setSecurityQuestionsId(int securityQuestionsId) {
		this.securityQuestionsId = securityQuestionsId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof SecchargeQuestionsId))
			return false;
		SecchargeQuestionsId castOther = (SecchargeQuestionsId) other;

		return ((this.getSecChargeUserId() == castOther.getSecChargeUserId()) || (this.getSecChargeUserId() != null
				&& castOther.getSecChargeUserId() != null && this.getSecChargeUserId()
				.equals(castOther.getSecChargeUserId())))
				&& (this.getSecurityQuestionsId() == castOther.getSecurityQuestionsId());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getSecChargeUserId() == null ? 0 : this.getSecChargeUserId().hashCode());
		result = 37 * result + this.getSecurityQuestionsId();
		return result;
	}

	@Override
	public String toString() {
		return "SecchargeQuestionsId [secChargeUserId=" + secChargeUserId + ", securityQuestionsId=" + securityQuestionsId
				+ "]";
	}
}
