package com.vs.tallinktestapp.service;

import com.vs.tallinktestapp.transfer.*;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ParticipantService {
    Page<ParticipantDataTransferObject> findParticipant(Pageable pageable);

    Optional<ParticipantDataTransferObject> getParticipant(Long id);

    void saveParticipant(ParticipantDataTransferObject participantDTO);

    void deleteParticipant(Long id);
}
