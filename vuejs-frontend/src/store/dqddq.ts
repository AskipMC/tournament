import Vuex from "vuex";

export default new Vuex.Store({
    
    state: {
        pseudo : "",
        connected : true,
    },

    mutations : {

        setConnected(state){
            state.connected = true;
        },

        setDisconnected(state){
            state.connected = false;
        },

        setPseudo(state, new_pseudo){
            state.pseudo = new_pseudo;
        },

        deletePseudo(state){
            state.pseudo = "";
        }
    }
})