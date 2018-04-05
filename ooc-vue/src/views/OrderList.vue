<template>
  <div class="order-list">
    <!-- <Header/> -->
    <div class="container py-2">
      <div class="row border-bottom my-4">
        <h1 class="text-dark ">Customer Order</h1>
      </div>
      <div class="row">
        <AdminSideBar/>
        <div class="col">
          <table class="table">
            <thead>
            <tr>
              <th>ID</th>
              <th>Customer Name</th>
              <th>Date</th>
              <!-- <th>Quantity</th>
              <th>Price</th> -->
              <th>Status</th>
            </tr>
            </thead>
            <tbody>
              <tr v-bind:key="index" v-for="(data,index) in customerorder">
                <td>{{data.id}}</td>
                <td>{{data.customer.firstName}}</td>
                <td>{{data.date}}</td>
                <td>{{data.status}}</td>
              </tr>
            </tbody>
          </table>
        </div>
      </div>
    </div>
    <!-- <Footer/> -->
  </div>
</template>


<script>

  import {AXIOS} from '../http-common'
  import {mapMutations} from 'vuex'

  import AdminSideBar from '../components/AdminSideBar'
  import Header from "../components/Header";
  import Footer from "../components/Footer";

  export default {
    name: 'OrderList',
    components: {Footer, Header, AdminSideBar},

    data() {
      return {
        customerorder: []
      }
    },
    mounted() {
      AXIOS.get('api/customerorder').then(response => {this.customerorder = response.data});
    }
  }
</script>

<style scoped>

</style>
