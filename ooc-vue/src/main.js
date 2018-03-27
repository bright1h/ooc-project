import Vue from 'vue'
import App from './App.vue'
import router from './router'
import axios from './vue-axios/axios'
import './vue-axios'
import 'bootstrap/dist/css/bootstrap.css';
import 'jquery/dist/jquery'
import 'popper.js/dist/popper'
import 'bootstrap/dist/js/bootstrap';

Vue.config.productionTip = false;

new Vue({
  router,
  axios,
  render: h => h(App)
}).$mount('#app');
