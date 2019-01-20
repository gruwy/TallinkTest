import axios from 'axios';

// Rooms
export function getAllRooms() {
    return axios.get('/api/public/room/')
        .catch(error =>{console.log(error);});}

export function addRoom(payload) {
    return axios.post('/api/public/room', {...payload,})
        .catch(error => {console.log(error)});}

export function getRoomById(roomId) {
    return axios.get('/api/public/room/' + roomId)
        .catch(error => {console.log(error);});}

export function deleteRoomById(roomId) {
    return axios.delete('/api/public/room/' + roomId)
        .catch(error => {console.log(error);});}

// Conference
export function addConference(roomId, payload) {
    return axios.post('/api/public/room/' + roomId + '/conferences/', {...payload,})
        .catch(error => {console.log(error);});}

export function getConferenceById(roomId, conferenceId) {
    return axios.get('/api/public/room/' + roomId + '/conferences/' + conferenceId)
        .catch(error => {console.log(error)});}

export function deleteConferenceById(roomId, conferenceId) {
    return axios.delete('/api/public/room/' + roomId + '/conferences/' + conferenceId)
        .catch(error => {console.log(error)});}

// Participant
export function addParticipant(conferenceId, payload) {
    return axios.post('/api/public/participant/conference/' + conferenceId, {...payload,})
        .catch(error => {console.log(error);});}

export function deleteParticipantById(participantId) {
    return axios.delete('/api/public/participant/' + participantId)
        .catch(error => {console.log(error);});}