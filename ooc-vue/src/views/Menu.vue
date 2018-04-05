<template>
  <div class="menu p-2 rounded"
  style="
    background-color: #ffffff;">
    <div class="container">

      <div class="row border-bottom py-1">
        <div class="col-sm-3">
          
         <h1 class="text-dark ">Menu</h1>
        </div>
        <div class="col">
           <nav class="nav nav-tabs ">
            <a data-toggle="tab" class="nav-link col active" href="#appetizer">Appetizer</a>
            <a data-toggle="tab" class="nav-link col" href="#dessert">Dessert</a>
            <a data-toggle="tab" class="nav-link col" href="#coffee">Coffee</a>
            <a data-toggle="tab" class="nav-link col" href="#non_coffee">Non Coffee</a>
            <a data-toggle="tab" class="nav-link col" href="#main_dish">Main Dish</a>
              <!-- <button class="btn btn-primary mr-5">Add Menu</button> -->
          </nav>
        </div>
      </div>


      <div class="row" >
        <div class="col">
          
          <div class="tab-content">

            <div class="row border-bottom py-2 mx-auto">
              <div class="col-5 border-right">
                <th>Name</th>
              </div>
              <div class="col-2 border-right">
                <th>Price</th>
              </div>
              <div class="col-3 border-right">
                <th>Image</th>
              </div>
              <div class="col-2">
                <button class="btn btn-sm btn-success"><i class="fa fa-plus"></i> </button>
              </div>
            </div>

            <div id="appetizer" class="tab-pane fade show active">
                <div class="row py-1" v-bind:key="index" v-for="(data, index) in appetizer">
                  <div class="col-5">
                    <td>{{data.name}}</td>
                  </div>
                  <div class="col-2">

                    <td>{{data.price}} ฿</td>
                  </div>
                  <div class="col-3">
                    <td v-if="data.image">{{data.image}}</td>
                    <td><i class="fa fa-minus"></i> </td>
                  </div>
                  <div class="col-2  mx-auto">
                  
                    <td><button class="btn btn-sm btn-primary">Edit</button></td>
                  </div>
                </div>
            </div>

            <div id="dessert" class="tab-pane fade">
                <div class="row py-1" v-bind:key="index" v-for="(data, index) in dessert">
                  <div class="col-5">
                    <td>{{data.name}}</td>
                  </div>
                  <div class="col-2">

                    <td>{{data.price}} ฿</td>
                  </div>
                  <div class="col-3">
                    <td v-if="data.image">{{data.image}}</td>
                    <td><i class="fa fa-minus"></i> </td>
                  </div>
                  <div class="col-2 mx-auto">
                  
                    <td><button class="btn btn-sm btn-primary">Edit</button></td>
                  </div>
                </div>
            </div>

            <div id="coffee" class="tab-pane fade">
                <div class="row py-1" v-bind:key="index" v-for="(data, index) in coffee">
                  <div class="col-5">
                    <td>{{data.name}}</td>
                  </div>
                  <div class="col-2">

                    <td>{{data.price}} ฿</td>
                  </div>
                  <div class="col-3">
                    <td v-if="data.image">{{data.image}}</td>
                    <td><i class="fa fa-minus"></i> </td>
                  </div>
                  <div class="col-2  mx-auto">
              
                    <td><button class="btn btn-sm btn-primary">Edit</button></td>
                  </div>
                </div>
            </div>

            <div id="non_coffee" class="tab-pane fade">
                <div class="row py-1" v-bind:key="index" v-for="(data, index) in non_coffee">
                  <div class="col-5">
                    <td>{{data.name}}</td>
                  </div>
                  <div class="col-2">

                    <td>{{data.price}} ฿</td>
                  </div>
                  <div class="col-3">
                    <td v-if="data.image">{{data.image}}</td>
                    <td><i class="fa fa-minus"></i> </td>
                  </div>
                  <div class="col-2  mx-auto">
                  
                    <td><button class="btn btn-sm btn-primary">Edit</button></td>
                  </div>
                </div>
            </div>

            <div id="main_dish" class="tab-pane fade">
                <div class="row py-1" v-bind:key="index" v-for="(data, index) in main_dish">
                  <div class="col-5">
                    <td>{{data.name}}</td>
                  </div>
                  <div class="col-2">

                    <td>{{data.price}}</td>
                  </div>
                  <div class="col-3">
                    <td v-if="data.image">{{data.image}}</td>
                    <td><i class="fa fa-minus"></i> </td>
                  </div>
                  <div class="col-2  mx-auto">
                  
                    <td><button class="btn btn-sm btn-primary">Edit</button></td>
                  </div>
                </div>
            </div>
            
          </div>

        </div>
      </div>
        
    </div>
  </div>
</template>

<script>
  import {AXIOS} from "../http-common";

  export default {
    name: "Menu",
    data() {
      return {
        appetizer: [],
        dessert: [],
        coffee: [],
        non_coffee: [],
        main_dish: []
      }
    },
    mounted() {
      AXIOS.get('api/appetizer')
        .then(response => {
          this.appetizer = response.data
        });
      AXIOS.get('api/dessert')
        .then(response => {
          this.dessert = response.data
        });
      AXIOS.get('api/coffee')
        .then(response => {
          this.coffee = response.data
        });
      AXIOS.get('api/non_coffee')
        .then(response => {
          this.non_coffee = response.data
        });
      AXIOS.get('api/main_dish')
        .then(response => {
          this.main_dish = response.data
        });
    }
  }
</script>

<style scoped>
  .tab-content{
    overflow-y:auto;
    overflow-x: hidden;
    max-height: 400px;
  }
</style>
