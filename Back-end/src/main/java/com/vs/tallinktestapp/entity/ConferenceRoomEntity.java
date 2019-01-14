package com.vs.tallinktestapp.entity;

import static com.vs.tallinktestapp.values.Constants.MAX_SEATS;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.Max;

@Entity(name = "ConferenceRoomEntity")
@Table(name = "room")
public class ConferenceRoomEntity {

	// Columns
	@Id
    @GeneratedValue
    @Column(name = "room_id", unique = true, nullable = false)
    private Long id;

    @Column(name = "room_name", nullable = false)
    private String roomName;

    @Column(name = "room_location", nullable = false)
    private String roomLocation;

    @Column(name = "room_seats", nullable = false)
    @Max(MAX_SEATS)
    private int roomSeats;

    // Relational database operations
    @OneToMany(mappedBy = "conferenceRoom", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<ConferenceEntity> conferences = new ArrayList<>();
    
    // Getters and setters
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoomName() {
        return this.roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getRoomLocation() {
        return this.roomLocation;
    }

    public void setLocation(String roomLocation) {
        this.roomLocation = roomLocation;
    }

    public int getSeats() {
        return this.roomSeats;
    }

    public void setSeats(int roomSeats) {
        this.roomSeats = roomSeats;
    }
    
    // Conference
    public List<ConferenceEntity> getConferences() {
        return conferences;
    }
    
    public void setConferences(List<ConferenceEntity> conferences) {
        this.conferences.clear();
        if (conferences != null) {
            for (ConferenceEntity conference : conferences){
                this.conferences.add(conference);
                conference.setConferenceRoom(this);
            }
        }
    }
    
    // Conference room entity constructors
    public ConferenceRoomEntity(){}

    public ConferenceRoomEntity(String roomName, String roomLocation, int roomSeats){
        this.setRoomName(roomName);
        this.setLocation(roomLocation);
        this.setSeats(roomSeats);
    }
    
    public ConferenceRoomEntity(String roomName, String roomLocation, int roomSeats, List<ConferenceEntity> conferences){
    	this.setRoomName(roomName);
        this.setLocation(roomLocation);
        this.setSeats(roomSeats);
        this.setConferences(conferences);
                           
    }
}
