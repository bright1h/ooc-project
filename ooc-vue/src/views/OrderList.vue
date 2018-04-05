<template>
  <div class="order-list p-2 rounded"
  style="
    background-color: #ffffff;">
    <div class="container">
      <div class="row border-bottom py-1">
        <h1 class="text-dark ">Customer Order</h1>
      </div>

      <div class="row" v-if="customerorder.length===0">
        <span>There is no order right now</span>
      </div>
     
      <div class="row my-4"
          v-bind:key="data.id" 
          v-for="data in customerorder"
          v-else>
        <div class="col">
          <div id="accordion">
            <div class="card"  >
              <div class="card-header alert-info" v-bind:id="'heading'+data.id">
                <h6 class="row mb-0 font-weight-bold" data-toggle="collapse" v-bind:data-target="'#co'+data.id" aria-expanded="true" v-bind:aria-controls="'co'+data.id">
                  <div class="col-sm-3 m-auto">
                    <span class="">OrderID # {{data.id}}</span>
                  </div>
                  <div class="col-sm-3 m-auto">
                    <span>
                      {{data.customer.firstName}}
                    </span>
                  </div>
                  <div class="col-sm-3">
                    {{data.date}}
                  </div>
                  <div class="col-sm-3 mx-auto">
                    <select v-model="data.status">
                      <option disabled value="">{{data.status}}</option>
                      <option value="In queue"  >In Queue</option>
                      <option value="Preparing">Preparing</option>
                      <option value="Done">Done</option>
                    </select>
                    <span>Selected: {{ selected }}</span>
                  </div>
                </h6>
              </div>
            </div>
          </div>
        </div>
        <!-- collapse -->
        <div v-bind:id="'co'+data.id" class="collapse show" v-bind:aria-labelledby="'heading'+data.id" data-parent="#accordion">
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
</template>


<script>

  import {mapMutations} from 'vuex'


  export default {
    name: 'OrderList',

    data() {
      return {
        customerorder: []
      }
    },
    mounted() {
      this.$http.get('api/customerorder').then(response => {this.customerorder = response.data});
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
