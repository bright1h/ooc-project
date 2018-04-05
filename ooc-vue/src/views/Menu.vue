<template>
  <div class="menu content">
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
            <button class="btn btn-primary mr-5" data-toggle="modal" data-target="#addModal">Add Menu</button>
          </nav>

          <div class="modal fade" id="addModal" tabindex="-1" role="dialog" aria-labelledby="addModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
              <div class="modal-content">
                <div class="modal-header">
                  <h5 class="modal-title">Add new menu</h5>
                  <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                  </button>
                </div>
                <div class="modal-body">
                  <form>
                    <div class="form-group">
                      <label for="add-modal-name" class="col-form-label">Name:</label>
                      <input type="text" class="form-control" id="add-modal-name" v-model="add_menu_name">
                    </div>
                    <div class="form-group">
                      <label for="add-modal-price" class="col-form-label">Price:</label>
                      <input type="text" class="form-control" id="add-modal-price" v-model="add_menu_price">
                    </div>
                    <div v-if="menu_type_checkbox === 'checkbox-coffee' || menu_type_checkbox === 'checkbox-non-coffee'" class="form-group">
                      <div class="form-check form-check-inline">
                        <label class="form-check-label">
                          <input class="form-check-input" type="checkbox" v-model="add_menu_is_hot"> isHot
                        </label>
                      </div>
                      <div class="form-check form-check-inline">
                        <label class="form-check-label">
                          <input class="form-check-input" type="checkbox" v-model="add_menu_is_blend"> isBlend
                        </label>
                      </div>
                    </div>
                    <div class="form-group">
                      <div class="form-check form-check-inline">
                        <label class="form-check-label">
                          <input class="form-check-input" type="radio" v-model="menu_type_checkbox" value="checkbox-appetizer"> Appetizer
                        </label>
                      </div>
                      <div class="form-check form-check-inline">
                        <label class="form-check-label">
                          <input class="form-check-input" type="radio" v-model="menu_type_checkbox" value="checkbox-dessert"> Dessert
                        </label>
                      </div>
                      <div class="form-check form-check-inline">
                        <label class="form-check-label">
                          <input class="form-check-input" type="radio" v-model="menu_type_checkbox" value="checkbox-coffee"> Coffee
                        </label>
                      </div>
                      <div class="form-check form-check-inline">
                        <label class="form-check-label">
                          <input class="form-check-input" type="radio" v-model="menu_type_checkbox" value="checkbox-non-coffee"> Non Coffee
                        </label>
                      </div>
                      <div class="form-check form-check-inline">
                        <label class="form-check-label">
                          <input class="form-check-input" type="radio" v-model="menu_type_checkbox" value="checkbox-main-dish"> Main Dish
                        </label>
                      </div>
                    </div>
                  </form>
                </div>
                <div class="modal-footer">
                  <button class="btn btn-secondary" data-dismiss="modal">Close</button>
                  <button class="btn btn-primary" v-on:click="addMenu">Add Menu</button>
                </div>
              </div>
            </div>
          </div>


          <div class="modal fade" id="updateModal" tabindex="-1" role="dialog" aria-labelledby="updateModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
              <div class="modal-content">
                <div class="modal-header">
                  <h5 class="modal-title" id="exampleModalLabel">Update menu</h5>
                  <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                  </button>
                </div>
                <div class="modal-body">
                  <form>
                    <div class="form-group">
                      <label for="update-modal-name" class="col-form-label">Name:</label>
                      <input type="text" class="form-control" id="update-modal-name" v-model="update_menu_name">
                    </div>
                    <div class="form-group">
                      <label for="update-modal-price" class="col-form-label">Price:</label>
                      <input type="text" class="form-control" id="update-modal-price" v-model="update_menu_price">
                    </div>
                    <div v-if="menu_type_checkbox === 'checkbox-coffee' || menu_type_checkbox === 'checkbox-non-coffee'" class="form-group">
                      <div class="form-check form-check-inline">
                        <label class="form-check-label">
                          <input class="form-check-input" type="checkbox" v-model="update_menu_is_hot"> isHot
                        </label>
                      </div>
                      <div class="form-check form-check-inline">
                        <label class="form-check-label">
                          <input class="form-check-input" type="checkbox" v-model="update_menu_is_blend"> isBlend
                        </label>
                      </div>
                    </div>
                    <div class="form-group">
                      <div class="form-check form-check-inline">
                        <label class="form-check-label">
                          <input class="form-check-input" type="radio" v-model="menu_type_checkbox" value="checkbox-appetizer"> Appetizer
                        </label>
                      </div>
                      <div class="form-check form-check-inline">
                        <label class="form-check-label">
                          <input class="form-check-input" type="radio" v-model="menu_type_checkbox" value="checkbox-dessert"> Dessert
                        </label>
                      </div>
                      <div class="form-check form-check-inline">
                        <label class="form-check-label">
                          <input class="form-check-input" type="radio" v-model="menu_type_checkbox" value="checkbox-coffee"> Coffee
                        </label>
                      </div>
                      <div class="form-check form-check-inline">
                        <label class="form-check-label">
                          <input class="form-check-input" type="radio" v-model="menu_type_checkbox" value="checkbox-non-coffee"> Non Coffee
                        </label>
                      </div>
                      <div class="form-check form-check-inline">
                        <label class="form-check-label">
                          <input class="form-check-input" type="radio" v-model="menu_type_checkbox" value="checkbox-main-dish"> Main Dish
                        </label>
                      </div>
                    </div>
                  </form>
                </div>
                <div class="modal-footer">
                  <button class="btn btn-secondary" data-dismiss="modal">Close</button>
                  <button class="btn btn-primary" v-on:click="updateMenu">Update Menu</button>
                </div>
              </div>
            </div>
          </div>

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
                  <td>{{data.imageName}}</td>
                  <td><button class="btn btn-primary" v-on:click="editMenu(data)">Edit</button></td>
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
                  <td>{{data.imageName}}</td>
                  <td><button class="btn btn-primary" v-on:click="editMenu(data)">Edit</button></td>
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
                  <td>{{data.imageName}}</td>
                  <td><button class="btn btn-primary" v-on:click="editMenu(data)">Edit</button></td>
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
                  <td>{{data.imageName}}</td>
                  <td><button class="btn btn-primary" v-on:click="editMenu(data)">Edit</button></td>
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
                  <td>{{data.imageName}}</td>
                  <td><button class="btn btn-primary" v-on:click="editMenu(data)">Edit</button></td>
                </tr>
                </tbody>
              </table>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
  import AdminSideBar from "../components/AdminSideBar";
  import {AXIOS} from "../http-common";

  global.jQuery = require('jquery');
  var $ = global.jQuery;
  window.$ = $;

  export default {
    name: "Menu",
    components: {AdminSideBar},
    data() {
      return {
        appetizer: [],
        dessert: [],
        coffee: [],
        non_coffee: [],
        main_dish: [],
        menu_type_checkbox: '',
        add_menu_name: '',
        add_menu_price: 0,
        add_menu_is_hot: false,
        add_menu_is_blend: false,
        update_menu_id: 0,
        update_menu_name: '',
        update_menu_price: 0,
        update_menu_is_hot: false,
        update_menu_is_blend: false
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
    },
    methods: {
      updateMenu: function() {
        if (this.menu_type_checkbox === 'checkbox-appetizer') {
          AXIOS.put('api/appetizer/update', {
            id: this.update_menu_id,
            name: this.update_menu_name,
            price: this.update_menu_price
          })
            .then(function (response) {
              console.log(response);
            })
            .catch(function (error) {
              console.log(error);
            });
        } else if (this.menu_type_checkbox === 'checkbox-dessert') {
          AXIOS.put('api/dessert/update', {
            id: this.update_menu_id,
            name: this.update_menu_name,
            price: this.update_menu_price
          })
            .then(function (response) {
              console.log(response);
            })
            .catch(function (error) {
              console.log(error);
            });
        } else if (this.menu_type_checkbox === 'checkbox-coffee') {
          AXIOS.put('api/coffee/update', {
            id: this.update_menu_id,
            name: this.update_menu_name,
            price: this.update_menu_price,
            menuType: {
              blend: this.update_menu_is_blend,
              hot: this.update_menu_is_hot
            }
          })
            .then(function (response) {
              console.log(response);
            })
            .catch(function (error) {
              console.log(error);
            });
        } else if (this.menu_type_checkbox === 'checkbox-non-coffee') {
          AXIOS.put('api/non_coffee/update', {
            id: this.update_menu_id,
            name: this.update_menu_name,
            price: this.update_menu_price,
            menuType: {
              blend: this.update_menu_is_blend,
              hot: this.update_menu_is_hot
            }
          })
            .then(function (response) {
              console.log(response);
            })
            .catch(function (error) {
              console.log(error);
            });
        } else if (this.menu_type_checkbox === 'checkbox-main-dish') {
          AXIOS.put('api/main_dish/update', {
            id: this.update_menu_id,
            name: this.update_menu_name,
            price: this.update_menu_price
          })
            .then(function (response) {
              console.log(response);
            })
            .catch(function (error) {
              console.log(error);
            });
        }
      },
      editMenu: function(data) {
        $("#updateModal").modal("toggle");
        this.update_menu_id = data.id;
        this.update_menu_name = data.name;
        this.update_menu_price = data.price;
        if (data.menuType.dtype === 'Appetizer') {
          this.menu_type_checkbox = 'checkbox-appetizer';
        } else if (data.menuType.dtype === 'Dessert') {
          this.menu_type_checkbox = 'checkbox-dessert';
        } else if (data.menuType.dtype === 'Coffee') {
          this.menu_type_checkbox = 'checkbox-coffee';
          this.update_menu_is_blend = data.menuType.blend;
          this.update_menu_is_hot = data.menuType.hot;
        } else if (data.menuType.dtype === 'NonCoffee') {
          this.menu_type_checkbox = 'checkbox-non-coffee';
          this.update_menu_is_blend = data.menuType.blend;
          this.update_menu_is_hot = data.menuType.hot;
        } else if (data.menuType.dtype === 'MainDish') {
          this.menu_type_checkbox = 'checkbox-main-dish';
        }
        console.log(this.menu_type_checkbox);
      },
      addMenu: function() {
        if (this.menu_type_checkbox === 'checkbox-appetizer') {
          AXIOS.post('api/appetizer/add', {
            name: this.add_menu_name,
            price: this.add_menu_price
          })
            .then(function (response) {
              console.log(response);
            })
            .catch(function (error) {
              console.log(error);
            });
        } else if (this.menu_type_checkbox === 'checkbox-dessert') {
          AXIOS.post('api/dessert/add', {
            name: this.add_menu_name,
            price: this.add_menu_price
          })
            .then(function (response) {
              console.log(response);
            })
            .catch(function (error) {
              console.log(error);
            });
        } else if (this.menu_type_checkbox === 'checkbox-coffee') {
          AXIOS.post('api/coffee/add', {
            name: this.add_menu_name,
            price: this.add_menu_price,
            menuType: {
              blend: this.add_menu_is_blend,
              hot: this.add_menu_is_hot
            }
          })
            .then(function (response) {
              console.log(response);
            })
            .catch(function (error) {
              console.log(error);
            });
        } else if (this.menu_type_checkbox === 'checkbox-non-coffee') {
          AXIOS.post('api/non_coffee/add', {
            name: this.add_menu_name,
            price: this.add_menu_price,
            menuType: {
              blend: this.add_menu_is_blend,
              hot: this.add_menu_is_hot
            }
          })
            .then(function (response) {
              console.log(response);
            })
            .catch(function (error) {
              console.log(error);
            });
        } else if (this.menu_type_checkbox === 'checkbox-main-dish') {
          AXIOS.post('api/main_dish/add', {
            name: this.add_menu_name,
            price: this.add_menu_price
          })
            .then(function (response) {
              console.log(response);
            })
            .catch(function (error) {
              console.log(error);
            });
        }
      }
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
