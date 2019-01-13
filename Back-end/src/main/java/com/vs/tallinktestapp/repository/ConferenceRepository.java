package com.vs.tallinktestapp.repository;

import com.vs.tallinktestapp.entity.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ConferenceRepository extends JpaRepository<ConferenceEntity, Long> {
    
	Optional<ConferenceEntity> findById(Long id);

    @Modifying
    @Query("DELETE FROM ConferenceEntity c WHERE c.id = :id")
    void delete(@Param("id") Long id);
    
}
