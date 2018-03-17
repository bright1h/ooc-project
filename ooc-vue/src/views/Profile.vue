<template>
  <div class="profile">
    <Header/>
    <div class="container py-2">
      <div class="row border-bottom py-2">
        <h1 class="text-dark ">Profile</h1>
      </div>
      <div class="row py-3">
        <div class="col-md-2"></div>
        <div class="col-md">
          <div class="border">
            <form>
              <div class="row">
                <div class="form-group col-md">
                  <label for="firstName">First Name</label>
                  <input id="firstName" type="text" class="form-control">
                </div>
                <div class="form-group col-md">
                  <label for="oldPassword">Old Password</label>
                  <input id="oldPassword" type="password" class="form-control">
                </div>
              </div>
              <div class="row">
                <div class="form-group col-md">
                  <label for="lastName">Last Name</label>
                  <input id="lastName" type="text" class="form-control">
                </div>
                <div class="form-group col-md">
                  <label for="newPassword">New Password</label>
                  <input id="newPassword" type="password" class="form-control">
                </div>
              </div>
              <div class="row">
                <div class="form-group col-md">
                  <label for="email">Email</label>
                  <input id="email" type="email" class="form-control">
                </div>
                <div class="form-group col-md">
                  <label for="confirmPassword">Confirm Password</label>
                  <input id="confirmPassword" type="text" class="form-control">
                </div>
              </div>
              <div class="row">
                <div class="form-group col-md-6">
                  <label for="mobilePhone">Mobile Phone</label>
                  <input id="mobilePhone" type="text" class="form-control">
                </div>
              </div>
              <br><br>
              <div class="form-footer">
                <button type="button" class="btn btn-primary">Save changes</button>
              </div>
            </form>
          </div>
        </div>
        <div class="col-md-2"></div>
      </div>
    </div>
    <Footer/>
  </div>
</template>

<script>
  import Header from "../components/Header";
  import Footer from "../components/Footer";

  export default {
    name: "Profile",
    components: {Footer, Header}
  };
</script>

<style scoped>
  .border {
    padding: 30px;
  }
</style>
