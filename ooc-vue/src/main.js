import Vue from 'vue'
import App from './App.vue'
import router from './router'
import 'bootstrap/dist/css/bootstrap.css';
<<<<<<< HEAD
import 'jquery/dist/jquery'
import 'popper.js/dist/popper'
import 'bootstrap/dist/js/bootstrap';

=======
import 'bootstrap-vue/dist/bootstrap-vue.css'
import 'jquery/dist/jquery'
import 'popper.js/dist/popper'
import 'bootstrap/dist/js/bootstrap';
import VeeValidate from 'vee-validate';
import BootstrapVue from 'bootstrap-vue'
import Popover from 'vue-js-popover'
import {store}from './store';
import VuejsDialog from "vuejs-dialog"

Vue.use(VuejsDialog)
// Vue.use(BootstrapVue);
Vue.use(VeeValidate);
>>>>>>> origin/register
Vue.config.productionTip = false;

new Vue({
  router,
<<<<<<< HEAD
=======
  store,
>>>>>>> origin/register
  render: h => h(App)
}).$mount('#app');
