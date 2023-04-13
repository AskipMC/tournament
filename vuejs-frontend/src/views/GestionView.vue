<template>
    <div>
        <div v-if="!isConnected">
            <span>
                Vous devez être connecté pour avoir accès à vos tournois
            </span>
        </div>

        <div v-else>

            <b-modal v-model="modalCreationTournoi">
                <div class="modal-card">

                <header class="modal-card-head">
                    Créer d'un tournoi
                </header>

                <section class="modal-card-body">
                    <b-tabs>

                        <b-tab-item label="Général">
                            <b-field label="Nom">
                            <b-input v-model="createTournoi.name"></b-input>
                            </b-field>

                            <b-field label="Description">
                            <b-input v-model="createTournoi.description" type="textarea"></b-input>
                            </b-field>
                        </b-tab-item>

                        <b-tab-item label="Participants">
                            <b-field label="Ajouter des participants">
                                <b-taginput
                                    v-model="createTournoi.participants"
                                    ellipsis
                                    icon="label"
                                    placeholder="Ajouter"
                                    aria-close-label="Enlever ce participant">
                                </b-taginput>
                            </b-field>
                        </b-tab-item>

                        <b-tab-item label="Gestion">
                            <b-field label="Prochainement" disabled>
                               
                            </b-field>
                        </b-tab-item>
                    </b-tabs>

                    

                </section>

                <footer class="modal-card-foot">
                    <div>
                    <b-button @click="validerTournoi()" type="is-success"> Valider </b-button>
                    <b-button @click="annulerTournoi()" type="is-danger"> Annuler </b-button>
                    </div>
                </footer>
            </div>
        </b-modal>


            <div class="columns">
            
                <div class="column is-2">
                    <b-button @click="modalCreationTournoi = !modalCreationTournoi" type="is-primary"> Créer un tournoi</b-button>
                    <BR/><BR/>
                    <b-table 
                        :data="tournaments" 
                        :selected.sync="selected" 
                        focusable 
                        :hoverable="true"
                        :bordered="true"
                        :pagination-simple="true">

                        <b-table-column
                            field = "Tournois"
                            label = "Tournois"
                            v-slot="props">
                            {{ props.row.name }}
                        </b-table-column>
                    </b-table>
                </div>
                
                <div class="column">
                      <div v-if="selected.id != 0">
                        <b-tabs>
                            <b-tab-item label="Informations">
                                <div class="box">
                                    <div class="informations_tournoi">
                                        <div>
                                        <b-field label="Nom">
                                            {{ selected.name }}
                                        </b-field>
                                        <b-field label="Créateur">
                                            {{  selected.admin }}
                                        </b-field>
                                        <b-field label="Modérateurs">
                                            Prochainement
                                        </b-field>
                                        <b-field label="Description">
                                            {{ selected.description }}
                                        </b-field>
                                        <b-button @click="generateNextMatch()" type="is-primary">Générer les prochains matchs</b-button>
                                    </div>
                                    <div class="information_tournoi_statut">
                                        <b-taglist attached>
                                            <b-tag size="is-medium" type="is-dark" >STATUT</b-tag> 
                                            <b-tag size="is-medium" :type="selected.state == 'TERMINE' ? 'is-success' : selected.state == 'EN COURS' ? 'is-warning' : 'is-light'">{{ selected.state }}</b-tag>
                                        </b-taglist>
                                    </div>
                                    </div>
                                    
                                </div>
                            </b-tab-item>
                            <b-tab-item label="Matchs">
                                <div v-if="selected.matchs.length==0">
                                    <span>Il n'y a pas encore de matchs !</span>
                                </div>
                                <div v-else>
                                    <div v-for="match in selected.matchs" class="box">
                                        <b-taglist attached>
                                            <b-tag size="is-medium" type="is-light">Match</b-tag>
                                            <b-tag size="is-medium" :type="selected.state == 'TERMINE' ? 'is-success' : selected.state == 'EN COURS' ? 'is-warning' : 'is-light'">{{ selected.state }}</b-tag>
                                        </b-taglist>
                                        <span>Match</span><BR/>
                                        <b-field :label="match.participant1">
                                            <b-input type="number" v-model="match.result1"></b-input>
                                        </b-field>
                                        <b-field :label="match.participant2">
                                            <b-input type="number" v-model="match.result2"></b-input>
                                        </b-field>
                                    </div>
                                    <b-button @click="enregistrer()" type="is-primary">Enregistrer</b-button>
                                </div>
                            </b-tab-item>
                        </b-tabs>
                      </div>
                </div>

            </div>
        </div>
        
    </div>
</template>





<script lang="ts">
import { Component, Vue } from 'vue-property-decorator';
import axios from "axios";
import authentification from "../store/authentification";
import { Tournament } from '@/models/Tournament';
 
@Component({
  components: {
    
  },
})
export default class GestionView extends Vue {

    isConnected = authentification.getters.isConnected;
    pseudo = authentification.getters.getPseudo;

    modelTournoi : Tournament = {
        id : 0,
        admin: "",
        name : "",
        description : "",
        state : "",
        participants : [],
        matchs : []
    }

    createTournoi = {
        admin : null,
        name : "",
        description : "",
        participants : []
    }
    
    tournaments : Tournament[] = [];
    selected : Tournament = this.modelTournoi;
    
    modalCreationTournoi : boolean = false;

    mounted(){
        if(this.isConnected) this.loadGestion()
    }

    loadGestion(){
        axios.get("/Tournament/Personal/"+this.pseudo)
            .then( response => 
            {
                this.tournaments = response.data;
            })
            .catch(e => {
                console.log("error");
            })
    }

    generateNextMatch(){
        let max = 0;
        let max_level = this.selected.matchs.map(match => match.level);
        for(let i=0; i<max_level.length;i++){
            if(max_level[i] > max) max = max_level[i];
        }

        let level_matchs = this.selected.matchs.filter(match => match.level==max);
        if(level_matchs.every(match => match.result1 != null) && level_matchs.every(match => match.result2 != null)){
            axios.get("/Tournament/GenerateMatchs/"+this.selected.id+"/"+max++)
            .then( response => 
            {
                this.loadGestion();
            })
            .catch(e => {
                console.log("error");
            })
        }
        else {
            this.toast("is-danger","Les matchs n'ont pas tous des scores !");
        }

        
    }

    toast(type:string, text:string){
        this.$buefy.toast.open(
            {
                message : text,
                type: type
            });
    }

    validerTournoi(){
        this.createTournoi.admin = this.pseudo;
        axios.post("/Tournament/Create", this.createTournoi)
        .then( response => {
            this.modalCreationTournoi = false;
            this.toast("is-success","Création du tournoi effectuée !");
            this.loadGestion();
        })
        .catch(e => {
                console.log("error");
            })
    }

    enregistrer(){
        axios.post("/Tournament/SaveMatch", this.selected)
            .then( response => 
            {
                this.toast("is-success", "Bien sauvegardé !");
            })
            .catch(e => {
                console.log("error");
            })
    }

    annulerTournoi(){
        this.modalCreationTournoi = false;
        this.createTournoi.name = "";
        this.createTournoi.description = "";
        this.createTournoi.participants = [];
    }
}
</script>













<style>

.gestion_list{
    width : 15em;
    margin: 3em;
    margin-top: 1.5em;
}
.gestion_title{
    width:15em;
    font-weight:bold;
    font-size: 1.5em;
    margin-left: 2em;
    margin-top: 2em;
}

</style>
