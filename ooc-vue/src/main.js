import Vue from 'vue'
import App from './App.vue'
import router from './router'
import axios from './vue-axios/axios'
import './vue-axios'
import 'bootstrap/dist/css/bootstrap.css';
import 'bootstrap-vue/dist/bootstrap-vue.css'
import 'jquery/dist/jquery'
import 'popper.js/dist/popper'
import 'bootstrap/dist/js/bootstrap';
import VeeValidate from 'vee-validate';
import {store} from './store';
import VuejsDialog from "vuejs-dialog"

Vue.use(VuejsDialog);
// Vue.use(BootstrapVue);
Vue.use(VeeValidate);
Vue.config.productionTip = false;

new Vue({
  router,
  axios,
  store,
  render: h => h(App)
}).$mount('#app');
