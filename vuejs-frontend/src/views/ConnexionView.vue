<template>
    <div class="form_connexion">
        <div class="form_connexion_size box">
            <p class="form_inscription_title">Connexion</p><br/>
            <b-field label="Pseudo">
                <b-input v-model="pseudo"></b-input>
            </b-field>
            <b-field label="Mot de passe">
                <b-input v-model="password" type="password"></b-input>
            </b-field>
            <b-button class="form_connexion_center_element is-success" @click="connexion()">Connexion</b-button>
            <b-field grouped>
                <span>Pas inscrit ? </span> &nbsp;
                <router-link to="/inscription">Inscrivez-vous</router-link>
            </b-field>
        </div>
    </div>
    
</template>

<style>
.form_connexion {
    display: flex;
    justify-content: center;
}
.form_connexion_size {
    width : 25em;
    margin: 3em;
}
.form_connexion_center_element {
  display: flex;
  justify-content: center;
  align-items: center;
}
.form_connexion_title{
    text-align: center;
    font-weight: bold;
}
</style>

<script lang="ts">
import { Component, Vue } from 'vue-property-decorator';
import axios from "axios";

@Component({
  components: {
    
  },
})
export default class AuthView extends Vue {

    pseudo : string = "";
    password : string = "";

    connexion(){
        console.log("Valider");
        axios.get("/User/login")
            /*.then(response => {
                console.log("then")
            })
            .catch(e => {
                console.log("error")
            })*/
    }
}
</script>
