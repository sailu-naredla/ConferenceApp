/**
 * 
 */
package com.talks.dto;

/**
 * @author snaredl
 *
 */
public class TalksRequest {

	private String title;
	
	private String talkAbstract;
	
	private String room;
	
	private Speaker speaker;

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
	
	
}
