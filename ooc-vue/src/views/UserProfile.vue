<template>
  <div class="user-profile p-2 rounded"
        style="background-color: #ffffff;">
    <div class="container">
        <div class="row border-bottom py-1">
            <div class="col text-left">
                <h1>Your Profile</h1>
            </div>
            <div class="col m-auto">
                <button class="btn btn-primary btn-sm float-right"
                        data-toggle="modal" 
                        data-target="#edit-modal">Edit</button>
            </div>
        </div>
        <div class="row py-2">
            <div class="col-4 font-weight-bold text-left">
                First Name :
            </div>
            <div class="col text-left">
                {{user.firstName}}
            </div>
        </div>

        
        <div class="row py-2">
            <div class="col-4 font-weight-bold text-left">
                Last Name :
            </div>
            <div class="col text-left">
                {{user.lastName}}
            </div>
        </div>

        <div class="row py-2">
            <div class="col-4 font-weight-bold text-left">
                Email :
            </div>
            <div class="col text-left">
                {{user.email}}
            </div>
        </div>

        <div class="row py-2">
            <div class="col-4 font-weight-bold text-left">
                Mobile Number :
            </div>
            <div class="col text-left">
                {{user.mobilePhone}}
            </div>
        </div>
    </div>

    <div class="modal fade" id="edit-modal">
        <div class="modal-dialog modal-dialog-centered">
            <div class="modal-content">

          <!-- Modal Header -->
            <div class="modal-header">
                <h4 class="modal-title">Edit Profile</h4>
                <button type="button" class="close" data-dismiss="modal">&times;</button>
            </div>

          <!-- Modal body -->
          <div class="modal-body">
            <div class="row pt-2">
              <div class="col-md mt-2 mx-3">
                  <form @submit.prevent="edit()">
                    <div class="form-row">
                      <div class="form-group col-md">
                        <input type="text"
                               class="form-control"
                               placeholder="First Name"
                               name="first name"
                               v-validate="'required|alpha'"
                               v-model="user.firstName">
                        <span v-if="errors.has('first name')">
                          <p class="alert alert-warning py-0 text-left my-1">{{errors.first('first name')}}</p>
                        </span>
                      </div>   
                    </div>
                    <div class="form-row">

                      <div class="form-group col-md">
                        <input type="text"
                               class="form-control"
                               placeholder="Last Name"
                               name="last name"
                               v-validate="'required|alpha'"
                               v-model="user.lastName">
                        <span v-if="errors.has('last name')">
                          <p class="alert alert-warning py-0 text-left my-1">{{errors.first('last name')}}</p>
                        </span>
                      </div>
                    </div>

                    <div class="form-row">
                      <div class="form-group col-md">
                        <input type="email"
                               class="form-control"
                               placeholder="Email"
                               name="email"
                               v-model="user.email"
                               v-validate:email="'required|email'">
                        <span v-if="errors.has('email')">
                          <p class="alert alert-warning py-0 text-left my-1">{{errors.first('email')}}</p>
                        </span>
                      </div>
                    </div>

                    <div class="form-row">
                      <div class="form-group col-md">
                        <input type="text"
                               class="form-control"
                               placeholder="Mobile Number"
                               name="mobile number"
                               v-validate="'required|digits:10'"
                               v-model="user.mobilePhone">
                        <span v-if="errors.has('mobile number')">
                          <p class="alert alert-warning py-0 text-left my-1">{{errors.first('mobile number')}}</p>
                        </span>
                      </div>
                    </div>

                    <div class="form-footer ">
                      <button class="btn btn-primary">Edit</button>
                    </div>
                  </form>
                <!-- </div> -->
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
  import {mapMutations} from 'vuex'
  export default {
    name: "UserProfile",
    data(){
        return {
            user : {
              id: 0,
              firstName : "",
              lastName : "",
              email : "",
              mobilePhone : "",
            },
            // editData : {
            //     newFName : "",
            //     newLName : "",
            //     newEmail : "",
            //     newMobileNo : "",
            // }
        }
    },
    methods : {
      ...mapMutations([
        'editEmail'
      ]),
      edit(){
        this.$http.post("/user/update", {
          id: this.user.id,
          firstName : this.user.firstName,
          lastName : this.user.lastName,
          email : this.user.email,
          mobilePhone : this.user.mobilePhone
        })
        .then(respose => {
          console.log(respose.data.email),
          this.editEmail(response.data.email),
          window.location='/profile'
        })
        .catch(e => {
          console.log(e)
        })
      }
    },
    mounted() {
      this.$http.post('user/find', {
        email: this.$store.state.user.email
      })
      .then(response => {
        this.user = response.data
        console.log(this.user)
      });
    }
  };
</script>

<style scoped>
  .border {
    padding: 30px;
  }
</style>
