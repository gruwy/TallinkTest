package com.vs.tallinktestapp.map;

import com.vs.tallinktestapp.transfer.*;
import com.vs.tallinktestapp.entity.*;

import org.mapstruct.*;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, uses = EntityMapper.class)
public interface ConferenceMapper {
    
	@Mapping(source="conferenceRoom", target="roomId")
    ConferenceDataTransferObject toDTO(ConferenceEntity conference);

    @InheritInverseConfiguration
    ConferenceEntity toEntity(ConferenceDataTransferObject conferenceDTO);

    void mapToEntity(ConferenceDataTransferObject conferenceDTO, @MappingTarget ConferenceEntity conference);
}
