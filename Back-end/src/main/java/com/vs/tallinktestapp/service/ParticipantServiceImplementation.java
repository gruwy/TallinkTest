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
public class ParticipantServiceImplementation implements ParticipantService {
    @Autowired
    private ParticipantRepository participantRepository;

    @Autowired
    private ParticipantMapper participantMapper;

    @Override
    public Page<ParticipantDataTransferObject> findParticipant(Pageable pageable) {
        return this.participantRepository.findAll(pageable).map(this.participantMapper::toDTO);
    }

    @Override
    public Optional<ParticipantDataTransferObject> getParticipant(Long id) {
        return this.participantRepository.findById(id).map(this.participantMapper::toDTO);
    }

    @Override
    public void saveParticipant(ParticipantDataTransferObject participantDTO) {
        ParticipantEntity participantEntity = this.participantMapper.toEntity(participantDTO);
        this.participantRepository.saveAndFlush(participantEntity);
    }

    @Override
    public void deleteParticipant(Long id) {
        this.participantRepository.delete(id);
    }
}
