/**
 * 
 */
package com.talks.service;

import java.util.List;

import com.talks.dto.AttendeeRequest;
import com.talks.dto.AttendeeResponse;
import com.talks.dto.TalkAttendees;
import com.talks.dto.TalkInviteResponse;
import com.talks.dto.TalksRequest;
import com.talks.dto.TalksResponse;
import com.talks.exception.InvalidInputException;

/**
 * @author snaredl
 *
 */
public interface TalksService {
	
	public TalksResponse addNewTalk(TalksRequest talksRequest);
	
	public AttendeeResponse addAttendee(AttendeeRequest attendeeRequest);
	
	public TalkInviteResponse addAttendeeToTalk(String talkId, String attendeeId);
	
	public List<TalkAttendees> getAllAttendessByTalk(String title) throws InvalidInputException;
	
}
