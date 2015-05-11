/*
 * 
 * @Author Karan Thakker
 */
package com.uottawa.seccharge.controller;

//import java.sql.Date;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
//import java.util.TimeZone;















import oracle.sql.DatumWithConnection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.uottawa.seccharge.dao.TimeSlot;
import com.uottawa.seccharge.dataobjects.CsSite;
import com.uottawa.seccharge.dataobjects.Reservation;
import com.uottawa.seccharge.dataobjects.SecChargeUser;
import com.uottawa.seccharge.dataobjects.SiteReservation;
import com.uottawa.seccharge.dataobjects.SiteReservationId;
import com.uottawa.seccharge.repository.CSSiteRepository;
import com.uottawa.seccharge.repository.ReservationRepository;
import com.uottawa.seccharge.repository.ReservationTableRepository;
import com.uottawa.seccharge.repository.SecChargeUserRepository;
import com.uottawa.seccharge.service.MailingService;
import com.uottawa.seccharge.service.ReservationServiceManagement;
import com.uottawa.seccharge.service.SecchuserService;

@Controller
public class HomeController {

	@Autowired
	ReservationServiceManagement reservationServiceManagement;
	
	@Autowired
	ReservationTableRepository resTable;

	
	private List<TimeSlot> sample_list = new ArrayList<TimeSlot>();

	private String selected_date;

	private Logger logger = LoggerFactory.getLogger(HomeController.class);
	private SecchuserService secchuserService;

