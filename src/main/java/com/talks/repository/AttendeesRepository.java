/**
 * 
 */
package com.talks.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.talks.entity.AttendeesEntity;

/**
 * @author snaredl
 *
 */
@Repository
public interface AttendeesRepository extends CrudRepository<AttendeesEntity, Integer>{
	
	@Query("SELECT a FROM AttendeesEntity a WHERE a.email = :email")
	AttendeesEntity findByTalksTitle(@Param("email") String email);

}
