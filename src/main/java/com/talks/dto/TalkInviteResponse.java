/**
 * 
 */
package com.talks.dto;

/**
 * @author snaredl
 *
 */
public class TalkInviteResponse {
	
	private String email;
	
	private String title;
    
    private String response;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

}
