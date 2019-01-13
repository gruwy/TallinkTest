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
@ComponentScan(basePackages = {"com.vs.tallinktestapp.*"})
@CrossOrigin
@EnableJpaRepositories("com.vs.tallinktestapp.repository")
public class BackEndApplication {
	
	@Autowired
    private ConferenceRoomService conferenceRoomService;

    public static void main(String[] args) {
        SpringApplication.run(BackEndApplication.class, args);
    }
    
    @PostConstruct
    public void init() throws Exception {
        List<ParticipantDataTransferObject> participantDTOS = Arrays.asList(
                new ParticipantDataTransferObject("Name 1", new Date()),
                new ParticipantDataTransferObject("Name 2", new Date()),
                new ParticipantDataTransferObject("Name 3", new Date()),
                new ParticipantDataTransferObject("Name 4", new Date()),
                new ParticipantDataTransferObject("Name 5", new Date()),
                new ParticipantDataTransferObject("Name 6", new Date()),
                new ParticipantDataTransferObject("Name 7", new Date()),
                new ParticipantDataTransferObject("Name 8", new Date()),
                new ParticipantDataTransferObject("Name 9", new Date()),
                new ParticipantDataTransferObject("Name 10", new Date()));

        ConferenceRoomDataTransferObject conferenceRoomDTO1 = new ConferenceRoomDataTransferObject("Test room", "Some location 1", 124);

        conferenceRoomDTO1.setConferences(Arrays.asList(
                new ConferenceDataTransferObject("Test conference 1", new Date(), Arrays.asList(participantDTOS.get(0), participantDTOS.get(2), participantDTOS.get(9))),
                new ConferenceDataTransferObject("Test conference 2", new Date(), Arrays.asList(participantDTOS.get(1), participantDTOS.get(3), participantDTOS.get(8))),
                new ConferenceDataTransferObject("Test conference 3", new Date(), Arrays.asList(participantDTOS.get(3), participantDTOS.get(4), participantDTOS.get(7))),
                new ConferenceDataTransferObject("Test conference 4", new Date(), participantDTOS)));


        ConferenceRoomDataTransferObject conferenceRoomDTO2 = new ConferenceRoomDataTransferObject("Baltic room", "Some location 2", 124);
        conferenceRoomDTO2.setConferences(Arrays.asList(
                new ConferenceDataTransferObject("Baltic conference 1", new Date()),
                new ConferenceDataTransferObject("Baltic conference 2", new Date()),
                new ConferenceDataTransferObject("Baltic conference 3", new Date()),
                new ConferenceDataTransferObject("Baltic conference 4", new Date())));
        conferenceRoomService.saveRoom(conferenceRoomDTO1);
        conferenceRoomService.saveRoom(conferenceRoomDTO2);
    }
}
    

