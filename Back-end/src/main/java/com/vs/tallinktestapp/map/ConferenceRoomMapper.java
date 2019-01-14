package com.vs.tallinktestapp.map;

import com.vs.tallinktestapp.transfer.*;
import com.vs.tallinktestapp.entity.*;

import org.mapstruct.*;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, uses = ConferenceMapper.class)
public interface ConferenceRoomMapper {
    
	// Initializing methods
	ConferenceRoomDataTransferObject toDTO(ConferenceRoomEntity conferenceRoom);

    ConferenceRoomEntity toEntity(ConferenceRoomDataTransferObject conferenceRoomDTO);

    void mapToEntity(ConferenceRoomDataTransferObject conferenceRoomDTO, @MappingTarget ConferenceRoomEntity conferenceRoom);
}
