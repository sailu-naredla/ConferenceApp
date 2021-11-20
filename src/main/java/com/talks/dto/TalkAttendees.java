/**
 * 
 */
package com.talks.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * @author snaredl
 *
 */
public class TalkAttendees {
	
	private String title;
	
	private String talkAbstract;
	
	private String room;
	
	private Speaker speaker;
	
	private List<AttendeeRequest>  attendees = new ArrayList<AttendeeRequest>();

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTalkAbstract() {
		return talkAbstract;
	}

	public void setTalkAbstract(String talkAbstract) {
		this.talkAbstract = talkAbstract;
	}

	public String getRoom() {
		return room;
	}

	public void setRoom(String room) {
		this.room = room;
	}

	public Speaker getSpeaker() {
		return speaker;
	}

	public void setSpeaker(Speaker speaker) {
		this.speaker = speaker;
	}

	public List<AttendeeRequest> getAttendees() {
		return attendees;
	}

	public void setAttendees(List<AttendeeRequest> attendees) {
		this.attendees = attendees;
	}
	

}
