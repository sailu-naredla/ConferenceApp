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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author snaredl
 *
 */
@Entity
@Table(name = "talks")
public class TalksEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int talkId;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "abstract")
	private String talkAbstract;
	
	@ManyToOne
    @JoinColumn(name = "speaker_attendees_id_fk")
    private AttendeesEntity speaker;
	
	@OneToOne
    @JoinColumn(name = "rooms_id_fk")
    private RoomsEntity room;
	
	@Column(name = "starts_at")
    private Timestamp startsAt;
	
	@Column(name = "ends_at")
    private Timestamp endsAt;
	
	@Column(name = "created_on")
    private Timestamp createdOn;
	
	@Column(name = "status")
    private boolean status;

	public int getTalkId() {
		return talkId;
	}

	public void setTalkId(int talkId) {
		this.talkId = talkId;
	}

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

	public AttendeesEntity getSpeaker() {
		return speaker;
	}

	public void setSpeaker(AttendeesEntity speaker) {
		this.speaker = speaker;
	}

	public RoomsEntity getRoom() {
		return room;
	}

	public void setRoom(RoomsEntity room) {
		this.room = room;
	}

	public Timestamp getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Timestamp createdOn) {
		this.createdOn = createdOn;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Timestamp getStartsAt() {
		return startsAt;
	}

	public void setStartsAt(Timestamp startsAt) {
		this.startsAt = startsAt;
	}

	public Timestamp getEndsAt() {
		return endsAt;
	}

	public void setEndsAt(Timestamp endsAt) {
		this.endsAt = endsAt;
	}
	
}
