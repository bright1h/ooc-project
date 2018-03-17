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
              <a class="nav-link text-light" href="/appetizer">Appetizer</a>
            </li>
            <li class="nav-item">
              <a class="nav-link text-light" href="/dessert">Dessert</a>
            </li>

            <li class="nav-item">
              <a class="nav-link text-light" href="/drink">Drink</a>
            </li>

            <li class="nav-item">
              <a class="nav-link text-light" href="/main_dish">Main Dish</a>
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

      </div>
</template>

<script>

  import Login from "../views/Login";
  import Register from "../views/Register";
  export default {
    name: 'Header',
    components: {Register, Login}
  }
</script>

<style scoped>

  .header {
    top :0;
    width: 100%;

  }

  .bg-bab-header {
    background-color: #13254f;

  }

</style>
