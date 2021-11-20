/**
 * 
 */
package com.talks.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.talks.dto.AttendeeRequest;
import com.talks.dto.AttendeeResponse;
import com.talks.dto.TalkAttendees;
import com.talks.dto.TalkInviteResponse;
import com.talks.dto.TalksRequest;
import com.talks.dto.TalksResponse;
import com.talks.exception.DataNotFoundException;
import com.talks.exception.DuplicateDataException;
import com.talks.exception.InvalidInputException;
import com.talks.exception.UnProcessableException;
import com.talks.service.TalksService;

/**
 * @author snaredl
 *
 */
@RestController
@RequestMapping(value = "/api/v1")
public class TalksController {
	
	 private static final Logger LOGGER = LoggerFactory.getLogger(TalksController.class);

	@Autowired
	private TalksService talksService;
	
	@PostMapping("/talksto")
	public ResponseEntity<Object> addTalk(@RequestBody TalksRequest talksRequest){
		
		ResponseEntity<Object> response = null;
		try {
			TalksResponse talksResponse = talksService.addNewTalk(talksRequest);
			response =  new ResponseEntity<>(talksResponse, HttpStatus.OK);
		} catch(DataNotFoundException dataNotFoundException){
			response =  new ResponseEntity<>(dataNotFoundException, HttpStatus.BAD_REQUEST);
		} catch(DuplicateDataException duplicateDataException){
			response =  new ResponseEntity<>(duplicateDataException, HttpStatus.ALREADY_REPORTED);
		} catch(Exception ex){
			response =  new ResponseEntity<>(new UnProcessableException("Unable to serve the request"), HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return response;
		
	}
	
	@PostMapping("/attendees")
	public ResponseEntity<Object> addAttedee(@RequestBody AttendeeRequest attendeeRequest){
		
		ResponseEntity<Object> response = null;
		try {
			AttendeeResponse attendeeResponse = talksService.addAttendee(attendeeRequest);
			response =  new ResponseEntity<>(attendeeResponse, HttpStatus.OK);
		} catch(DataNotFoundException dataNotFoundException){
			response =  new ResponseEntity<>(dataNotFoundException, HttpStatus.BAD_REQUEST);
		} catch(DuplicateDataException duplicateDataException){
			response =  new ResponseEntity<>(duplicateDataException, HttpStatus.ALREADY_REPORTED);
		} catch(Exception ex){
			response =  new ResponseEntity<>(new UnProcessableException("Unable to serve the request"), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
		
	}
	
	@PutMapping("/talks/{talk_id}/attendees/{attendee_id}")
	public ResponseEntity<Object> addAttendeeToTalk(@PathVariable("talk_id") String talkId, @PathVariable("attendee_id") String attendeeId){
		
		ResponseEntity<Object> response = null;
		try {
			TalkInviteResponse inviteResponse =talksService.addAttendeeToTalk(talkId, attendeeId);
			response =  new ResponseEntity<>(inviteResponse, HttpStatus.OK);
		} catch(DataNotFoundException dataNotFoundException){
			response =  new ResponseEntity<>(dataNotFoundException, HttpStatus.BAD_REQUEST);
		} catch(DuplicateDataException duplicateDataException){
			response =  new ResponseEntity<>(duplicateDataException, HttpStatus.ALREADY_REPORTED);
		} catch(Exception ex){
			response =  new ResponseEntity<>(new UnProcessableException("Unable to serve the request"), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
		
	}
	
	@GetMapping("/attendees/{talk_title}")
	public ResponseEntity<Object> getTalkAttendees(@PathVariable("talk_title") String title){
		
		ResponseEntity<Object> response = null;
		try {
			List<TalkAttendees> attendeesResponse = talksService.getAllAttendessByTalk(title);
			response =  new ResponseEntity<>(attendeesResponse, HttpStatus.OK);
		} catch(InvalidInputException invalidInputException){
			response =  new ResponseEntity<>(invalidInputException, HttpStatus.BAD_REQUEST);
		} catch(DuplicateDataException duplicateDataException){
			response =  new ResponseEntity<>(duplicateDataException, HttpStatus.ALREADY_REPORTED);
		} catch(Exception ex){
			response =  new ResponseEntity<>(new UnProcessableException("Unable to serve the request"), HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return response;
		
	}
	
}
