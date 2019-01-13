package com.vs.tallinktestapp.service;

import com.vs.tallinktestapp.transfer.*;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;


public interface ConferenceService {
    Optional<ConferenceDataTransferObject> getConference(Long id);

    void saveConference(ConferenceDataTransferObject conferenceDTO);

    Page<ConferenceDataTransferObject> findConferences(Pageable pageable);

    void deleteConference(Long id);

}
