<template>
<div class="menu p-2 rounded"
    style=" background-color: #ffffff;">
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
          </nav>
        </div>
      </div>

      <div class="row">
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
              <div class="col-2 m-auto">
                
                  <button class="btn btn-success btn-sm" data-toggle="modal" data-target="#addModal"><i class="fa fa-plus"></i></button></div>
            </div>

            <div id="appetizer" class="tab-pane fade show active">
              <div class="row py-1" v-bind:key="index" v-for="(data, index) in appetizer">
                <div class="col-5 text-left">
                  <span class="break">{{data.name}}</span>
                </div>
                <div class="col-2">
                  <span>{{data.price}} ฿</span>
                </div>
                <div class="col-3">
                  <span v-if="data.imageName" class="break">{{data.imageName}}</span>
                  <span v-else><i class="fa fa-minus"></i> </span></div>
                <div class="col-2  mx-auto">
                  <button class="btn btn-primary btn-sm" v-on:click="editMenu(data)"><i class="fa fa-cog"></i></button>
                </div>
              </div>
            </div>

            <div id="dessert" class="tab-pane fade show">
              <div class="row py-1" v-bind:key="index" v-for="(data, index) in dessert">
                <div class="col-5 text-left">
                  <span class="break">{{data.name}}</span>
                </div>
                <div class="col-2">
                  <span>{{data.price}} ฿</span>
                </div>
                <div class="col-3">
                  
                  <span v-if="data.imageName" class="break">{{data.imageName}}</span>
                  <span v-else><i class="fa fa-minus"></i> </span></div>
                <div class="col-2  mx-auto">
                  <button class="btn btn-primary btn-sm" v-on:click="editMenu(data)"><i class="fa fa-cog"></i></button>
                
                </div>
              </div>
            </div>   

            <div id="coffee" class="tab-pane fade show">
              <div class="row py-1" v-bind:key="index" v-for="(data, index) in coffee">
                <div class="col-5 text-left">
                  <span class="break">{{data.name}}</span>
                </div>
                <div class="col-2">
                  <span>{{data.price}} ฿</span>
                </div>
                <div class="col-3">
                 
                  <span v-if="data.imageName" class="break">{{data.imageName}}</span>
                  <span v-else><i class="fa fa-minus"></i> </span></div>
                <div class="col-2  mx-auto">
                  <button class="btn btn-primary btn-sm" v-on:click="editMenu(data)"><i class="fa fa-cog"></i></button>
                </div>
              </div>
            </div>   

            <div id="non_coffee" class="tab-pane fade show">
              <div class="row py-1" v-bind:key="index" v-for="(data, index) in non_coffee">
                <div class="col-5 text-left">
                  <span  class="break">{{data.name}}</span>
                </div>
                <div class="col-2">
                  <span>{{data.price}} ฿</span>
                </div>
                <div class="col-3">
                  <span v-if="data.imageName" class="break">{{data.imageName}}</span>
                  <span v-else><i class="fa fa-minus"></i> </span></div>
                <div class="col-2  mx-auto">
                  <button class="btn btn-primary btn-sm" v-on:click="editMenu(data)"><i class="fa fa-cog"></i></button>
                </div>
              </div>
            </div>   

            <div id="main_dish" class="tab-pane fade show">
              <div class="row py-1" v-bind:key="index" v-for="(data, index) in main_dish">
                <div class="col-5 text-left">
                  <span class="break">{{data.name}}</span>
                </div>
                <div class="col-2">
                  <span>{{data.price}} ฿</span>
                </div>
                <div class="col-3">
                  <span v-if="data.imageName" class="break">{{data.imageName}}</span>
                  <span v-else><i class="fa fa-minus"></i> </span>
                </div>
                <div class="col-2  mx-auto">
                  <button class="btn btn-primary btn-sm" v-on:click="editMenu(data)"><i class="fa fa-cog"></i></button>
                </div>
              </div>
            </div>    

          </div>

        </div>
      </div>

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
      
    </div>
  </div>
</template>

<script>

  global.jQuery = require('jquery');
  var $ = global.jQuery;
  window.$ = $;

  export default {
    name: "Menu",
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
    },
    methods: {
      updateMenu: function() {
        if (this.menu_type_checkbox === 'checkbox-appetizer') {
          this.$http.put('api/appetizer/update', {
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
          this.$http.put('api/dessert/update', {
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
          this.$http.put('api/coffee/update', {
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
          this.$http.put('api/non_coffee/update', {
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
          this.$http.put('api/main_dish/update', {
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
          this.$http.post('api/appetizer/add', {
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
          this.$http.post('api/dessert/add', {
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
          this.$http.post('api/coffee/add', {
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
          this.$http.post('api/non_coffee/add', {
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
          this.$http.post('api/main_dish/add', {
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
  .tab-content{
    overflow-y:auto;
    overflow-x: hidden;
    max-height: 400px;
  }
</style>
