import Vue from 'vue'
import Router from 'vue-router'
import Home from './views/Home.vue'
import AdminHome from './views/AdminHome.vue'
import OrderList from './views/OrderList.vue'
import OrderHistory from './views/OrderHistory'
import Drink from './views/Drink'
import Dessert from './views/Dessert'
import Appetizer from './views/Appetizer'
import MainDish from './views/MainDish'
import Profile from './views/Profile'
import Checkout from './views/CheckOut'
import Menu from './views/Menu'
import { store } from './store';


Vue.use(Router);

export default new Router({
  mode: 'history',
  routes: [
    {
      path: '/admin_home',
      name: 'admin_home',
      component: AdminHome,
      // beforeEnter : (to,from,next)=>{
      //   if(store.state.user.userType==="ADMIN"){
      //     next()
      //   }
      //   else{
      //     next('/');
      //   }
      // }
      
    },
    {
      path: '/',
      name: 'home',
      component: Home
    },
    {
      path: '/appetizer',
      name: 'appetizer',
      component: Appetizer
    },
    {
      path: '/drink',
      name: 'drink',
      component: Drink
    },
    {
      path: '/dessert',
      name: 'dessert',
      component: Dessert
    },
    {
      path: '/main_dish',
      name: 'main_dish',
      component: MainDish
    },

    {
      path: '/checkout',
      name: '/checkout',
      component: Checkout
    },
    {
      path: '/menu',
      name: '/menu',
      component: Menu
    },
    {
      path: '/profile',
      name: '/profile',
      component: Profile,
      beforeEnter : (to,from,next)=>{
        if(store.state.user.userType==="USER"){
          next()
        }
        else{
          next('/');
        }
      }
    }
  ]
})
