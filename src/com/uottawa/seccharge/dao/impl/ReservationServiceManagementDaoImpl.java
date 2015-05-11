package com.uottawa.seccharge.dao.impl;
//
//import java.io.Serializable;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.uottawa.seccharge.dao.ReservationServiceManagementDao;
import com.uottawa.seccharge.dataobjects.SiteReservation;
import com.uottawa.seccharge.repository.ReservationRepository;

@Transactional
@Component("ReservationServiceManagementDao")

/*
 * This class is an implementation for SiteReservation table DAO interface
 */

public class ReservationServiceManagementDaoImpl implements ReservationServiceManagementDao{

	@Autowired
	ReservationRepository resRepo;
	
//	@Override
//	public List<TimeSlot> findTimeSlotsOfChargingStationOnThatDay(
//			SiteReservation cs_res) {
//		// TODO Auto-generated method stub
//		
///*		List<SiteReservation> csSiteReserveInfos = resRepo.findBystartTimeAndendTime(
//				cs_res.getStartTime(), cs_res.getEndTime());
//				
//*/				
//		return null;
//	}
//
	
	/*
	 * Another list of return times that can possibly be reduced for the specific date selected
	 */
	
	@Override
	public List<SiteReservation> findByDatesBetween(Date departure, Date arrival) {
		// TODO Auto-generated method stub
		return resRepo.findByDatesBetween(departure, arrival);
	}

	 /*
	 * method for saving back in to the table SiteReservation through the Repository interface
	 */


	@Override
	public void updateEntries(SiteReservation cs_res) {
		// TODO Auto-generated method stub
		resRepo.save(cs_res);
		
	}
	
	 /*
	  * Method for finding out the maximum entry in the reservation ID eventually to be used as auto increment 
	  * 
	  */


	@Override
	public Long getMaxId() {
		// TODO Auto-generated method stub
		return resRepo.getMaxId();
	}

	 /*
	  * method used for returning a refined list of time slots from the database for the date chosen from UI (user-selected)
	  */


	
	@Override
	public List<SiteReservation> findByStartTimes(Date start, Date end) {
		// TODO Auto-generated method stub
		return resRepo.findByStartTimes(start,end);
	}

	@Override
	public void deleteByReservationId(Long id) {
		// TODO Auto-generated method stub
		resRepo.deleteByReservationId(id);
	}

	@Override
	public List<SiteReservation> findByStartTime(Date startTime, Long id) {
		// TODO Auto-generated method stub
		return resRepo.findByStartTime(startTime, id);
	}

	@Override
	public SiteReservation findByReservationId(Long id) {
		return resRepo.findByReservationId(id); 
	}

	@Override
	public void emptyTable() {
		// TODO Auto-generated method stub
		
		resRepo.deleteAll();
		
	}


	
/*
	public void emptyTable() {
		resRepo.deleteAll();
	}

	
	@Override
	public void createListOfTimes(SiteReservation cs_res) {
		// TODO Auto-generated method stub
		resRepo.save(cs_res);
	}

*/
/*
	@Override
	public List<SiteReservation> findByStartTime(String s) {
		return resRepo.searchWithJPQLQuery(s);
	}
	
*/	



}