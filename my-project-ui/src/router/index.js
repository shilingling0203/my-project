import Vue from 'vue'
import VueRouter from 'vue-router'
import Login from '../views/LoginPage.vue'

Vue.use(VueRouter)

const router = new VueRouter({
  mode: 'history',
  routes: [
    // 登录页
    {
      path: '/login',
      component: Login,
       meta: { noAuth: true }
    },
    
    // 主布局（左右布局）
    {
      path: '/home',
      component: () => import('@/views/Home.vue'),
      redirect: '/dashboard', // ✅ 默认跳转到 dashboard
      children: [
        {
          path: '/dashboard',
          component: () => import('@/views/dashboard/index.vue')
        },
        {
          path: '/sales',
          component: () => import('@/views/dashboard/index.vue')
        },
        {
          path: '/purchase',
          component: () => import('@/views/dashboard/index.vue')
        },
        {
          path: '/system/user',
          component: () => import('@/views/dashboard/index.vue')
        },
        {
          path: '/system/role',
          component: () => import('@/views/dashboard/index.vue')
        }
      ]
    }
  ]
})

// 路由守卫
router.beforeEach((to, from, next) => {
  const token = localStorage.getItem('token')

  
  // ✅ 如果是登录页，直接放行
  if (to.meta.noAuth) {
    next()
    return
  }
  
  // ✅ 非登录页需要 token
  if (!token) {
    next('/login')
  } else {
    next()
  }
})

export default router