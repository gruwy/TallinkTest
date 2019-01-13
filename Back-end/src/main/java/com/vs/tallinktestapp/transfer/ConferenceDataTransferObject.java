package com.vs.tallinktestapp.transfer;

import java.util.Date;
import java.util.List;

public class ConferenceDataTransferObject extends ModelDataTransferObject {
    
	// Initializing
	private String conferenceName;
    private Date conferenceDateAndTime;
    private Long roomId;
    private List<ParticipantDataTransferObject> participants;

    // Getters and setters
    public String getConferenceName() {
        return this.conferenceName;
    }

    public void setConferenceName(String conferenceName) {
        this.conferenceName = conferenceName;
    }

    public Date getConferenceDateTime() {
        return this.conferenceDateAndTime;
    }

    public void setConferenceDateTime(Date conferenceDateAndTime) {
        this.conferenceDateAndTime = conferenceDateAndTime;
    }

    public List<ParticipantDataTransferObject> getParticipants() {
        return this.participants;
    }

    public void setParticipants(List<ParticipantDataTransferObject> participants) {
        this.participants = participants;
    }

    public Long getRoomId() {
        return this.roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    // Conference Data Transfer Object constructors
    public ConferenceDataTransferObject(){

    }

    public ConferenceDataTransferObject(String conferenceName, Date conferenceDateAndTime){
        this.setConferenceName(conferenceName);
        this.setConferenceDateTime(conferenceDateAndTime);
    }
    public ConferenceDataTransferObject(String conferenceName, Date conferenceDateAndTime, List<ParticipantDataTransferObject> participants){
        this.setConferenceName(conferenceName);
        this.setConferenceDateTime(conferenceDateAndTime);
        this.setParticipants(participants);
    }
}

