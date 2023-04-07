<template>

  <div id="app">

    <Navbar/>
    <div class="main-container">
      <router-view/>
    </div>
    <Footer/>

  </div>

</template>
<style lang="scss">
.main-container {
    padding: 2rem;
}
</style>

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

