/**
 * 
 */
package com.talks.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.talks.entity.AttendeesEntity;
import com.talks.entity.TalksEntity;

/**
 * @author snaredl
 *
 */
@Repository
public interface TalksRepository extends CrudRepository<TalksEntity, Integer>{
	
	@Query("SELECT t FROM TalksEntity t WHERE t.title = :title")
	TalksEntity findByTalksTitle(@Param("title") String title);
	
	@Query("SELECT t FROM TalksEntity t WHERE t.title = :title and t.speaker = :speaker and t.status = 'true'")
	TalksEntity findByTalksTitleAndSpeaker(@Param("title") String title, @Param("speaker") AttendeesEntity speaker);

}
