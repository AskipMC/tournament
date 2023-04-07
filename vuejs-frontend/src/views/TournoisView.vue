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
                                        faire une requete pour chopper le nom du créateur avec son id
                                    </b-field>
                                    <b-field label="Modérateurs">
                                        pareil
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
                            Afficher la liste des matchs
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
import { Tournoi } from '@/models/Tournois';

@Component({
  components: {
    
  },
})
export default class InscriptionView extends Vue {

    tournoi : Tournoi = {
        id : 1,
        name : "tournoi1",
        description : "tournoi test",
        state : "EN COURS",
        mode : "POULE",
        adminId : 1,
        moderatorsId : [2],
        participants : ["jo","david"],
        matchs : [],
    };
    selected : Tournoi = {
        id : 0,
        name : "",
        description : "",
        state : "",
        mode : "",
        adminId : 0,
        moderatorsId : [],
        participants : [],
        matchs : [],
    };
    tournois : Tournoi[] = [];
    filter_status : string = "TOUS";

    mounted(){
        this.fetchTournois();
    }

    fetchTournois(){
        this.tournois.push(this.tournoi); //a enlever plus tard
        console.log("Get all public tournaments")
    }

    get filtered_tournois(){
        if(this.filter_status == "TOUS") return this.tournois;
        else return this.tournois.filter(tournoi => tournoi.state == this.filter_status);
    }


  
}
</script>
