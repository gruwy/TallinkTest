package com.vs.tallinktestapp.map;

import com.vs.tallinktestapp.transfer.*;
import com.vs.tallinktestapp.entity.*;

import org.mapstruct.*;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ParticipantMapper {
    
	ParticipantDataTransferObject toDTO(ParticipantEntity participant);

    ParticipantEntity toEntity(ParticipantDataTransferObject participantDTO);

    void mapToEntity(ParticipantDataTransferObject participantDTO, @MappingTarget ParticipantEntity participant);
}
