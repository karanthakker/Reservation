//created by "Mehdi Semsarzadeh" - Core Development team - Dec. 04 2014 

package com.uottawa.seccharge.test.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Before;
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
import com.uottawa.seccharge.dataobjects.SecChargeUser;
import com.uottawa.seccharge.dataobjects.UserMetadata;
import com.uottawa.seccharge.service.SecchuserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/com/uottawa/seccharge/test/config/persistence-test.xml" })
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
		DirtiesContextTestExecutionListener.class,
		TransactionalTestExecutionListener.class,
		DbUnitTestExecutionListener.class })
public class SecchuserDAOTest {

	@Autowired
	private SecchuserService secchuserService;
	// put some dummy data before running any test
	@Before
	public void init() {
		
		
		Date mydate = new Date();
		SecChargeUser testuser0 = new SecChargeUser("msemsar1", "123", "salt1", true, false);
				
		UserMetadata testuserMetadata0 = new UserMetadata ("Mr.", testuser0, "mehdi", "semsar",
				"mehdi@msemsar.com", mydate, "ottawa", "Ontario");
		
		SecChargeUser testuser1 = new SecChargeUser("alexgr", "letmein", "salt2", true, true);
		
		UserMetadata testuserMetadata1 = new UserMetadata ("Mr.", testuser1, "alex", "green",
				"alex@green.com", mydate, "Tronto", "Ontario");
		
		SecChargeUser testuser2 = new SecChargeUser("katebr", "hellothere", "salt3", false, false);
		
		UserMetadata testuserMetadata2 = new UserMetadata ("Ms.", testuser2, "chaterin", "brown",
				"kate@gmail.com", mydate, "Montreal", "Quebece");

		secchuserService.createNewUserWithMetadata(testuserMetadata0);
		secchuserService.createNewUserWithMetadata(testuserMetadata1);
		secchuserService.createNewUserWithMetadata(testuserMetadata2);
	}
	
	

	//clean the DB after each test
	@After
	public void destroy(){
		secchuserService.emptyTable();
	}

	@Test
	public void getsecchuserList() {

		List<SecChargeUser> secChargeUserList0 = (List) secchuserService.getSecchuserList();
		for (SecChargeUser secChargeUser0 : secChargeUserList0)
			System.out.println(secChargeUser0);

		System.out.println("Number of items in secchargeuser table: "
				+ secChargeUserList0.size());
		assertEquals("number of all rows has to be three", secChargeUserList0.size(), 3);

	}

	/*@Test
	public void lookforaSalutationItem() {
		List<Salutations> SalutationsList1 = SecchuserService.findbysalutationType("Mr.");
		for (Salutations salutations : SalutationsList1)
			System.out.println(salutations);
		assertEquals("number of returned has to be one",
				SalutationsList1.size(), 1);

		SalutationsList1 = SecchuserService.findbysalutationType("Bart");
		for (Salutations salutations : SalutationsList1)
			System.out.println(salutations);
		assertEquals("number of returned has to be zero",
				SalutationsList1.size(), 0);

	}*/
@Test
public void getsecchargeMEtadataList() {
	List <UserMetadata> secChargeUserWithMetadataList0 = (List) secchuserService.getSecchuserWithMetadataList();
		

	System.out.println("Number of items in secchargeuserMetadata table: "
			+ secChargeUserWithMetadataList0.size());
	assertEquals("number of all rows in Metadata table has to be three", secChargeUserWithMetadataList0.size(), 3);
}

@Test
public void lookforUser(){
	SecChargeUser testuser = secchuserService.finduser("msemsar1");
	System.out.println(testuser);
	System.out.println(testuser.getUserMetadata());
	assertNotNull("A user with the username of msemsar1 has to exist in DB", testuser);
	testuser = secchuserService.finduser("msemsar123");
	assertNull("user with the username of msemsar123 doesnt have to exist in DB", testuser);
}

@Test
public void deleteuser(){
	secchuserService.deleteByusername("katebr");
	SecChargeUser testuser = secchuserService.finduser("katebr");
	assertNull("user with the username of chaterin doesnt have to exist in DB", testuser);
	
	//List <UserMetadata> secChargeUserWithMetadataList0 = (List) secchuserService.getSecchuserWithMetadataList();
	//assertEquals("number of all rows in Metadata table has to be two", secChargeUserWithMetadataList0.size(), 2);
}

@Test
public void finduserBySalut(){
	List <UserMetadata> testuserMetadataList = secchuserService.findByuserSalt("Mr.");
	for (UserMetadata testuserMetadata : testuserMetadataList)
		System.out.println(testuserMetadata);
	
	assertEquals("number of users with Mr. Salutation has to be two", testuserMetadataList.size(), 2);
}

}
