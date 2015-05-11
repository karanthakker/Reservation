/*
 * @Author -- Karan Thakker
 * 
 */



package com.uottawa.seccharge.service;


import java.util.Date;
import java.util.List;

import com.uottawa.seccharge.dao.TimeSlot;
import com.uottawa.seccharge.dataobjects.CsSite;
import com.uottawa.seccharge.dataobjects.Reservation;
import com.uottawa.seccharge.dataobjects.SecChargeUser;
import com.uottawa.seccharge.dataobjects.SiteReservation;
import com.uottawa.seccharge.dataobjects.SiteReservationId;

public interface ReservationServiceManagement {
	
	// public List<TimeSlot> findTimeSlotsOfChargingStationOnThatDay(String UI);
	
	public void deleteByReservationId(Long id);
	
	public SiteReservation findByReservationId(Long id);
	/*
	 *  method for writing back into the table SiteReservation
	 */

	 public void updateNewEntries(SiteReservation cs_res);
	 public void updateNewEntries(SecChargeUser secuser);
	 public void updateNewEntries(CsSite csSite);
	 public void updateNewEntries(Reservation reservation);
	 /*
		 * method for saving back in to the table Reservation through the Dao interface
		 */
 
	 
	 public void update(Reservation res);
	 
	 /*
	  * Method for finding out the maximum entry in the reservation ID eventually to be used as auto increment 
	  * 
	  */

	 public Long getMaxId();
	 
	 /*
	  * method used for returning a refined list of time slots from the database for the date chosen from UI (user-selected)
	  */
	 
	 public List<SiteReservation> findByStartTimes(Date start, Date end);
	 

//		public void emptyTable();
		

	 public SecChargeUser findByID (Long id);
				
	 public CsSite findByCSsSiteID (Long id);
	 
	 void updateTimeOfCancellation(Date timeCancellation, Long reservationId);
	 
	 public void emptyTable();
	 
	 List<SiteReservation> findByStartTime (Date startTime, Long id);
	 
	 List<SiteReservation> findByDatesBetween(Date departure, Date arrival);
	 
	


}
