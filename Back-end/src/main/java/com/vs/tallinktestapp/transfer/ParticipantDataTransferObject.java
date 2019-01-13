package com.vs.tallinktestapp.transfer;

import java.util.Date;

public class ParticipantDataTransferObject {
	
	// Initializing
	private String participantName;
    private Date participantDateOfBirth;

    // Setters and getters
    public String getParticipantName() {
        return this.participantName;
    }

    public void setParticipantName(String participantName) {
        this.participantName = participantName;
    }

    public Date getParticipantDateOfBirth() {
        return this.participantDateOfBirth;
    }

    public void setParticipantDateOfBirth(Date participantDateOfBirth) {
        this.participantDateOfBirth = participantDateOfBirth;
    }
    
    // Participant Data Transfer Object constructors
    public ParticipantDataTransferObject(){

    }

    public ParticipantDataTransferObject(String participantName, Date participantDateOfBirth){
        this.setParticipantName(participantName);
        this.setParticipantDateOfBirth(participantDateOfBirth);
    }
}
