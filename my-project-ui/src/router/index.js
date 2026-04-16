import Vue from 'vue'
import VueRouter from 'vue-router'
import Login from '../views/LoginPage.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    component: Login
  }
]

export default new VueRouter({
  mode: 'history',
  routes
})