	@Autowired
	public void setSecchuserService(SecchuserService secchuserService) {
		this.secchuserService = secchuserService;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String welcomeFile(ModelMap model) {
		// model.addAttribute("mysecchuser", SecchuserList);

		return "home";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logoutFile(ModelMap model) {
		return "logout";
	}

	@RequestMapping(value = "/loginUser", method = RequestMethod.POST)
	public String loginFile(ModelMap model) {
		return "login";
	}


	@RequestMapping(value = "/searchStation", method = RequestMethod.GET)
	public String searchStation(ModelMap model) {
		return "searchStation";
	}

	@RequestMapping(value = "/cancel", method = RequestMethod.GET)
	public String cancelModifyReservation(ModelMap model,
			@RequestParam(value = "reservationId", required = false) String reservationId) {
		
		SiteReservation cs_res=null;
		if(reservationId!=null)
		{
//		resRepo.deleteByReservationId(Long.valueOf(reservationId));	
			
			 cs_res = reservationServiceManagement.findByReservationId(Long.valueOf(reservationId));
		
			reservationServiceManagement.deleteByReservationId(Long.valueOf(reservationId));
			
		resTable.updateTimeOfCancellation(new Date(),Long.valueOf(reservationId));
		}
		Date start=new Date();
		start.setMinutes(start.getMinutes()+30);
	//	List <SiteReservation> siteReservations = resRepo.findByStartTime(start,2L);
		
		
		//Depending on the user, the lond id for every entries for different users will change
		// Here it is 2 for the time being
		List <SiteReservation> siteReservations = reservationServiceManagement.
				findByStartTime(start, 2L);
		model.addAttribute("siteReservationList", siteReservations);
	//	reservationServiceManagement.findByReservationId(Long.valueOf(reservationId));
	
		if(cs_res!=null)
		{
			String body = "Your reservation for reservation id" + reservationId + "at"+ cs_res.getStartTime()+
		
				  
				"has been successfully cancelled";

		MailingService mailingService = new MailingService();
		mailingService.sendMail("karanthakker91@gmail.com", "Cancellation successful", body);
	}
		return "cancelReservation";
	}

	
	
	/*
	 * This method is the core controller method of my use case
	 */
	@RequestMapping(value = "/reserveStation", method = RequestMethod.GET)
	public String reserveStation(ModelMap model,
			@RequestParam(value = "d", required = false) String d, @RequestParam (value ="buttonType", required = false) String buttonType) throws ParseException {

	/*
	 * Button type to differentiate between the Go button and the available button to reserve the slots
	 *  String d is the value of date
	 */
		if (buttonType!=null)
		{
			
			if (buttonType.equalsIgnoreCase("Go"))
			{	    if (d != null) {
				selected_date = d;	
				model.addAttribute("is_date_passed", true);
				model.addAttribute("date_selected", selected_date);
				sample_list = processreserveStation(d);
				model.put("timeSlots",sample_list);

			} else {

				model.addAttribute("is_date_passed", false);
			}
			}
			else if(buttonType.equalsIgnoreCase("Available"))
			{
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

				
				TimeSlot timeslot= sample_list.get(Integer.parseInt(d));
				SiteReservation cs_res=new SiteReservation();
				cs_res.setStartTime(format.parse(timeslot.getStartTime()));
				cs_res.setEndTime(format.parse(timeslot.getEndTime()));
				sample_list.get(Integer.parseInt(d)).setAvailable(false);	
				
				
				CsSite csSite= reservationServiceManagement.findByCSsSiteID(1L);
//						csSite.setId(1L);
				cs_res.setCsSite(csSite);


				Long ID = reservationServiceManagement.getMaxId();
				if(ID==null)
					ID=0L;

				SecChargeUser secUser = reservationServiceManagement.findByID(2L);
				// SecCharge secUser;
				Reservation reservation= new Reservation();
				//secUser.setId(1L);
				reservation.setSecChargeUser(secUser);
				reservation.setActive(true);
				reservation.setTimeCreated(new Date());

				resTable.save(reservation);
				cs_res.setReservation(reservation);			    	
				SiteReservationId id = new SiteReservationId(ID+1L, csSite.getId(),
						reservation.getId());
			
				//This value should be obtained from 
				cs_res.setId(id);
				reservationServiceManagement.updateNewEntries(cs_res);
				model.addAttribute("is_date_passed", true);
				model.addAttribute("date_selected", selected_date);

				model.put("timeSlots",sample_list);
				String body = "Your reservation id is" + cs_res.getId().getReservationId()+
						"\n" + "on"+cs_res.getStartTime()+"at"+
						cs_res.getCsSite().getAddress1()+cs_res.getCsSite().getAddress2();

				MailingService mailingService = new MailingService();
				mailingService.sendMail("karanthakker91@gmail.com", "Reservation", body);
			}
		}
		return "reserveStation";
	}

	public List<TimeSlot> processreserveStation(String d){
		
	//	List<CsSite> csSites=(List<CsSite>) csSiteRepository.findAll();
		

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date startDate = null;
		Date endDate=null;
		try {
			String start=d.concat(" ").concat("00:00:00");
			String end = d.concat(" ").concat("23:59:59");
			endDate = format.parse(end);

			startDate = format.parse(start);

		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//List<SiteReservation> testList=resRepo.findAll();

		List<SiteReservation>  reservationsList=reservationServiceManagement.findByDatesBetween(startDate, endDate);
		List<TimeSlot> allTimeSlots = new ArrayList<TimeSlot>();
		Date date=new Date();
		for (int i = 0; i < 48; i++) {
			String StartTime,EndTime;	
			if (i%2 == 0)
			{
				if(i<20) {
					StartTime = d.concat(" ").concat("0").concat(i/2+ ":").concat("00:00.0");
					EndTime = d.concat(" ").concat("0").concat(i/2+ ":").concat("29:59.0");
				}else
				{
					StartTime = d.concat(" ").concat(i/2+ ":").concat("00:00.0");
					EndTime = d.concat(" ").concat(i/2+ ":").concat("29:59.0");
				}

			}
			else
			{
				if(i<20) {
					StartTime = d.concat(" ").concat("0").concat(i/2+ ":").concat("30:00.0");
					EndTime = d.concat(" ").concat("0").concat(i/2+ ":").concat("59:59.0");
				}else
				{
					StartTime = d.concat(" ").concat(i/2+ ":").concat("30:00.0");
					EndTime = d.concat(" ").concat(i/2+ ":").concat("59:59.0");
				}
			}

			TimeSlot timeSlot =new TimeSlot(StartTime, EndTime);
			Iterator<SiteReservation> iterator = reservationsList.iterator();
			
			while (iterator.hasNext()) {
				SiteReservation siteReservation =  iterator.next();
				if (siteReservation.getStartTime().toString().equalsIgnoreCase(StartTime) && 
						siteReservation.getEndTime().toString().equalsIgnoreCase(EndTime)) {
					timeSlot.setAvailable(false);
					break;
				}
			}
			if(StartTime.compareTo(format.format(date))<0)
			{
				timeSlot.setNotAvailable(true);
				timeSlot.setAvailable(false);
			}
			allTimeSlots.add(timeSlot);


		}

		return allTimeSlots;

	}
}
