<template>
  <div class="login">
    <a class="nav-link text-light text-light" data-toggle="modal" data-target="#login-modal">Login</a>
      
    
    <div class="modal fade" id="login-modal">
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
                <form @submit.prevent="login()">
                  <div class="form-row">
                    <div class="form-group col-md">
                      <input type="text"
                            class="form-control"
                            v-model="email"
                            v-validate:email="'required|email'"
                            name="email"
                            placeholder="Email">
                        <span v-if="errors.has('email')">
                          <p class="alert alert-warning py-0 text-left my-1">{{errors.first('email')}}</p>
                        </span>
                    </div>
                  </div>
                  <div class="form-row">
                    <div class="form-group col-md">
                      <input type="password"
                            class="form-control"
                            v-model="password"
                            v-validate="'required'"
                            name="password"
                            placeholder="Password">
                          <span v-if="errors.has('password')">
                          <p class="alert alert-warning py-0 text-left my-1">{{errors.first('password')}}</p>
                        </span>
                    </div>
                  </div>

                  <div class="form-footer ">
                    <div class="row">
                            <div class="col-md">
                                <div class="d-flex">
                                    <div class="pt-1">
                                      <button class="btn btn-primary">Login</button>
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
                              <button class="btn btn-secondary" data-dismiss="modal">Close</button>
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
  import {mapMutations} from "vuex"
  export default {
    name: "Login",
    data() {
      return {
        email: '',
        password: '',
        auth: {
          email: '',
          userType: ''
        }
      }
    },
    methods: {
      resetForm() {
        this.email = '',
        this.password = ''
      },
      login() {
        this.$validator.validateAll().then((result) => {
          if (result) {
            this.$http.post('/user/login', {
              email: this.email
            },
            {
              auth: {
                username: this.email,
                password: this.password
              }
            })
            .then(response => {
              window.location.href="/"
              this.auth = response.data;
              console.log("success");
              console.log(this.auth);
            })
            .catch(e => {
              console.log("fail");
              alert("Login failed")
            })
            this.resetForm();
            return;
          }
        });
      }
    },
    computed: {
      ...mapMutations([
        'setAuth'
      ]),
    }
  }
</script>

<style scoped>
  .alert{
    font-size: 10px;
     
  }
</style>

