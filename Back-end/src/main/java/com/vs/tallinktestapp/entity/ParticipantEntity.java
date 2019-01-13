package com.vs.tallinktestapp.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity(name = "ParticipantEntity")
@Table(name = "participant")
public class ParticipantEntity {
    
	// Columns
	@Id
    @GeneratedValue
    @Column(name = "participant_id", unique = true, nullable = false)
    private Long id;

    @Column(name = "participant_name", nullable = false)
    private String participantName;

    @Column(name = "participant_dateofbirth", nullable = false)
    private Date participantDateOfBirth;
    
    // Queries
    @ManyToMany(fetch = FetchType.LAZY,mappedBy = "participants")
    private List<ConferenceEntity> conference = new ArrayList<>();
    
    // Setters and getters
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getParticipantName() {
        return participantName;
    }

    public void setParticipantName(String participantName) {
        this.participantName = participantName;
    }

    public Date getParticipantDateOfBirth() {
        return this.participantDateOfBirth;
    }

    public void setParticipantBirthDay(Date participantDateOfBirth) {
        this.participantDateOfBirth = participantDateOfBirth;
    }

    // Conference
    
    public List<ConferenceEntity> getConference() {
        return this.conference;
    }

    public void setConference(List<ConferenceEntity> conference) {
        this.conference = conference;
    }

    // Participant entity constructors
    public ParticipantEntity(){}

    public ParticipantEntity(String participantName, Date participantDateOfBirth){
        this.setParticipantName(participantName);
        this.setParticipantBirthDay(participantDateOfBirth);
    }

    public ParticipantEntity(String participantName, Date participantDateOfBirth, List<ConferenceEntity> conference){
        this.setParticipantName(participantName);
        this.setParticipantBirthDay(participantDateOfBirth);
        this.setConference(conference);
    }
}
