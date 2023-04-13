<template>
        <div>
    
            <div class="columns">
    
                <div class="column is-3">
                    
                    <b-field label="Status">
                        <b-select placeholder="Restreindre le status" v-model="filter_status">
                            <option value="TOUS" key="TOUS"> TOUS </option>
                            <option value="A VENIR" key="A VENIR"> A VENIR </option>
                            <option value="EN COURS" key="EN COURS"> EN COURS </option>
                            <option value="TERMINE" key="TERMINE"> TERMINE </option>
                        </b-select>
                    </b-field>
    
                    <b-table 
                        :data="filtered_tournois" 
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
                                    Afficher la liste des matchs
                                </div>
                            </b-tab-item>
                        </b-tabs>
                    </div>
    
                </div>
            </div>
        
        </div>
    </template>
    
    <style lang="scss">
    .informations_tournoi {
        display: flex;
    }
    .information_tournoi_statut {
        margin-left: auto;
    }
    </style>
    <script lang="ts">
    import { Component, Vue } from 'vue-property-decorator';
    import axios from "axios";      
    import { Tournament } from '@/models/Tournament';
    
    @Component({
      components: {
        
      },
    })
    export default class InscriptionView extends Vue {
    
        filter_status : string = "TOUS";

        tournaments : Tournament[] = [];
        selected : Tournament = {
            id : 0,
            admin: "",
            name : "",
            description : "",
            state : "",
            participants : [],
            matchs : [],
        }
    
        mounted(){
            this.fetchTournois();
        }
    
        fetchTournois(){

            axios.get("/Tournament/All")
                .then( response => 
                {
                    this.tournaments = response.data;
                    console.log(response.data)
                })
                .catch(e => {
                    console.log("error");
                })
        }
    
        get filtered_tournois(){
            if(this.filter_status == "TOUS") return this.tournaments;
            else return this.tournaments.filter(tournoi => tournoi.state == this.filter_status);
        }
    
    
      
    }
    </script>
    