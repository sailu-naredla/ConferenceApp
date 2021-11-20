/**
 * 
 */
package com.talks.service;

import com.talks.dto.AttendeeRequest;
import com.talks.dto.AttendeeResponse;
import com.talks.dto.TalkInviteResponse;
import com.talks.dto.TalksRequest;
import com.talks.dto.TalksResponse;

/**
 * @author snaredl
 *
 */
public interface TalksService {
	
	public TalksResponse addNewTalk(TalksRequest talksRequest);
	
	public AttendeeResponse addAttendee(AttendeeRequest attendeeRequest);
	
	public TalkInviteResponse addAttendeeToTalk(String talkId, String attendeeId);
	
}
