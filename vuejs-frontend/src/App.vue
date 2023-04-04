<template>

  <div id="app">

    <Navbar/>
    <router-view/>
    <Footer/>

  </div>

</template>

<script lang="ts">
import { Component, Vue } from 'vue-property-decorator';
import Navbar from '@/components/Navbar.vue'; 
import Footer from '@/components/Footer.vue'; 

@Component({
  components: {
    Navbar,Footer
  },
})
export default class App extends Vue {}

/*
db_tournoi
wQ9AcsOk1my3STvI






*/
</script>

