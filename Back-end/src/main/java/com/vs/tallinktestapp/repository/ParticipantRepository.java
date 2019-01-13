package com.vs.tallinktestapp.repository;

import com.vs.tallinktestapp.entity.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ParticipantRepository  extends JpaRepository<ParticipantEntity, Long> {
    
	Optional<ParticipantEntity> findById(Long id);

    @Modifying
    @Query("delete from ParticipantEntity c where c.id = :id")
    void delete(@Param("id") Long id);
    
}
