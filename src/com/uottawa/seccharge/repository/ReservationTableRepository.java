/*
 * @Author - Karan Thakker
 * 
 */

package com.uottawa.seccharge.repository;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.uottawa.seccharge.dataobjects.Reservation;

/*
 * Reservation Table repository interface if anything to be queried in future at all in the table Reservation
 * 
 */
public interface ReservationTableRepository extends CrudRepository <Reservation, Serializable>{

	@Modifying  
	@Transactional
	@Query ("update Reservation r set r.timeCancelation ="
			+ " ?1  where r.id = ?2")
	void updateTimeOfCancellation(Date timeCancellation, Long reservationId);

}
