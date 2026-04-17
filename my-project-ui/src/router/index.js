import Vue from 'vue'
import VueRouter from 'vue-router'
import Login from '../views/LoginPage.vue'
import Home from '@/views/Home.vue'

Vue.use(VueRouter)

const router=new VueRouter({
  routes:[
    {path:'/',redirect:'/login'},
    {path:'/login',component:Login},
    {path:'/home',component:Home}
  ]
})

// 路由守卫
router.beforeEach((to,from,next)=>{
  const token=localStorage.getItem('token' )
    if(to.path !=='/login' && !token){
      next('/login')
    }else{
      next()
    }
 
})

export default router

// const routes = [
//   {
//     path: '/',
//     component: Login
//   }
// ]

// export default new VueRouter({
//   mode: 'history',
//   routes
// })