const conferenceReducerDefaultState = {
    conferenceName: '',
    conferenceDateAndTime: '',
    participants: [],
};


export default function conferenceReducer(state = conferenceReducerDefaultState, {type, ...action}) {
    switch (type) {

        case 'ADD_PARTICIPANT':
            state.participants.push(action.data);
            return {...state};

        case 'DELETE_PARTICIPANT':
            const newParticipants = state.participants.filter(element => {
                return element.id !== action.id;});
            return {...state, participants: newParticipants};

        case 'GET_CONFERENCE':
            return {
                ...state,
                conferenceName: action.result.data.conferenceName,
                conferenceDateTime: action.result.data.conferenceDateAndTime,
                participants: action.result.data.participants,};
        default:
            return state;
    }
}

