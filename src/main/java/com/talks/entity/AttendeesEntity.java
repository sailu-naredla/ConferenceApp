/**
 * 
 */
package com.talks.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author snaredl
 *
 */
@Entity
@Table(name = "attendees")
public class AttendeesEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int attendeeId;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "compnay")
	private String compnay;
	
	@Column(name = "bio_data")
	private String bioData;
	
	@Column(name = "registered_on")
    private Timestamp registeredDateTime;
	
	@Column(name = "updated_on")
    private Timestamp updatedDateTime;

	public int getAttendeeId() {
		return attendeeId;
	}

	public void setAttendeeId(int attendeeId) {
		this.attendeeId = attendeeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCompnay() {
		return compnay;
	}

	public void setCompnay(String compnay) {
		this.compnay = compnay;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBioData() {
		return bioData;
	}

	public void setBioData(String bioData) {
		this.bioData = bioData;
	}

	public Timestamp getRegisteredDateTime() {
		return registeredDateTime;
	}

	public void setRegisteredDateTime(Timestamp registeredDateTime) {
		this.registeredDateTime = registeredDateTime;
	}

	public Timestamp getUpdatedDateTime() {
		return updatedDateTime;
	}

	public void setUpdatedDateTime(Timestamp updatedDateTime) {
		this.updatedDateTime = updatedDateTime;
	}

	
}
