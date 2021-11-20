/**
 * 
 */
package com.talks.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author snaredl
 *
 */
@Entity
@Table(name = "rooms")
public class RoomsEntity {
	
	@Id
	@Column(name = "id")
	private int roomId;
	
	@Column(name = "room_number")
	private String number;
	
	@Column(name = "status")
    private boolean status;
	
	@Column(name = "created_on")
    private Timestamp createdOn;
	
	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
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
	
}
