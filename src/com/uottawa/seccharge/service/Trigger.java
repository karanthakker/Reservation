/*
 * @Author - Karan Thakker
 */

package com.uottawa.seccharge.service;



import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.uottawa.seccharge.dao.ReservationSaveDao;
import com.uottawa.seccharge.dao.ReservationServiceManagementDao;
import com.uottawa.seccharge.dataobjects.SiteReservation;



public class Trigger {
	@Autowired
	ReservationServiceManagementDao reservationServiceManagementDao ;
	
	public void SendReminderNotification() {
		  // printing current system time
		MailingService mailingService = new MailingService();
		
		Date start = new Date();
		Date end = new Date();
		
		/*
		 * Since the time slots are of 30 minutes each, in order to catch the trigger which is scheduled
		 * to check for every 30 minutes and send all the entries or users an email reminding of their reservation slots.
		 * 29 and 31 below have been chosen to capture the trigger to the database
		 */
		start.setMinutes(start.getMinutes()+29);
		
		end.setMinutes(end.getMinutes()+31);

		List <SiteReservation> reminderTimes = reservationServiceManagementDao.
				findByStartTimes(start, end);
 
		 System.out.println(reminderTimes.size());
		
		  System.out.println("Current Time : " + Calendar.getInstance().getTime()); 
		  
		  Iterator <SiteReservation> iterator = reminderTimes.iterator();
		  
		  /*
		   * Send email to all the users reminding them of their time slots
		   * 
		   */
		  while(iterator.hasNext())
		  {
			  
			  SiteReservation cs_res = iterator.next();
				String body = "This is a reminder that your reservation ID" + cs_res.getId().
						getReservationId()+ "is at"+
						"\n" + "on"+cs_res.getStartTime();
				System.out.println("Before");
				/*
				 * Here in order to test, I had added my email id. Instead once the use case 1.1 is completed,
				 * 
				 * call SecChargeUser's email id object here
				 * 
				 */
				
				mailingService.sendMail("karanthakker91@gmail.com", "Reminder", body);
			  
		  }
		  
		  
		  
		 }

		}
