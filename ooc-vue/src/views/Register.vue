<template>
  <div class="register">
    <!-- <Header/> -->
    <!-- <div class="container py-2"> -->
      <!-- <div class="row border-bottom py-2">
        <h1 class="text-dark ">Register</h1>
      </div> -->
      <div class="row pt-2">
        <div class="col-md mt-2 mx-3">
          <!-- <div class="border"> -->
            <form>
              <div class="form-row">
                <div class="form-group col-md-6">
                  <input type="text" class="form-control" placeholder="First name">
                </div>
                <div class="form-group col-md-6">
                  <input type="text" class="form-control" placeholder="Last name">
                </div>
              </div>
              <div class="form-row">
                <div class="form-group col-md">
                  <input type="text" class="form-control" placeholder="Phone number">
                </div>
              </div>
              <div class="form-row">
                <div class="form-group col-md">
                  <input type="email" class="form-control" placeholder="Email">
                </div>
              </div>
              <div class="form-row">
                <div class="form-group col-md">
                  <input type="password" class="form-control" placeholder="Password">
                </div>
              </div>
              <div class="form-row">
                <div class="form-group col-md">
                  <input type="password" class="form-control" placeholder="Confirm password">
                </div>
              </div>
              <div class="form-footer ">
                <button type="button" class="btn btn-primary">Register</button>
              </div>
            </form>
          <!-- </div> -->
        </div>
      </div>
    </div>
    <!-- <Footer/> -->
  <!-- </div> -->
</template>

<script>
  import Header from "../components/Header";
  import Footer from "../components/Footer";

  export default {
    name: "Register",
    components: {Footer, Header}
  };
</script>

<style scoped>
  .border {
    padding: 30px;
  }
</style>

