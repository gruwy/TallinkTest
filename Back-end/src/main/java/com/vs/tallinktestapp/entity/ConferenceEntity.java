package com.vs.tallinktestapp.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity(name = "ConferenceEntity")
@Table(name = "conference")
public class ConferenceEntity {
    
	// Columns
	@Id
    @GeneratedValue
    @Column(name = "conference_id", unique = true, nullable = false)
    private Long id;

    @Column(name = "conference_name", nullable = false)
    private String conferenceName;

    @Column(name = "conference_dateandtime", nullable = false)
    private Date conferenceDateAndTime;

    // Relational database operations
    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "conference_participant_association", joinColumns = {
    		@JoinColumn(name = "conference_id")}, 
    		inverseJoinColumns = {@JoinColumn(name = "participant_id")})    
    private List<ParticipantEntity> participants = new ArrayList<>();
    
    @ManyToOne
    @JoinColumn(name = "room_id")
    private ConferenceRoomEntity conferenceRoom;
    
    // Setters and getters
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getConferenceName() {
        return this.conferenceName;
    }

    public void setConferenceName(String conferenceName) {
        this.conferenceName = conferenceName;
    }

    public Date getConferenceDateTime() {
        return this.conferenceDateAndTime;
    }

    public void setConferenceDateTime(Date conferenceDateTime) {
        this.conferenceDateAndTime = conferenceDateTime;
    }

    // Participant
     
    public List<ParticipantEntity> getParticipants() {
        return this.participants;
    }

    public void setParticipants(List<ParticipantEntity> participants) {
        this.participants = participants;
    }

    // Conference Room
    public ConferenceRoomEntity getConferenceRoom() {
        return this.conferenceRoom;
    }

    public void setConferenceRoom(ConferenceRoomEntity conference) {
        this.conferenceRoom = conference;
    }

    // Constructors
    public ConferenceEntity(){}

    public ConferenceEntity(String conferenceName, Date conferenceDateAndTime){
        this.setConferenceName(conferenceName);
        this.setConferenceDateTime(conferenceDateAndTime);
    }

    public ConferenceEntity(String conferenceName, Date conferenceDateAndTime, List<ParticipantEntity> participants, ConferenceRoomEntity conferenceRoomEntity){
        this.setConferenceName(conferenceName);
        this.setConferenceDateTime(conferenceDateAndTime);
        this.setParticipants(participants);
        this.setConferenceRoom(conferenceRoomEntity);
    }
}
