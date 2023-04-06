<template>
    <div class="tournament">
        <p class="tournament_list_title">Liste des tournois:</p>
        <div class="tournament_list box">
            <b-field grouped>
                <router-link to="tournament_link">Nom Tournoi</router-link>
            </b-field>
        </div>
        <div class="tournament_list box">
            <b-field grouped>
                <router-link to="tournament_link2">Nom Tournoi 2</router-link>
            </b-field>
        </div>
    </div>
    
</template>

<style>

.tournament_list{
    width : 15em;
    margin: 3em;
    margin-top: 1.5em;
}
.tournament_list_title{
    width:15em;
    font-weight:bold;
    font-size: 1.5em;
    margin-left: 2em;
    margin-top: 2em;
}

</style>
