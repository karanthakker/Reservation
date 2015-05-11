/*package com.uottawa.seccharge.controller;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uottawa.seccharge.dao.Offer;
import com.uottawa.seccharge.dao.OffersDAO;

@Controller
public class secchargecontroller {*/

	/*@RequestMapping("/")
	public String showhome (HttpSession session){
		session.setAttribute("msg", "hello from controller, session obj");
		return "home";	
	}*/
	/*@RequestMapping("/")
	public ModelAndView showhome (){
		ModelAndView model = new ModelAndView("home");
		model.addObject("msgmv", "hello msg using model and view");
		
		return model;	
	}*/
	
	//recommended
/*	@RequestMapping("/")
	public String showhome (Model model){
		model.addAttribute("msgmdl", "hello from controller, using model");
		
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"com/seccharge/config/dao-context.xml");

		OffersDAO offersDao = (OffersDAO) context.getBean("offersDao");

		
		List<Offer> offers = offersDao.getOffers();
		for (Offer offer : offers) {
			System.out.println(offer);
		}
		model.addAttribute("myoffers",offers);
		
		return "home";	
	}
	
	
}*/
