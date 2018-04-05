<template>
  <div class="order-history">
    <!-- <Header/> -->
    <div class="container py-2">
      <div class="row border-bottom py-2">
        <h1 class="text-dark ">Order History</h1>
      </div>
      <div class="row my-4">
        <AdminSideBar/>
        <div class="col">
          <div class="row-1">
            <label for="inputDate" class="sr-only">Date</label>
            <input type="date" class="form-control" id="inputDate" size="35" :max="today" v-model="date">
            <button type="submit" class="btn btn-primary mb-2 pull-right my-2" v-on:click="updateTable">Search</button>
          </div>
          <table class="table">
            <thead>
            <tr>
              <th>ID</th>
              <th>Customer Name</th>
              <th>Date</th>
            </tr>
            </thead>
            <tbody>
              <tr v-bind:key="index" v-for="(data,index) in history">
                <td>{{data.id}}</td>
                <td>{{data.customer.firstName}}</td>
                <td>{{data.date}}</td>
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

  function getdate() {
    let date = new Date();
    let dd = date.getDate();
    let mm = date.getMonth() + 1; //January is 0!
    const yyyy = date.getFullYear();

    if(dd<10) {
      dd = '0'+dd
    }

    if(mm<10) {
      mm = '0'+mm
    }

    date = yyyy + '-' + mm + '-' + dd;
    return date;
  }

  export default {
    name: 'OrderHistory',
    components: {Footer, Header, AdminSideBar},
    data() {
      return {
        history : [],
        date: '',
        today: ''
      }
    },
    mounted() {
      AXIOS.get('api/orderhistory').then(response => {this.history = response.data})
    },
    methods: {
      updateTable: function() {
        console.log(this.date);
        AXIOS.get('api/orderhistory/search/'+this.date).then(response => {this.history = response.data})
      }
    },
    created() {
      this.today = getdate();
    }
  }
</script>

<style scoped>

</style>
