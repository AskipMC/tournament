<template>
    <b-navbar class="navbar is-dark">
      <template #start>
        <b-navbar-item tag="router-link" :to="{ path: '/' }">Tournois</b-navbar-item>
        <b-navbar-item tag="router-link" :to="{ path: '/gestion' }">Gestion</b-navbar-item>
      </template>
      <template #end>
        <b-navbar-item tag="router-link" :to="{ path: '/connexion' }">Connexion</b-navbar-item>
      </template>
    </b-navbar>
</template>