import Vue from 'vue'
import Router from 'vue-router'
import Home from './views/Home.vue'
import AdminHome from './views/AdminHome.vue'
import OrderList from './views/OrderList.vue'
import OrderHistory from './views/OrderHistory'
import About from './views/About'
import Drink from './views/Drink'
import Dessert from './views/Dessert'
import Appetizer from './views/Appetizer'
import MainDish from './views/MainDish'
import Register from './views/Register'
import Profile from './views/Profile'

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
            path: '/order_list',
            name: 'order_list',
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
            path: '/about',
            name: 'about',
            component: About
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
        }
    ]
})
