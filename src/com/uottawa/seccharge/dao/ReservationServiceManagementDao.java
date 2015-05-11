/*
 * @Author - Karan Thakker
 * 
 */

package com.uottawa.seccharge.dao;
import java.util.Date;
import java.util.List;

import com.uottawa.seccharge.dataobjects.SiteReservation;

/*
 * This interface is used as dao interface for SiteReservation table
 */

public interface ReservationServiceManagementDao {

	public void deleteByReservationId(Long id);
	/*
	 * Another list of return times that can possibly be reduced for the specific date selected
	 */
	
	 List<SiteReservation> findByDatesBetween(Date departure, Date arrival);
	 

	 List<SiteReservation> findByStartTime (Date startTime, Long id);
	 /*
		 * method for saving back in to the table SiteReservation through the Repository interface
		 */


	 public void updateEntries(SiteReservation cs_res);
	 
	 /*
	  * method used for returning a refined list of time slots from the database for the date chosen from UI (user-selected)
	  */

	 
	 public List<SiteReservation> findByStartTimes (Date start, Date end);
	 
	 /*
	  * Method for finding out the maximum entry in the reservation ID eventually to be used as auto increment 
	  * 
	  */
	 
	 public SiteReservation findByReservationId(Long id);

	 public Long getMaxId();

	public void emptyTable();

//	void emptyTable();
	
//	List<SiteReservation> findByStartTime(String s);
	
//	void createListOfTimes(SiteReservation cs_res);

	
//	void save(Serializable startTime, Serializable endTime);

}
