/*
 * @Author Karan Thakker
 * 
 */

package com.uottawa.seccharge.dao.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.uottawa.seccharge.dao.ReservationSaveDao;
import com.uottawa.seccharge.dataobjects.Reservation;
import com.uottawa.seccharge.repository.ReservationTableRepository;


@Transactional
@Component("ReservationSaveDao")

/*
 * This class is an implementation for Reservation table
 */

public class ReservationSaveDaoImpl implements ReservationSaveDao {

	@Autowired
	ReservationTableRepository resTable;
	
	@Override
	public void updateTable(Reservation res) {
		
		resTable.save(res);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateTimeOfCancellation(Date timeCancellation,
			Long reservationId) {
		// TODO Auto-generated method stub
		resTable.updateTimeOfCancellation(timeCancellation, reservationId);
		
	}

	@Override
	public void emptyTable() {
		// TODO Auto-generated method stub
		resTable.deleteAll();
	}

	@Override
	public void updateEntries(Reservation reservation) {
		// TODO Auto-generated method stub
		resTable.save(reservation);
		
	}

}
