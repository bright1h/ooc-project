<template>

  <div class="header">
    <nav class="navbar navbar-expand-md bg-bab-header navbar-dark">

      <div class="container">
        <!-- Brand -->
<<<<<<< HEAD
=======
        
>>>>>>> origin/register
        <a class="navbar-brand py-1" href="#">
          Brew
          <img src="../assets/logo.png" alt="Logo" class="rounded-circle" style="width:40px;">
          Bev
        </a>
<<<<<<< HEAD

=======
        
               
>>>>>>> origin/register
        <!-- Toggler/collapsibe Button -->
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
          <span class="navbar-toggler-icon"></span>
        </button>

        <!-- Navbar links -->
<<<<<<< HEAD
        <div class="collapse navbar-collapse" id="collapsibleNavbar">
          <ul class="navbar-nav mr-auto">
            <li class="nav-item">
              <a class="nav-link text-light" href="/">Home</a>
            </li>
            <li class="nav-item">
              <router-link class="nav-link text-light" to="/appetizer">Appetizer</router-link>
            </li>
            <li class="nav-item">
              <router-link class="nav-link text-light" to="/dessert">Dessert</router-link>
            </li>

            <li class="nav-item">
              <router-link class="nav-link text-light" to="/drink">Drink</router-link>
            </li>

            <li class="nav-item">
              <router-link class="nav-link text-light" to="/main_dish">Main Dish</router-link>
            </li>
          </ul>

          <ul class="navbar-nav font-weight-bold">
            <li class="nav-item ">
              <a class="nav-link text-light text-light" data-toggle="modal" data-target="#myLogin">Login</a>
            </li>
            <li class="nav-item ">
              <a class="nav-link text-light text-light" data-toggle="modal" data-target="#myRegister">Register</a>
            </li>
          </ul>
        </div>
      </div>
    </nav>

    <div class="modal fade" id="myRegister">
      <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content">

          <!-- Modal Header -->
          <div class="modal-header">
            <h4 class="modal-title">Register</h4>
            <button type="button" class="close" data-dismiss="modal">&times;</button>
          </div>

          <!-- Modal body -->
          <div class="modal-body">
            <Register/>
          </div>

          <!-- Modal footer -->
          <div class="modal-footer">

          </div>
        </div>
      </div>
    </div>

    <div class="modal fade" id="myLogin">
      <div class="modal-dialog modal-md modal-dialog-centered">
        <div class="modal-content">

          <!-- Modal Header -->
          <div class="modal-header">
            <h4 class="modal-title">Login</h4>
            <button type="button" class="close" data-dismiss="modal">&times;</button>
          </div>

          <!-- Modal body -->
          <div class="modal-body">
            <Login/>
          </div>

          <!-- Modal footer -->
          <div class="modal-footer">

          </div>
        </div>
      </div>
    </div>

=======
        <div class="collapse navbar-collapse flex-row-reverse" id="collapsibleNavbar">

          <ul class="navbar-nav font-weight-bold ml-auto">  
            <li class="nav-item " v-if="!isLogin">
              <Login/>
            </li>
            <li class="nav-item " v-if="!isLogin">
              <Register/>
            </li>
            <!-- User -->
            <li class="nav-item dropdown" v-if="isUser ">
              <a class="nav-link dropdown-toggle text-light " href="#" id="navbardrop" data-toggle="dropdown">
                <!-- Change to {{User}} after done  login -->
                User
              </a>
              <div class="dropdown-menu">
                <a class="dropdown-item" href="#">Profile</a>
                <a class="dropdown-item" href="#">Logout</a>
              </div>
            </li>
            <li class="nav-item dropdown" v-if="isAdmin">
              <a class="nav-link dropdown-toggle text-light " href="#" id="navbardrop" data-toggle="dropdown">
                <!-- Change to {{User}} after done  login -->
                Admin
              </a>
              <div class="dropdown-menu">
                <a class="dropdown-item" href="#">Store</a>
                <a class="dropdown-item" href="#">Logout</a>
              </div>
            </li>
            <Cart/>
            
          </ul>

          <ul class="navbar-nav">
            <li class="nav-item px-1">
              <a class="nav-link text-light" href="/">Home</a>
            </li>
            <li class="nav-item px-1">
              <router-link class="nav-link text-light" to="/appetizer">Appetizer</router-link>
            </li>
            <li class="nav-item px-1">
              <router-link class="nav-link text-light" to="/dessert">Dessert</router-link>
            </li>

            <li class="nav-item px-1">
              <router-link class="nav-link text-light" to="/drink">Drink</router-link>
            </li>

            <li class="nav-item px-2">
              <router-link class="nav-link text-light" to="/main_dish">Main Dish</router-link>
            </li>
          </ul>  
          
        </div>

      </div>
    </nav>
>>>>>>> origin/register
  </div>
</template>

<script>

  import Login from "./Login";
  import Register from "./Register";
<<<<<<< HEAD

  export default {
    name: 'Header',
    components: {Register, Login}
=======
  import Cart from "./Cart";

  export default {
    name: 'Header',
    components: {Register, Login, Cart},
    data(){
      return {
        isAdmin : 0,
        isUser : 1,
        isLogin : 1,        
     }
    },
   
>>>>>>> origin/register
  }
</script>

<style scoped>

  .header {
    top: 0;
    width: 100%;

  }

  .bg-bab-header {
    background-color: #13254f;
<<<<<<< HEAD

=======
>>>>>>> origin/register
  }

</style>
