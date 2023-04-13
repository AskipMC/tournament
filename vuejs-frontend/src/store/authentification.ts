import Vue from "vue";
import Vuex from "vuex";

Vue.use(Vuex);

export default new Vuex.Store({
    state: {
        pseudo: "",
    },
    getters : {
        isConnected : (state) => {
            return state.pseudo == "" ? false : true;
        },
        getPseudo : (state) => {
            return state.pseudo;
        }
    },
    mutations : {
        setPseudo : (state, new_pseudo) => {
            state.pseudo = new_pseudo;
        }
    },

})


