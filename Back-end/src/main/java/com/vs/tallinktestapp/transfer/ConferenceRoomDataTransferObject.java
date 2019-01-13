package com.vs.tallinktestapp.transfer;

import static com.vs.tallinktestapp.values.Constants.MAX_SEATS;

import java.util.List;
import javax.validation.constraints.Size;

public class ConferenceRoomDataTransferObject extends ModelDataTransferObject{
	
	// Initializing
	public String roomName;
	@Size(min = 1, max = MAX_SEATS) private int roomSeats;
	private String location;
    private List<ConferenceDataTransferObject> conferences;

    // Setters and getters
    public List<ConferenceDataTransferObject> getConferences() {
        return this.conferences;
    }

    public void setConferences(List<ConferenceDataTransferObject> conferences) {
        this.conferences = conferences;
    }

    public String getRoomName() {
        return this.roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public int getSeats() {
        return this.roomSeats;
    }

    public void setSeats(int roomSeats) {
        this.roomSeats = roomSeats;
    }

    public String getLocation() {
        return this.location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    // Conference Room Data Transfer Object constructors
    public ConferenceRoomDataTransferObject(){}

    public ConferenceRoomDataTransferObject(String roomName, String roomLocation, int roomSeats){
        this.setRoomName(roomName);
        this.setLocation(roomLocation);
        this.setSeats(roomSeats);
    }

    public ConferenceRoomDataTransferObject(String roomName, String roomLocation, int roomSeats, List<ConferenceDataTransferObject> conferences){
        this.setRoomName(roomName);
        this.setLocation(roomLocation);
        this.setSeats(roomSeats);
        this.setConferences(conferences);
    }
}
