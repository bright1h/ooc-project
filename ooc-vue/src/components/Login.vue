<template>         
  <div class="login">
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
            <div class="row">
              <div class="col-md mt-2 mx-3">
                
                <form>
                  <div class="form-row">
                    <div class="form-group col-md">
                      <input type="text" class="form-control" placeholder="Email or Phone Number">
                    </div>
                  </div>
                  <div class="form-row">
                    <div class="form-group col-md">
                      <input type="password" class="form-control" placeholder="Password">
                    </div>
                  </div>

                  <div class="form-footer ">
                    <div class="row">
                      <div class="col-md">
                        <div class="d-flex">
                          <div class="pt-1">
                            <button type="button" class="btn btn-primary">Login</button>
                          </div>
                          <div class="pt-2 pl-3">
                            <u class="text-primary" data-toggle="modal" data-dismiss="modal" data-target="#myForgotPassword">Forgot your Password?</u>
                          </div>
                        </div>
                      </div>
                    </div>
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
    <div class="modal fade" id="myForgotPassword">
      <div class="modal-dialog modal-md modal-dialog-centered">
        <div class="modal-content">
          <div class="modal-header">
            <h4 class="modal-title">Forgot your password?</h4>
            <button type="button" class="close" data-dismiss="modal">&times;</button>
          </div>

          <div class="modal-body">
            <div class="row">
              <div class="col-md mt-2 mx-3">
                <form>
                  <div class="form-row">
                    <div class="form-group col-md">
                      <input type="email" class="form-control" placeholder="Email associated with your account">
                    </div>
                  </div>
                  <div class="form-footer">
                    <div class="row">
                      <div class="col-md">
                        <div class="d-flex">
                          <div class="pt-1">
                            <button type="button" class="btn btn-primary">Submit</button>
                          </div>
                          <div class="pt-1 pl-2">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
                </form>
              </div>
            </div>
          </div>
          <div class="modal-footer">
          
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
  export default {
    name: "Login",
  };
</script>

<style scoped>
</style>

