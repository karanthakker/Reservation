/*
 * @Author - Karan Thakker
 */

package com.uottawa.seccharge.dao;

import java.io.Serializable;
import java.util.Date;

/*
 * This class is primarily for introducing flags like isAvailable and 
 * notAvailable as well as generating 48 time slots for everyday assuming 
 *  Time Slots are half an hour each
 * The flags used are primarily to show and find out from backend which timeslots are available and which ones
 * are booked. 
 * 
 * 
 * 
 */
public class TimeSlot {
	
	private String startTime ;
	private String endTime ;
	private boolean available = true;
	private boolean notAvailable = false;
	
	public boolean isAvailable() {
		return available;
	}
	public boolean isNotAvailable() {
		return notAvailable;
	}

	
	public void setAvailable(boolean isAvailable) {
		this.available = isAvailable;
	}
	public void setNotAvailable(boolean notAvailable) {
		this.notAvailable = notAvailable;
	}

	public TimeSlot(){}

	public TimeSlot(String startTime, String endTime) {
		super();
		this.startTime = startTime;
		this.endTime = endTime;
	}

	
	public String getStartTime() {
		return startTime;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((endTime == null) ? 0 : endTime.hashCode());
		result = prime * result
				+ ((startTime == null) ? 0 : startTime.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TimeSlot other = (TimeSlot) obj;
		if (endTime == null) {
			if (other.endTime != null)
				return false;
		} else if (!endTime.equals(other.endTime))
			return false;
		if (startTime == null) {
			if (other.startTime != null)
				return false;
		} else if (!startTime.equals(other.startTime))
			return false;
		return true;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

}
