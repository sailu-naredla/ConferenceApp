/**
 * 
 */
package com.talks.service.impl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.talks.dto.AttendeeRequest;
import com.talks.dto.AttendeeResponse;
import com.talks.dto.TalkInviteResponse;
import com.talks.dto.TalksRequest;
import com.talks.dto.TalksResponse;
import com.talks.entity.AttendeesEntity;
import com.talks.entity.RoomsEntity;
import com.talks.entity.TalkAttendeesEntity;
import com.talks.entity.TalksEntity;
import com.talks.exception.InvalidInputException;
import com.talks.repository.AttendeesRepository;
import com.talks.repository.RoomsRepository;
import com.talks.repository.TalksAttendeesRepository;
import com.talks.repository.TalksRepository;
import com.talks.service.TalksService;
import com.talks.utils.DateUtils;

/**
 * @author snaredl
 *
 */
@Service
public class TalksServiceImpl implements TalksService {
	
	 private static final Logger LOGGER = LoggerFactory.getLogger(TalksServiceImpl.class);
	
	@Autowired
	TalksRepository talksRepository;
	
	@Autowired
	AttendeesRepository attendeesRepository;
	
	@Autowired
	RoomsRepository roomsRepository;
	
	@Autowired
	TalksAttendeesRepository talksAttendeesRepository;

	@Override
	public TalksResponse addNewTalk(TalksRequest talksRequest) {
		
		String logPrefix = TalksServiceImpl.class.toString() + ":: addNewTalk()::";
		LOGGER.info(logPrefix+"Entering addNewTalk()");
		TalksResponse talksResponse = new TalksResponse();
		try{
			if(null != talksRequest){
				if(null != talksRequest.getSpeaker()){
					AttendeesEntity attendeesEntity = new AttendeesEntity();
					attendeesEntity.setEmail(talksRequest.getSpeaker().getEmail());
					attendeesEntity.setName(talksRequest.getSpeaker().getName());
					attendeesEntity.setCompnay(talksRequest.getSpeaker().getCompany());
					attendeesEntity.setBioData(talksRequest.getSpeaker().getBio());
					attendeesEntity.setRegisteredDateTime(DateUtils.getTimestamp());
					attendeesEntity.setUpdatedDateTime(DateUtils.getTimestamp());
					//Save speaker
					attendeesRepository.save(attendeesEntity);
					
					//Pull Available Room
					RoomsEntity talksRoom = roomsRepository.findByRoomsNumber(talksRequest.getRoom());
					
					TalksEntity talksEntity = new TalksEntity();
					talksEntity.setTitle(talksRequest.getTitle());
					talksEntity.setTalkAbstract(talksRequest.getTalkAbstract());
					talksEntity.setSpeaker(attendeesEntity);
					talksEntity.setStatus(true);
					talksEntity.setRoom(talksRoom);
					talksEntity.setCreatedOn(DateUtils.getTimestamp());
					
					//Save new Talk
					talksRepository.save(talksEntity);
					
					talksResponse.setTitle(talksRequest.getTitle());
					talksResponse.setResponse("ok");
				}
			}else {
				throw new InvalidInputException("invalid Talk Request");
			}
		} catch (InvalidInputException ex) {
           LOGGER.error(logPrefix+"Error in processing Add Talk request", ex);
            throw new InvalidInputException("Error in processing Add Talk request");
		} catch(Exception ex){
		   LOGGER.error(logPrefix+"Error in processing Add Talk request ", ex);
	    }
		LOGGER.info(logPrefix+"Exiting addNewTalk()");
		return talksResponse;

	}

	@Override
	public AttendeeResponse addAttendee(AttendeeRequest attendeeRequest) {
		
		String logPrefix = TalksServiceImpl.class.toString() + ":: addAttendee()::";
		LOGGER.info(logPrefix+"Entering addAttendee()");
		
		AttendeeResponse attendeeResponse = new AttendeeResponse();
		try{
			if(null != attendeeRequest){
					AttendeesEntity attendeesEntity = new AttendeesEntity();
					attendeesEntity.setEmail(attendeeRequest.getEmail());
					attendeesEntity.setName(attendeeRequest.getName());
					attendeesEntity.setCompnay(attendeeRequest.getCompnay());
					attendeesEntity.setRegisteredDateTime(DateUtils.getTimestamp());
					attendeesEntity.setUpdatedDateTime(DateUtils.getTimestamp());
					//Save Talk Attendee Details
					attendeesRepository.save(attendeesEntity);
					
					
					attendeeResponse.setEmail(attendeeRequest.getEmail());
					attendeeResponse.setResponse("ok");
					
			}else {
				throw new InvalidInputException("invalid Add Attendee Request");
			}
		} catch (InvalidInputException ex) {
	           LOGGER.error(logPrefix+"Error in processing Add Attendee request", ex);
	            throw new InvalidInputException("Error in processing Add Attendee request");
		} catch(Exception ex){
			   LOGGER.error(logPrefix+"Error in processing Add Attendee request ", ex);
		}
		LOGGER.info(logPrefix+"Exiting addAttendee()");
		return attendeeResponse;
	}

	@Override
	public TalkInviteResponse addAttendeeToTalk(String talkId, String attendeeId) {
		
		String logPrefix = TalksServiceImpl.class.toString() + ":: addAttendeeToTalk()::";
		LOGGER.info(logPrefix+"Entering addAttendeeToTalk()");
		
		TalkInviteResponse talkInviteResponse = new TalkInviteResponse();
		try{
			if(!StringUtils.isEmpty(talkId) && !StringUtils.isEmpty(attendeeId)){
				Optional<TalksEntity> talks = talksRepository.findById(Integer.parseInt(talkId));
				Optional<AttendeesEntity> attendees = attendeesRepository.findById(Integer.parseInt(attendeeId));
				
				TalkAttendeesEntity talkAttendeesEntity = new TalkAttendeesEntity();
				talkAttendeesEntity.setAttendee(attendees.get());
				talkAttendeesEntity.setTalk(talks.get());
				talkAttendeesEntity.setRegisteredDateTime(DateUtils.getTimestamp());
				
				talksAttendeesRepository.save(talkAttendeesEntity);
				
				talkInviteResponse.setEmail(attendees.get().getEmail());
				talkInviteResponse.setTitle(talks.get().getTitle());
				talkInviteResponse.setResponse("ok");
				
			}else{
				throw new InvalidInputException("invalid Add Attendees to Talk Request");
			}
		} catch (InvalidInputException ex) {
	           LOGGER.error(logPrefix+"Error in processing Add Attendee request", ex);
	            throw new InvalidInputException("Error in processing Add Attendee request");
		} catch(Exception ex){
			   LOGGER.error(logPrefix+"Error in processing Add Attendee request ", ex);
		}
		LOGGER.info(logPrefix+"Exiting addAttendeeToTalk()");
		return talkInviteResponse;
	}

}
