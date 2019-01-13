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
@RequestMapping(value = "/api/public/participant")
public class ParticipantAppController {
    
	@Autowired
    private ParticipantService participantService;

    @Autowired
    private ConferenceService conferenceService;

    @SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<ParticipantDataTransferObject> getParticipant(@PathVariable Long id) {
        return this.participantService.getParticipant(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> new ResponseEntity(HttpStatus.NOT_FOUND));
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<Page<ParticipantDataTransferObject>> getAllPParticipant(Pageable pageable){
        Page<ParticipantDataTransferObject> page = this.participantService.findParticipant(pageable);
        return new ResponseEntity<>(page, HttpStatus.OK);
    }

    @RequestMapping(value = "/conference/{conferenceId}", method = RequestMethod.POST)
    public void createParticipant(@RequestBody ParticipantDataTransferObject participantDTO, @PathVariable Long conferenceId) {
        Optional<ConferenceDataTransferObject> conferenceDTO = this.conferenceService.getConference(conferenceId);
        if (conferenceDTO.isPresent()){
            conferenceDTO.get().getParticipants().add(participantDTO);
            this.conferenceService.saveConference(conferenceDTO.get());
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteParticipant(@PathVariable Long id) {
        this.participantService.deleteParticipant(id);
    }
}
