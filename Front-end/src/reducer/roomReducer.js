const roomReducerDefaultState = {
    all_rooms: [],
    current_room: {
        roomName: '',
        roomSeats: 0,
        conferences: [],
        roomLocation: ''
    }
};

export default function roomReducer(state = roomReducerDefaultState, {type, ...action}) {
    switch (type) {

        case 'GET_ROOMS':
            return {...state, all_rooms: action.result.data.content};

        case 'GET_ROOM':
            return {...state, current_room: action.result.data};

        case 'ADD_ROOM':
            state.all_rooms.push(action.payload);
            return {...state};

        case 'ADD_CONFERENCE':
            state.current_room.conferences.push(action.payload);
            return {...state};

        case 'DELETE_ROOM':
            const newRooms = state.all_rooms.filter(element => {
                return element.id !== action.id;});
            return {...state, all_rooms: newRooms};

        case 'DELETE_CONFERENCE':
            const newConferences = state.current_room.conferences.filter(element => {
                return element.id !== action.id;});
            return {...state, current_room: {...state.current_room, conferences: newConferences}};

        default:
            return state;
    }
}