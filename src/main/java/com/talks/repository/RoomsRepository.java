/**
 * 
 */
package com.talks.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.talks.entity.RoomsEntity;

/**
 * @author snaredl
 *
 */
@Repository
public interface RoomsRepository extends CrudRepository<RoomsEntity, Integer>{
	
	@Query("SELECT r FROM RoomsEntity r WHERE r.number = :number")
	RoomsEntity findByRoomsNumber(@Param("number") String number);

}
