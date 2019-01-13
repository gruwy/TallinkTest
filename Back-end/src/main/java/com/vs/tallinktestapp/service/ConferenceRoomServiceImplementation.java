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
public class ConferenceRoomServiceImplementation implements ConferenceRoomService {
	
    @Autowired
    private ConferenceRoomRepository conferenceRoomRepository;

    @Autowired
    private ConferenceRoomMapper conferenceRoomMapper;

    @Autowired
    private ConferenceMapper conferenceMapper;

    @Override
    public Page<ConferenceRoomDataTransferObject> findRooms(Pageable pageable) {
        return this.conferenceRoomRepository.findAll(pageable).map(conferenceRoomMapper::toDTO);
    }

    @Override
    public Optional<ConferenceRoomDataTransferObject> getRoom(Long id) {
        return this.conferenceRoomRepository.findById(id).map(this.conferenceRoomMapper::toDTO);
    }

    @Override
    public Page<ConferenceDataTransferObject> findAllConferences(Long id, Pageable pageable){
        return this.conferenceRoomRepository.findAllConferencesByRoomId(id, pageable).map(this.conferenceMapper::toDTO);
    }

    @Override
    public Optional<ConferenceDataTransferObject> getConference(Long roomId, Long conferenceId) {
        return this.conferenceRoomRepository.findConferenceByConferenceIdAndRoomId(roomId, conferenceId).map(this.conferenceMapper::toDTO);
    }

    @Override
    public void saveRoom(ConferenceRoomDataTransferObject roomDTO) {
        ConferenceRoomEntity conferenceRoomEntity = this.conferenceRoomMapper.toEntity(roomDTO);
        this.conferenceRoomRepository.saveAndFlush(conferenceRoomEntity);
    }

    @Override
    public void deleteRoom(Long id) {
        this.conferenceRoomRepository.delete(id);
    }
}
