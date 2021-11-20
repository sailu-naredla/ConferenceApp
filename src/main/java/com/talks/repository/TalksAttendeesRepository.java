/**
 * 
 */
package com.talks.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.talks.entity.TalkAttendeesEntity;
import com.talks.entity.TalksEntity;

/**
 * @author snaredl
 *
 */
@Repository
public interface TalksAttendeesRepository extends CrudRepository<TalkAttendeesEntity, Integer>{
	
	@Query("SELECT talksT FROM TalkAttendeesEntity talksT WHERE talksT.talk = :talk order by talksT.mappingId desc")
    List<TalkAttendeesEntity> findAllByTalks(TalksEntity talk);

}
