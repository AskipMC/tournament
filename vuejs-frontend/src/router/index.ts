import Vue from 'vue'
import VueRouter, { RouteConfig } from 'vue-router'
import TournoisView from '../views/TournoisView.vue'
import GestionView from '../views/GestionView.vue'
import ConnexionView from '../views/ConnexionView.vue'
import InscriptionView from '../views/InscriptionView.vue'

Vue.use(VueRouter)

const routes: Array<RouteConfig> = [
  {
    path: '/',
    name: 'tournois',
    component: TournoisView
  },
  {
    path: '/gestion',
    name: 'gestion',
    component: GestionView
  },
  {
    path: '/connexion',
    name: 'connexion',
    component: ConnexionView
  },
  {
    path: '/inscription',
    name: 'inscription',
    component: InscriptionView
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
