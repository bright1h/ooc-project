<template>
  <div class="register">
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
            <div class="row pt-2">
              <div class="col-md mt-2 mx-3">
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
                    <button type="button" class="btn btn-primary float-right">Register</button>
                  </div>
                </form>
              </div>
            </div>
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
  import Header from "./Header";
  import Footer from "./Footer";

  export default {
    name: "Register",
    components: {Footer, Header}
  };
</script>

<style scoped>
</style>

