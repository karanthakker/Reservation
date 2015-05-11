/*
 * 
 * @Author Karan Thakker
 */

package com.uottawa.seccharge.dao;

import java.util.Date;

import com.uottawa.seccharge.dataobjects.Reservation;

/*
 * This interface is used as dao interface for Reservation table
 */

public interface ReservationSaveDao {
	
	
	/*
	 * This method is used for saving entries back int the Reservation table
	 * 
	 */
	 public void updateTable(Reservation res);
	 
	 void updateTimeOfCancellation(Date timeCancellation, Long reservationId);

	public void emptyTable();

	public void updateEntries(Reservation reservation);


}
