package com.uottawa.seccharge.test.tests;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.uottawa.seccharge.dataobjects.CsSite;
import com.uottawa.seccharge.dataobjects.Reservation;
import com.uottawa.seccharge.dataobjects.SecChargeUser;
import com.uottawa.seccharge.dataobjects.SiteReservation;
import com.uottawa.seccharge.dataobjects.SiteReservationId;
import com.uottawa.seccharge.dataobjects.UserMetadata;
import com.uottawa.seccharge.service.ReservationServiceManagement;
import com.uottawa.seccharge.service.SecchuserService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/com/uottawa/seccharge/test/config/persistence-test.xml" })
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
		DirtiesContextTestExecutionListener.class,
		TransactionalTestExecutionListener.class,
		DbUnitTestExecutionListener.class })

public class ReservationDAOTest {

	@Autowired
	ReservationServiceManagement reservationServiceManagement;
	
	
	 
	@Before
	public void init() {
	
	 		
	 		SecChargeUser testuser0 = new SecChargeUser(1L,"msemsar1", "123", "salt1", true, false);
	 		SecChargeUser testuser1 = new SecChargeUser(2L,"alexgr", "letmein", "salt2", true, false);
	 		SecChargeUser testuser2 = new SecChargeUser(3L, "katebr", "hellothere", "salt3", true, false);
	 		
	 		CsSite csSite1 = new CsSite (1L,"hb" , "Mr. XYZ", "1224 Meadowlands","Ott", "Ontario","Canada");
	 		CsSite csSite2 = new CsSite (2L,"hbhj" , "Mr. ABS", "1234 Meadowlands","OttA", "Ontar","Can");
	 		CsSite csSite3 = new CsSite (3L,"jbs" , "Mr. ABC", "1244 Meadowlands","OttAWA", "Onta","Cana");
	 		
	 		
	 	
	 		
	 		Date time1_start=null;
	 		Date time2_start=null;
	 		Date time3_start=null;
	 		
	 		Date time1_end=null;
	 		Date time2_end=null;
	 		Date time3_end=null;

	 		//Strings d1 and d2 to show the  reserved times
	 		String d1 = "2015-01-15";
			
	 		String d2 = "2015-01-16";
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			
			try {
				String time_start1=d1.concat(" ").concat("23:30:00");
				String time_end1 = d1.concat(" ").concat("23:59:59");
				time1_start = format.parse(time_start1);
				time1_end = format.parse(time_end1);
				
				String time_start2=d1.concat(" ").concat("21:30:00");
				String time_end2 = d1.concat(" ").concat("21:59:59");
				time2_start = format.parse(time_start2);
				time2_end = format.parse(time_end2);
				
				String time_start3=d2.concat(" ").concat("22:30:00");
				String time_end3 = d2.concat(" ").concat("22:59:59");
				time3_start = format.parse(time_start3);
				time3_end = format.parse(time_end3);
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			Date timecreated1=null;
			Date timecreated2=null;
			Date timecreated3=null;
			
			//String for time created for 3 reservations
			
			String d3 = "2015-01-03";
			
			
			try {
				String time1_created= d3.concat(" ").concat("00:00:00");
				String time2_created = d3.concat(" ").concat("23:59:59");
				String time3_created = d3.concat(" ").concat("22:59:59");
				
				timecreated1 = format.parse(time1_created);
				timecreated2 = format.parse(time2_created);
				timecreated3 = format.parse(time3_created);

				
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

	 		
	 		Reservation reservation1 = new Reservation (1L, testuser0,timecreated1, true);
	 		Reservation reservation2 = new Reservation (2L, testuser0,timecreated2, true);
	 		Reservation reservation3 = new Reservation (3L, testuser0,timecreated3, false);

	 		SiteReservationId site_id1 = new SiteReservationId (11L, csSite1.getId(), reservation1.getId());
	 		SiteReservationId site_id2 = new SiteReservationId (12L, csSite2.getId(), reservation2.getId());
	 		SiteReservationId site_id3 = new SiteReservationId (13L, csSite3.getId(), reservation3.getId());
	 		
	 		SiteReservation cs_res1 = new SiteReservation(site_id1, reservation1, csSite1, time1_start, time1_end);
	 		SiteReservation cs_res2 = new SiteReservation(site_id2, reservation2, csSite2, time2_start, time2_end);
	 		SiteReservation cs_res3 = new SiteReservation(site_id3, reservation3, csSite3, time3_start, time3_end);

	 		
	 		reservationServiceManagement.updateNewEntries(testuser0);
	 		reservationServiceManagement.updateNewEntries(testuser1);

	 		reservationServiceManagement.updateNewEntries(testuser2);

	 		reservationServiceManagement.updateNewEntries(csSite1);
	 		reservationServiceManagement.updateNewEntries(csSite2);

	 		reservationServiceManagement.updateNewEntries(csSite3);
	 		
	 		reservationServiceManagement.updateNewEntries(reservation1);
	 		reservationServiceManagement.updateNewEntries(reservation2);

	 		reservationServiceManagement.updateNewEntries(reservation3);
	 		
	 		
	 		reservationServiceManagement.updateNewEntries(cs_res1);
	 		reservationServiceManagement.updateNewEntries(cs_res2);

	 		reservationServiceManagement.updateNewEntries(cs_res3);

	 		
	 		
}
	@After
	public void destroy(){
		reservationServiceManagement.emptyTable();
	}
	@Test
	public void testReservation()
	{
		testCancellation();
		getReservationTimeList();
	}
		
	// to show the available or booked lists
	
	public void getReservationTimeList()
	{
		Date start=null;
		
		Date end=null;
		
		String d = "2015-01-16";
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		try {
			String start1=d.concat(" ").concat("00:00:00");
			String end1 = d.concat(" ").concat("23:59:59");
			end = format.parse(end1);

			start = format.parse(start1);

		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		
		List <SiteReservation> test_list =	reservationServiceManagement.
				findByStartTimes(start, end);
		
		
		System.out.println("Number of the reserved slots on that day is/are"+test_list.size());
		assertEquals("number of entries has to be", test_list.size(), 1);
	}
	
	// to see if the slot is cancelled or not
	
		// check size of the list
		
		public void testCancellation(){
			
			
			 reservationServiceManagement.deleteByReservationId(1L);
			
			 
			reservationServiceManagement.updateTimeOfCancellation(new Date(),1L );
			
	/*		
			Date start=new Date();
				start.setMinutes(start.getMinutes()+30);
				List <SiteReservation> siteReservations = reservationServiceManagement.
						findByStartTime(start,1L);
				
	*/
			 SiteReservation Cancelled = reservationServiceManagement.findByReservationId(1L); 
			
			assertNull("reservation with the id doesnt have to exist in DB", Cancelled);


		}
		


}