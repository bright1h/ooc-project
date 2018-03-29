<template>
  <div class="menu content">
    <Header/>
    <div class="container py-2">
      <div class="row border-bottom py-2">
        <h1 class="text-dark ">Menu</h1>
      </div>
      <div class="row my-4">
        <AdminSideBar/>
        <div class="col">
          <nav class="nav nav-tabs">
            <a data-toggle="tab" class="nav-link active" href="#appetizer">Appetizer</a>
            <a data-toggle="tab" class="nav-link" href="#dessert">Dessert</a>
            <a data-toggle="tab" class="nav-link" href="#coffee">Coffee</a>
            <a data-toggle="tab" class="nav-link" href="#non_coffee">Non Coffee</a>
            <a data-toggle="tab" class="nav-link mr-auto" href="#main_dish">Main Dish</a>
            <button class="btn btn-primary mr-5">Add Menu</button>
          </nav>
          <div class="tab-content">
            <div id="appetizer" class="tab-pane fade show active">
              <table class="table">
                <thead>
                <tr>
                  <th>Name</th>
                  <th>Price</th>
                  <th>Menu Type</th>
                  <th>Image</th>
                </tr>
                </thead>
                <tbody>
                <tr v-bind:key="index" v-for="(data, index) in appetizer">
                  <td>{{data.name}}</td>
                  <td>{{data.price}}</td>
                  <td>Appetizer</td>
                  <td>null</td>
                  <td><button class="btn btn-primary">Edit</button></td>
                </tr>
                </tbody>
              </table>
            </div>
            <div id="dessert" class="tab-pane fade">
              <table class="table">
                <thead>
                <tr>
                  <th>Name</th>
                  <th>Price</th>
                  <th>Menu Type</th>
                  <th>Image</th>
                </tr>
                </thead>
                <tbody>
                <tr v-bind:key="index" v-for="(data, index) in dessert">
                  <td>{{data.name}}</td>
                  <td>{{data.price}}</td>
                  <td>Dessert</td>
                  <td>null</td>
                  <td><button class="btn btn-primary">Edit</button></td>
                </tr>
                </tbody>
              </table>
            </div>
            <div id="coffee" class="tab-pane fade">
              <table class="table">
                <thead>
                <tr>
                  <th>Name</th>
                  <th>Price</th>
                  <th>Menu Type</th>
                  <th>Image</th>
                </tr>
                </thead>
                <tbody>
                <tr v-bind:key="index" v-for="(data, index) in coffee">
                  <td>{{data.name}}</td>
                  <td>{{data.price}}</td>
                  <td>Coffee</td>
                  <td>null</td>
                  <td><button class="btn btn-primary">Edit</button></td>
                </tr>
                </tbody>
              </table>
            </div>
            <div id="non_coffee" class="tab-pane fade">
              <table class="table">
                <thead>
                <tr>
                  <th>Name</th>
                  <th>Price</th>
                  <th>Menu Type</th>
                  <th>Image</th>
                </tr>
                </thead>
                <tbody>
                <tr v-bind:key="index" v-for="(data, index) in non_coffee">
                  <td>{{data.name}}</td>
                  <td>{{data.price}}</td>
                  <td>Non Coffee</td>
                  <td>null</td>
                  <td><button class="btn btn-primary">Edit</button></td>
                </tr>
                </tbody>
              </table>
            </div>
            <div id="main_dish" class="tab-pane fade">
              <table class="table">
                <thead>
                <tr>
                  <th>Name</th>
                  <th>Price</th>
                  <th>Menu Type</th>
                  <th>Image</th>
                </tr>
                </thead>
                <tbody>
                <tr v-bind:key="index" v-for="(data, index) in main_dish">
                  <td>{{data.name}}</td>
                  <td>{{data.price}}</td>
                  <td>Main Dish</td>
                  <td>null</td>
                  <td><button class="btn btn-primary">Edit</button></td>
                </tr>
                </tbody>
              </table>
            </div>
          </div>
        </div>
      </div>
    </div>
    <Footer/>
  </div>
</template>

<script>
  import Header from "../components/Header";
  import AdminSideBar from "../components/AdminSideBar";
  import Footer from "../components/Footer";

  export default {
    name: "Menu",
    components: {Footer, AdminSideBar, Header},
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
      this.$http.get('api/appetizer')
        .then(response => {
          this.appetizer = response.data
        });
      this.$http.get('api/dessert')
        .then(response => {
          this.dessert = response.data
        });
      this.$http.get('api/coffee')
        .then(response => {
          this.coffee = response.data
        });
      this.$http.get('api/non_coffee')
        .then(response => {
          this.non_coffee = response.data
        });
      this.$http.get('api/main_dish')
        .then(response => {
          this.main_dish = response.data
        });
    }
  }
</script>

<style scoped>
  table {
    width: 100%;
  }

  thead, tbody, tr, td, th { display: block; }

  tr:after {
    content: ' ';
    display: block;
    visibility: hidden;
    clear: both;
  }

  tbody {
    height: 300px;
    overflow-y: auto;
  }

  tbody td, thead th {
    width: 19.2%;
    float: left;
  }
</style>
