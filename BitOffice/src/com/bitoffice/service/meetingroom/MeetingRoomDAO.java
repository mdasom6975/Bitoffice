package com.bitoffice.service.meetingroom;

import java.util.List;

import com.bitoffice.common.Search;
import com.bitoffice.service.domain.MeetingRoom;

public interface MeetingRoomDAO {
	
	//회의실 추가
	public void addMeetingRoom(MeetingRoom meetingRoom) throws Exception;
	
	//회의실 관리 목록
	public List<MeetingRoom> getMeetingRoomList(Search search) throws Exception;

	//totalCount
	public int getTotalCount(Search search) throws Exception;
	
	//회의실 삭제
	public void deleteMeetingRoom(int meetingRoomCode) throws Exception;
	
	//회의실 중복체크
	public int codeCheck(int meetingRoomCode) throws Exception;
	
	public int nameCheck(String mettingRoomName) throws Exception;
	
	//회의실 수정
	public void updateMeetingRoom(MeetingRoom meetingRoom) throws Exception;
	
	public MeetingRoom getMeetingRoom(int mR) throws Exception;

	//json list
	public List<MeetingRoom> getReserveMeetingRoom() throws Exception;
	
}
