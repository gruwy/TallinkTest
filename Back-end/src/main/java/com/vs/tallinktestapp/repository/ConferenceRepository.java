package com.vs.tallinktestapp.repository;

import com.vs.tallinktestapp.entity.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ConferenceRepository extends JpaRepository<ConferenceEntity, Long> {
    
	// Initializing
	Optional<ConferenceEntity> findById(Long id);

    // Query
	@Modifying
    @Query("DELETE FROM ConferenceEntity c WHERE c.id = :id")
    void delete(@Param("id") Long id);
    
}
