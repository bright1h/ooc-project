<template>
  <!-- <div class="order-list p-2 rounded"
  style="
    background-color: #ffffff;">
    <div class="container">
      <div class="row border-bottom py-1">
        <div class="col-sm-4">

          <h1 class="text-dark ">Order History</h1>
        </div>
        <div class="col-sm m-auto"> -->
          <!-- use result.filter in list -->
          <!-- <form class="form-inline my-3 my-lg-0 float-right">
            <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
          </form>
        </div>
      </div>
      <div class="row my-4">
        <div class="col">
          <div id="accordion"> -->
            <!-- add this later v-bind:key="index" v-for="(order,index) in orderlist" -->
              <!-- <div class="card"  >
                <div class="card-header alert-success" id="headingOne"> -->
                  <!-- Change collapse one to other name otherwise it's not gonna toggle -->
                  <!-- <h6 class="row mb-0 font-weight-bold" data-toggle="collapse" data-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
                    
                    <div class="col-sm-4 m-auto">
                    
                      <span class="">OrderID # 1</span>
                    
                    </div>
                    <div class="col-sm-4 m-auto">
                      <span>  
                        By FirstName, LastName
                      </span>
                    
                    </div>
                    <div class="col-sm-4 m-auto">
                      xx/xx/xxxx
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
                    <ul> -->
                      <!-- <li>{{data.specialRequest}}</li> -->
                      <!-- <li>test</li>
                    </ul>
                    <div class="alert alert-danger text-right">
                      <span class="font-weight-bold"> Price : xx</span>
                    </div>
                  </div>

                </div>
              </div>
              
            </div>
          </div>
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
  </div> -->
  <div class="div">
    
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
      this.$http.get('api/orderhistory').then(response => {this.history = response.data})
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
