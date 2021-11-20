/**
 * 
 */
package com.talks.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author snaredl
 *
 */
@Entity
@Table(name = "talk_attendees_details")
public class TalkAttendeesEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int mappingId;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "talks_id_fk")
    private TalksEntity talk;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "attendees_id_fk")
    private AttendeesEntity attendee;
	
	@Column(name = "registered_on")
    private Timestamp registeredDateTime;

	public int getMappingId() {
		return mappingId;
	}

	public void setMappingId(int mappingId) {
		this.mappingId = mappingId;
	}

	public TalksEntity getTalk() {
		return talk;
	}

	public void setTalk(TalksEntity talk) {
		this.talk = talk;
	}

	public AttendeesEntity getAttendee() {
		return attendee;
	}

	public void setAttendee(AttendeesEntity attendee) {
		this.attendee = attendee;
	}

	public Timestamp getRegisteredDateTime() {
		return registeredDateTime;
	}

	public void setRegisteredDateTime(Timestamp registeredDateTime) {
		this.registeredDateTime = registeredDateTime;
	}
	
}
