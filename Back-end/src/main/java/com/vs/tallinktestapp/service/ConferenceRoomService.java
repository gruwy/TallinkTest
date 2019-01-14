package com.vs.tallinktestapp.service;

import com.vs.tallinktestapp.transfer.*;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ConferenceRoomService {
	
    // Initializing
	Page<ConferenceRoomDataTransferObject> findRooms(Pageable pageable);

    Optional<ConferenceRoomDataTransferObject> getRoom(Long id);

    void saveRoom(ConferenceRoomDataTransferObject roomDTO);

    void deleteRoom(Long id);

    Page<ConferenceDataTransferObject> findAllConferences(Long id, Pageable pageable);

    Optional<ConferenceDataTransferObject> getConference(Long conferenceId, Long roomId);
}
