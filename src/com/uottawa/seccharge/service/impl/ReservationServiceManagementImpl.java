/*
 * @Author -- Karan Thakker
 * 
 */


package com.uottawa.seccharge.service.impl;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;











import com.uottawa.seccharge.dao.CSSiteDao;
import com.uottawa.seccharge.dao.ReservationSaveDao;
//import com.uottawa.seccharge.dao.ReservationSaveDao;
import com.uottawa.seccharge.dao.ReservationServiceManagementDao;
import com.uottawa.seccharge.dao.SecUserDao;
import com.uottawa.seccharge.dao.TimeSlot;
import com.uottawa.seccharge.dataobjects.CsSite;
import com.uottawa.seccharge.dataobjects.Reservation;
import com.uottawa.seccharge.dataobjects.SecChargeUser;
import com.uottawa.seccharge.dataobjects.SiteReservation;
import com.uottawa.seccharge.service.ReservationServiceManagement;


@Service("ReservationServiceManagement")
public class ReservationServiceManagementImpl implements ReservationServiceManagement {

	//UI string from front end
	private static final String UI_string = null;
	@Autowired
	ReservationServiceManagementDao reservationServiceManagementDao;
	@Autowired
	ReservationSaveDao reservationDao;
	
	@Autowired
    SecUserDao secUserDao;
	
	@Autowired
    CSSiteDao csSiteDao;
	
	/*
	@Override
	public List<TimeSlot> findTimeSlotsOfChargingStationOnThatDay(
			String UI) {
		// TODO Auto-generated method stub
		//tring string = "January 2, 2010";
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date=null;
		try {
			date = format.parse(UI_string);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	//	 List<SiteReservation> csSiteReserveInfos = reservationServiceManagementDao.
		//		 findByStartTime(date);

		// Long cs_site_id = cs_res.getCsId();
		 
		 // Hardcode the value of the date which is from the UI
		 
		 int cs_site_id = 12;
		 
		// Iterator<SiteReservation> iterator = csSiteReserveInfos.iterator();
		 for (; iterator.hasNext();) {
			SiteReservation csSiteReservationInfo =  iterator.next();
			
			/**
			 * getStartTimeDate from the UI and compare with the date from starttime (typecast)
			
			if(!csSiteReservationInfo.getCsId().equals(cs_site_id) 
					&& csSiteReservationInfo.getStartTime().equals(cs_site_id)){
				iterator.remove();
			}
		}
		 
		iterator = null;
		
		List<TimeSlot> list = new ArrayList<TimeSlot>();
		Iterator<SiteReservation> iterator2 =  csSiteReserveInfos.iterator();
		while (iterator2.hasNext()) {
			SiteReservation csSiteReservationInfo =  iterator2.next();
			
	/*		list.add(new TimeSlot(csSiteReservationInfo.getStartTime(), 
					csSiteReservationInfo.getEndTime()));
		}
		
		}
		return list;

	
		
	}
	
	*/
/*
	@Override
	public List<TimeSlot> findAvaliableTimeSlots(SiteReservation cs_res) {
		// TODO Auto-generated method stub
		return null;
	}
*/
/*
 *  method for writing back into the table SiteReservation
 */
	@Override
	public void updateNewEntries(SiteReservation cs_res) {
		 reservationServiceManagementDao.updateEntries(cs_res); 
		
		// TODO Auto-generated method stub
		
	}
/*
 * Method for finding out the maximum entry in the reservation ID eventually to be used as auto increment 
 * 
 */
	@Override
	public Long getMaxId() {
		// TODO Auto-generated method stub
		return reservationServiceManagementDao.getMaxId();
	}
	
	/*
	 * method for saving back in to the table Reservation through the Dao interface
	 */

	@Override
	public void update(Reservation res) {
		// TODO Auto-generated method stub
		reservationDao.updateTable(res);
		
	}

	/*
	 * method used for returning a refined list of time slots from the database for the date chosen from UI (user-selected)
	 */
	@Override
	public List<SiteReservation> findByStartTimes(Date start, Date end) {
		// TODO Auto-generated method stub
		return reservationServiceManagementDao.findByStartTimes(start,end);
	}
	@Override
	public SecChargeUser findByID(Long id) {
		// TODO Auto-generated method stub
		return secUserDao.findByID(id);
	}
	
	@Override
	public CsSite findByCSsSiteID(Long id) {
		// TODO Auto-generated method stub
		return csSiteDao.findByID(id);
	}
	@Override
	public void emptyTable() {
		// TODO Auto-generated method stub
		secUserDao.emptyTable();
		csSiteDao.emptyTable();
		reservationServiceManagementDao.emptyTable();
		reservationDao.emptyTable();
		
	}
	@Override
	public void updateTimeOfCancellation(Date timeCancellation,
			Long reservationId) {
		// TODO Auto-generated method stub
		reservationDao.updateTimeOfCancellation(timeCancellation, reservationId);
		
	}
	@Override
	public void deleteByReservationId(Long id) {
		// TODO Auto-generated method stub
		reservationServiceManagementDao.deleteByReservationId(id);
		
	}
	@Override
	public List<SiteReservation> findByStartTime(Date startTime, Long id) {
		// TODO Auto-generated method stub
		return reservationServiceManagementDao.findByStartTime(startTime, id);
	}
	@Override
	public List<SiteReservation> findByDatesBetween(Date departure, Date arrival) {
		// TODO Auto-generated method stub
		return reservationServiceManagementDao.findByDatesBetween(departure, arrival);
	}
	@Override
	public SiteReservation findByReservationId(Long id) {
		// TODO Auto-generated method stub
		
		return reservationServiceManagementDao.findByReservationId(id);
		
	}
	@Override
	public void updateNewEntries(SecChargeUser secuser) {
		// TODO Auto-generated method stub
		secUserDao.updateEntries(secuser);
		
	}
	@Override
	public void updateNewEntries(CsSite csSite) {
		// TODO Auto-generated method stub
		csSiteDao.updateEntries(csSite); 
		
	}
	@Override
	public void updateNewEntries(Reservation reservation) {
		// TODO Auto-generated method stub
		
		 reservationDao.updateEntries(reservation); 
		
	}
	
	
	
/*	
 * Method used for clearing all the entries from the table
	public void emptyTable() {
		reservationServiceManagementDao.emptyTable();
	}
	
	public void createListOfStartEndTimes(SiteReservation cs_res) {

		reservationServiceManagementDao.createListOfTimes(cs_res);
	}
	@Override
	public List<SiteReservation> findAvailabilitybyDate(String d) {
		return reservationServiceManagementDao.findByStartTime(d);
	}
*/

}
