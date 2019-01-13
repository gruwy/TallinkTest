package com.vs.tallinktestapp.controller;

import com.vs.tallinktestapp.transfer.*;
import com.vs.tallinktestapp.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/public/room")
public class ConferenceAppController {
    @Autowired
    private ConferenceRoomService conferenceRoomService;

    @Autowired
    private ConferenceService conferenceService;

    @SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/{roomId}/conferences/{conferenceId}", method = RequestMethod.GET)
    public ResponseEntity<ConferenceDataTransferObject> getConference(@PathVariable Long roomId, @PathVariable Long conferenceId) {
        return this.conferenceRoomService.getConference(roomId, conferenceId)
                .map(ResponseEntity::ok)
                .orElseGet(() -> new ResponseEntity(HttpStatus.NOT_FOUND));
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/{roomId}", method = RequestMethod.GET)
    public ResponseEntity<ConferenceRoomDataTransferObject> getRoom(@PathVariable Long roomId)
    {
        return this.conferenceRoomService.getRoom(roomId)
                .map(ResponseEntity::ok)
                .orElseGet(() -> new ResponseEntity(HttpStatus.NOT_FOUND));
    }
    @RequestMapping(value = "/{roomId}/conferences", method = RequestMethod.GET)
    public ResponseEntity<Page<ConferenceDataTransferObject>> getAllConferences(@PathVariable Long roomId, Pageable pageable) {
        Page<ConferenceDataTransferObject> page = this.conferenceRoomService.findAllConferences(roomId, pageable);
        return new ResponseEntity<>(page, HttpStatus.OK);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<Page<ConferenceRoomDataTransferObject>> getRooms(Pageable pageable) {
        Page<ConferenceRoomDataTransferObject> page = this.conferenceRoomService.findRooms(pageable);
        return new ResponseEntity<>(page, HttpStatus.OK);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public void addRoom(@RequestBody ConferenceRoomDataTransferObject conferenceRoomDTO){
        this.conferenceRoomService.saveRoom(conferenceRoomDTO);
    }

    @RequestMapping(value = "/{roomId}/conferences/", method = RequestMethod.POST)
    public void addConference(@RequestBody ConferenceDataTransferObject conferenceDTO, @PathVariable Long roomId){
        if (conferenceDTO.getRoomId().equals(roomId)){
            this.conferenceService.saveConference(conferenceDTO);
        }
    }

    @RequestMapping(value = "/{roomId}", method = RequestMethod.DELETE)
    public void removeRoom(@PathVariable Long roomId){
        Optional<ConferenceRoomDataTransferObject> conferenceRoomEntity = this.conferenceRoomService.getRoom(roomId);
        if (conferenceRoomEntity.isPresent()) {
            for (ConferenceDataTransferObject conferenceDTO : conferenceRoomEntity.get().getConferences()) {
                this.conferenceService.deleteConference(conferenceDTO.getId());
            }
            this.conferenceRoomService.deleteRoom(roomId);
        }
    }

    @RequestMapping(value = "/{roomId}/conferences/{conferenceId}", method = RequestMethod.DELETE)
    public void deleteConference(@PathVariable Long roomId, @PathVariable Long conferenceId){
        this.conferenceService.deleteConference(conferenceId);
    }
}
