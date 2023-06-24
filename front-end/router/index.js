import Vue from 'vue'
import Router from 'vue-router'
import login from '@/components/Login'
import Layout from '@/components/Layout'
import main from '@/views/main'
import room1 from '@/views/room1'
import room2 from '@/views/room2'
import room3 from '@/views/room3'
import room4 from '@/views/room4'
import room5 from '@/views/room5'
import room6 from '@/views/room6'
import room7 from '@/views/room7'
import room8 from '@/views/room8'
import room9 from '@/views/room9'

Vue.use(Router)

export default new Router({
  mode:'history',
  routes: [
    {
      path: '/login',
      component: login,
    },
    {
      path:'/main',
      component:Layout,
      children:[
        {
          path:'/main',
          component:main,
        },
        {
          path:'/room1',
          component:room1
        },
        {
          path:'/room2',
          component:room2
        },
        {
          path:'/room3',
          component:room3
        },
        {
          path:'/room4',
          component:room4
        },
        {
          path:'/room5',
          component:room5
        },
        {
          path:'/room6',
          component:room6
        },
        {
          path:'/room7',
          component:room7
        },
        {
          path:'/room8',
          component:room8
        },
        {
          path:'/room9',
          component:room9
        },
      ]
    }
  ]
})
