<template>
  <div class="order-list p-2 rounded"
  style="
    background-color: #ffffff;">
    <!-- <div class="container">
      <div class="row border-bottom py-1">
        <h1 class="text-dark ">Order List</h1>
  <div class="order-list">
    <div class="container py-2">
      <div class="row border-bottom my-4">
        <h1 class="text-dark ">Customer Order</h1>
      </div>
      <div class="row my-4">
        <div class="col">
          <div id="accordion">
              <div class="card"  >
                <div class="card-header alert-info" id="headingOne">
                  <h6 class="row mb-0 font-weight-bold" data-toggle="collapse" data-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
                    
                    <div class="col-sm-4 m-auto">
                    
                      <span class="">OrderID # 1</span>
                    
                    </div>
                    <div class="col-sm-4 m-auto">
                      <span>  
                        By FirstName, LastName
                      </span>
                    
                    </div>
                    <div class="col-sm-4 mx-auto">
                      <div class="btn-group">
                        <button type="button" class="btn btn-info btn-sm">Status</button>
                        <button type="button" class="btn btn-info btn-sm dropdown-toggle dropdown-toggle-split" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                          <span class="sr-only">Toggle Dropdown</span>
                        </button>
                        <div class="dropdown-menu dropdown-menu-right">
                          <a class="dropdown-item " >In Queue</a>
                          <a class="dropdown-item " >Preparing</a>
                          <a class="dropdown-item " >Done</a>
                        </div>
                      </div>  
                    </div>
                    
                  </h6>
                </div>

                <div id="collapseOne" class="collapse show" aria-labelledby="headingOne" data-parent="#accordion">
                  <div class="card-body text-left">
                    <u>Order: </u>
                    <ul>
                      <li v-bind:key="index" v-for="(data,index) in order">
                        <div class="row">
                          <div class="col">
                            {{data.name}}
                          </div>
                          <div class="col">
                            {{data.quantity}}
                          </div>
                        </div>
                      </li>
                      <li>1</li>
                      <li>2</li>
                      <li>3</li>
                      <li>4</li>
                    </ul>
                    <u>Special Request: </u>
                    <ul>
                      <li>test</li>
                    </ul>
                    <div class="alert alert-danger text-right">
                      <span class="font-weight-bold"> Price : xx</span>
                    </div>
                  </div>

                </div>
              </div>
              
            </div>
          </div>
          <table class="table">
            <thead>
            <tr>
              <th>ID</th>
              <th>Customer Name</th>
              <th>Date</th>
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
    </div> -->
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
