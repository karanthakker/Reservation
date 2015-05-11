/*
 * @Author - Karan Thakker
 * 
 */

package com.uottawa.seccharge.repository;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.uottawa.seccharge.dataobjects.SiteReservation;
import com.uottawa.seccharge.dataobjects.SiteReservationId;

/*
 * Repository class used for the table SiteReservation
 * 
 */
public interface ReservationRepository extends CrudRepository <SiteReservation, Serializable> {
	
	
	/*
	 * This method is used for cancelling the reservation
	 * 
	 */
	@Query ("Select s from SiteReservation s "+"where s.startTime>=?1 and s.reservation.id in (select"
			+ " r.id from Reservation r where r.secChargeUser.id = ?2)")
	List<SiteReservation> findByStartTime (Date startTime, Long id);
	
	@Modifying  
	@Transactional
	@Query ("Delete from SiteReservation s where s.reservation.id = ?1")
	public void deleteByReservationId(Long id);
	/*
	 * Using the query to find and return a list of booked reservations from the database
	 * 
	 *  Eventually to compare with 48 time slots of list to find out if slots are available or booked
	 * 
	 */
	
	@Query("select s from SiteReservation s where s.reservation.id = ?1") 
	public SiteReservation findByReservationId(Long id);
	
	@Query("select s from SiteReservation s " +
	         "where s.endTime >= ?1 and s.endTime<= ?2")
	  List<SiteReservation> findByDatesBetween(Date departure, Date arrival);
	
	@Override
	public List<SiteReservation> findAll();

	
//	public SiteReservation save(SiteReservation cs_res);
//	List<SiteReservation> findByStartTime(String s);
	
	@Query ("select max(id.id) from SiteReservation")
	public Long getMaxId();
	
	
	/*
	 * This query is used for finding and returning the time slots as not applicable since the current time for booking
	 * is also past that time slot on the day
	 * 
	 * For example, if the current time is 08:00, all time slots, available or booked, should be shown not applicable to the
	 * user since the time has already passed.
	 * 
	 */
	@Query ("Select s from SiteReservation s "+"where s.startTime>=?1 and s.startTime<=?2")
	public List<SiteReservation> findByStartTimes (Date start, Date end );
/*	
	@Query("SELECT * FROM SITE_RESERVATION s WHERE s.STARTTIME LIKE %:searchTerm%")
     List<SiteReservation> searchWithJPQLQuery(@Param("searchTerm") String searchTerm);
*/	
 

}
