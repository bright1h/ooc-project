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
import Register from './components/Register'
import Profile from './views/Profile'
import Checkout from './views/CheckOut'
import Menu from './views/Menu'


Vue.use(Router);

export default new Router({
  mode: 'history',
  routes: [
    {
      path: '/admin_home',
      name: 'admin_home',
      component: AdminHome
    },
    {
      path: '/',
      name: 'home',
      component: Home
    },
    {
      path: '/customer_order',
      name: 'customer_order',
      component: OrderList
    },
    {
      path: '/order_history',
      name: 'order_history',
      component: OrderHistory
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
      path: '/register',
      name: 'register',
      component: Register
    },
    {
      path: '/profile',
      name: 'profile',
      component: Profile
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
    }
  ]
})
