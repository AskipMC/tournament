<template>
    <div class="form_inscription">
        <div class="form_inscription_size box">
            <p class="form_inscription_title">Inscription</p><br/>
            <b-field label="Pseudo" message="Minimum 4 caractères (spéciaux non tolérés)">
                <b-input v-model="pseudo"></b-input>
            </b-field>
            <b-field label="Mot de passe" message="Minimum 8 caractères">
                <b-input v-model="password" type="password" ></b-input>
            </b-field>
            <b-button class="form_connexion_center_element is-success" @click="inscription()">S'inscrire</b-button>
        </div>
    </div>
    
</template>

<style>
.form_inscription {
    display: flex;
    justify-content: center;
}
.form_inscription_size {
    width : 25em;
    margin: 3em;
}
.form_inscription_title {
    text-align: center;
    font-weight: bold;
}
</style>

<script lang="ts">
import { Component, Vue } from 'vue-property-decorator';
import api from "axios";

@Component({
  components: {
    
  },
})
export default class InscriptionView extends Vue {

    pseudo : string = "";
    password : string = "";


    inscription(){
        //Verifier si le pseudo contient pas de caracteres spéciaux
        if(this.pseudo.length<4 || this.pseudo.includes(" ")) {
            this.toast("is-danger", "Le pseudo ne respecte pas les conditions.");
            return;
        }
        if(this.password.length<8) {
            this.toast("is-danger", "Le mot de passe ne respecte pas les conditions.")
            return;
        }
    }

    toast(type:string, text:string){
        this.$buefy.toast.open(
            {
                message : text,
                type: type
            });
    }
}
</script>
