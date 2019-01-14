package com.vs.tallinktestapp.service;

import com.vs.tallinktestapp.transfer.*;
import com.vs.tallinktestapp.map.*;
import com.vs.tallinktestapp.entity.*;
import com.vs.tallinktestapp.repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class ConferenceServiceImplementation implements ConferenceService {
    
	// Initializing
	@Autowired
    private ConferenceRepository conferenceRepository;

    @Autowired
    private ConferenceMapper conferenceMapper;

    // Methods
    @Override
    public Optional<ConferenceDataTransferObject> getConference(Long id) {
        return this.conferenceRepository.findById(id).map(this.conferenceMapper::toDTO);
    }

    @Override
    public void saveConference(ConferenceDataTransferObject conferenceDTO) {
        ConferenceEntity conferenceEntity = this.conferenceMapper.toEntity(conferenceDTO);
        this.conferenceRepository.saveAndFlush(conferenceEntity);
    }

    @Override
    public Page<ConferenceDataTransferObject> findConferences(Pageable pageable) {
        return this.conferenceRepository.findAll(pageable).map(this.conferenceMapper::toDTO);
    }

    @Override
    public void deleteConference(Long id) {
        this.conferenceRepository.delete(id);
    }

}
