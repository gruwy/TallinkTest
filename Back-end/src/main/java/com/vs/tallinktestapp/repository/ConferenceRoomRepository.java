package com.vs.tallinktestapp.repository;

import com.vs.tallinktestapp.entity.*;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ConferenceRoomRepository extends JpaRepository<ConferenceRoomEntity, Long> {
    
	Optional<ConferenceRoomEntity> findById(Long id);

    @Modifying
    @Query("DELETE FROM ConferenceRoomEntity c WHERE c.id = :id")
    void delete(@Param("id") Long id);
    
    @Query("SELECT s FROM ConferenceRoomEntity cr INNER JOIN cr.conferences s WHERE cr.id IN :roomId AND s.id = :conferenceId")
    Optional<ConferenceEntity> findConferenceByConferenceIdAndRoomId(@Param("roomId") Long roomId, @Param("conferenceId") Long conferenceId);
    
    @Query("SELECT s FROM ConferenceRoomEntity p INNER JOIN p.conferences s WHERE p.id IN :roomId")
    Page<ConferenceEntity> findAllConferencesByRoomId(@Param("roomId") Long roomId, Pageable pageable);
 
}
