package com.bitoffice.service.reservation;

import java.util.Date;
import java.util.List;

import com.bitoffice.common.Search;
import com.bitoffice.service.domain.MeetingRoom;
import com.bitoffice.service.domain.Reservation;

public interface ReservationDAO {
	
	//예약
	public void addReservation(Reservation reservation) throws Exception;
	
	//예약 현황
	public List<Reservation> getReservationList(Search search) throws Exception;
	
	public int getTotalCount(Search search) throws Exception;
	
	public List<Reservation> myReservation(Search search, String employeeNo) throws Exception;
	
	public int myTotalCount(Search search, String employeeNo) throws Exception;
	
	//예약 수정
	public void updateReservation(Reservation reservation) throws Exception;
	
	public Reservation getReservation(int reNum) throws Exception;
	
	//예약 취소
	public void cancelReservation(int reNum) throws Exception;
	
	public List<MeetingRoom> testReserveMeetingRoom() throws Exception;
	
	public void autoDelete(Date reserveDate) throws Exception;
}
