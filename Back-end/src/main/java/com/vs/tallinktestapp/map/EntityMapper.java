package com.vs.tallinktestapp.map;

import com.vs.tallinktestapp.entity.*;
import com.vs.tallinktestapp.repository.*;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EntityMapper {
    
	// Initializing
	@Autowired
    private ConferenceRoomRepository conferenceRoomRepository;

    // Reference method
	public ConferenceRoomEntity toReference(long id) {
        Optional<ConferenceRoomEntity> conference_room = this.conferenceRoomRepository.findById(id);
        if (conference_room.isPresent()) {
        	return conference_room.get();
        } else { return null; }
    }

    public long toReference(ConferenceRoomEntity entity) {
        return entity != null ? entity.getId() : null;
    }
}
