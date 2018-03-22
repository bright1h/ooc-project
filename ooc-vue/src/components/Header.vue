<template>

  <div class="header">
    <nav class="navbar navbar-expand-md bg-bab-header navbar-dark">

      <div class="container">
        <!-- Brand -->
        <a class="navbar-brand py-1" href="#">
          Brew
          <img src="../assets/logo.png" alt="Logo" class="rounded-circle" style="width:40px;">
          Bev
        </a>

        <!-- Toggler/collapsibe Button -->
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
          <span class="navbar-toggler-icon"></span>
        </button>

        <!-- Navbar links -->
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
              <Login/>
            </li>
            <li class="nav-item ">
              <Register/>
            </li>
          </ul>
        </div>
      </div>
    </nav>


  </div>
</template>

<script>

  import Login from "./Login";
  import Register from "./Register";

  export default {
    name: 'Header',
    components: {Register, Login}
  }
</script>

<style scoped>

  .header {
    top: 0;
    width: 100%;

  }

  .bg-bab-header {
    background-color: #13254f;

  }

</style>
