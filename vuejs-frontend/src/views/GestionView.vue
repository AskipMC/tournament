<template>
    <div class="gestion">
        <p class="gestion_title">Création:</p>
        <p class="gestion_title">Mes tournois:</p>
        <div class="gestion_list box">
            <b-field grouped>
                <router-link to="gestion_tournament_link">Mon Tournoi</router-link>
            </b-field>
        </div>
        <div class="gestion_list box">
            <b-field grouped>
                <router-link to="gestion_tournament_link2">Mon Tournoi 2</router-link>
            </b-field>
        </div>
    </div>
</template>

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
