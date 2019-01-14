package com.vs.tallinktestapp;

import com.vs.tallinktestapp.service.*;
import com.vs.tallinktestapp.transfer.*;
import com.vs.tallinktestapp.BackEndApplication;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@ComponentScan(basePackages = {"com.vs.tallinktestapp"})
@CrossOrigin
public class BackEndApplication {
	
	// Initializing
	@Autowired
    private ConferenceRoomService conferenceRoomService;

    // Main method
	public static void main(String[] args) {
        SpringApplication.run(BackEndApplication.class, args);
    }
    
    // PostConstruct initialization
	@PostConstruct
    public void init() throws Exception {
        
		// Creating list of participants with they dates of birth
		List<ParticipantDataTransferObject> participantDTO = Arrays.asList(
                new ParticipantDataTransferObject("Name 1", new Date()),
                new ParticipantDataTransferObject("Name 2", new Date()),
                new ParticipantDataTransferObject("Name 3", new Date()),
                new ParticipantDataTransferObject("Name 4", new Date()),
                new ParticipantDataTransferObject("Name 5", new Date()),
                new ParticipantDataTransferObject("Name 6", new Date()),
                new ParticipantDataTransferObject("Name 7", new Date()),
                new ParticipantDataTransferObject("Name 8", new Date()),
                new ParticipantDataTransferObject("Name 9", new Date()),
                new ParticipantDataTransferObject("Name 10", new Date()),
                new ParticipantDataTransferObject("Name 11", new Date()),
                new ParticipantDataTransferObject("Name 12", new Date()),
                new ParticipantDataTransferObject("Name 13", new Date()),
                new ParticipantDataTransferObject("Name 14", new Date()),
                new ParticipantDataTransferObject("Name 15", new Date()),
                new ParticipantDataTransferObject("Name 16", new Date()),
                new ParticipantDataTransferObject("Name 17", new Date()),
                new ParticipantDataTransferObject("Name 18", new Date()),
                new ParticipantDataTransferObject("Name 19", new Date()),
                new ParticipantDataTransferObject("Name 20", new Date()));

        // Creating conference rooms with conferences in them
        ConferenceRoomDataTransferObject conferenceRoomDTO1 = new ConferenceRoomDataTransferObject("Test room 1", "Some location 1", 124);

        conferenceRoomDTO1.setConferences(Arrays.asList(
                new ConferenceDataTransferObject("Test conference 1", new Date(), Arrays.asList(participantDTO.get(0), participantDTO.get(1), participantDTO.get(2))),
                new ConferenceDataTransferObject("Test conference 2", new Date(), Arrays.asList(participantDTO.get(3), participantDTO.get(4), participantDTO.get(5))),
                new ConferenceDataTransferObject("Test conference 3", new Date(), Arrays.asList(participantDTO.get(6), participantDTO.get(7), participantDTO.get(8))),
                new ConferenceDataTransferObject("Test conference 4", new Date(), Arrays.asList(participantDTO.get(9), participantDTO.get(10), participantDTO.get(11)))));

        ConferenceRoomDataTransferObject conferenceRoomDTO2 = new ConferenceRoomDataTransferObject("Ship room", "Some location 2", 124);
        
        conferenceRoomDTO2.setConferences(Arrays.asList(
                new ConferenceDataTransferObject("Ship conference 1", new Date()),
                new ConferenceDataTransferObject("Ship conference 2", new Date()),
                new ConferenceDataTransferObject("Ship conference 3", new Date()),
                new ConferenceDataTransferObject("Ship conference 4", new Date()),
                new ConferenceDataTransferObject("Ship conference 5", new Date()),
                new ConferenceDataTransferObject("Ship conference 6", new Date()),
                new ConferenceDataTransferObject("Ship conference 7", new Date())));
        
        // Saving created rooms via service
        conferenceRoomService.saveRoom(conferenceRoomDTO1);
        conferenceRoomService.saveRoom(conferenceRoomDTO2);
    }
}    