import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import Buefy from 'buefy'
import 'buefy/dist/buefy.css'
import axios from 'axios'

Vue.use(Buefy)

Vue.config.productionTip = false

axios.defaults.baseURL = "http://localhost:8080/Tournament/";

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
