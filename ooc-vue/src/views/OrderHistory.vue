<template>
  <div class="order-list p-2 rounded"
      style="background-color: #ffffff;">
    <div class="container">
      <div class="row border-bottom py-1">
        <h1 class="text-dark ">Order History</h1>
      </div>

      <div class="row my-4">
        <div class="col-6 mt-2">
          <label for="inputDate" class="sr-only">Date</label>
          <input type="date" class="form-control" id="inputDate" size="35" :max="today" v-model="date">
        </div>
        <div class="col-2">
          <button type="submit" class="btn btn-primary mb-2 pull-right my-2" v-on:click="updateTable">Search</button>
        
        </div>
      </div>

      <div class="row" v-if="history.length===0">
        <span>There is no order history exist</span>
      </div>
     
      <div class="row my-4"
          v-bind:key="data.id" 
          v-for="(data) in history"
          v-else>
        <div class="col">
          <div id="accordion">
            <div class="card"  >
              <div class="card-header alert-success" v-bind:id="'heading'+data.id">
                <h6 class="row mb-0 font-weight-bold" data-toggle="collapse" v-bind:data-target="'#oh' + data.id" aria-expanded="true" v-bind:aria-controls="'oh'+data.id">
                  <div class="col-sm-4 m-auto">
                    <span>OrderID # {{data.id}}</span>
                  </div>
                  <div class="col-sm-4 m-auto">
                    <span>
                      {{data.customer.firstName}}, 
                      {{data.customer.lastName}}
                    
                    </span>
                  </div>
                  <div class="col-sm-4">
                    {{data.date}}
                  </div>
                </h6>
              </div>
            </div>
          </div>

        <!-- collapse -->
        <div v-bind:id="'oh'+data.id" class="collapse show" v-bind:aria-labelledby="'heading'+data.id" data-parent="#accordion">
          <div class="card-body text-left">
            <u>Order:</u>
            <ul>
              <li v-bind:key="index" v-for="(o,index) in order">
                <div class="row">
                  <div class="col">
                    {{o.name}}
                  </div>
                  <div class="col">
                    {{o.quantity}}
                  </div>
                </div>
              </li>
            </ul>
            <u>Special Request: </u>
            <ul>
              <li>{{data.special_request}}</li>
            </ul>
            <div class="alert alert-danger text-right">
              <span class="font-weight-bold"> Price : {{data.total_price}}</span>
            </div>
          </div>
        </div>
        </div>
      </div>
      
    </div>
  </div>
</template>

<script>

  import {mapMutations} from 'vuex'

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
    data() {
      return {
        history : [],
        date: '',
        today: ''
      }
    },
    mounted() {
      this.$http.get('api/orderhistory').then(response => {
        console.log(response.data);
        this.history = response.data})
    },
    methods: {
      updateTable: function() {
        console.log(this.date);
        this.$http.get('api/orderhistory/search/'+this.date).then(response => {this.history = response.data})
      }
    },
    created() {
      this.today = getdate();
    }
  }
</script>

<style scoped>
  .card-body{

    background-color: #e9ebee ;
  }

  .alert{
    font-size: 15px;

  }
</style>
