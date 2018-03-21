<template>
  <div class="register">
      {{message}}
      <div class="row pt-2">
        <div class="col-md mt-2 mx-3">
            <form>
              <div class="form-row">
                <div class="form-group col-md-6">
                  <input type="text"
                         class="form-control" 
                         placeholder="First name" 
                         v-model="fName">
                </div>
                <div class="form-group col-md-6">
                  <input type="text" 
                         class="form-control"
                         placeholder="Last name" 
                         v-model="lName" >
                </div>
              </div>
              <div class="form-row">
                <div class="form-group col-md">
                  <input type="text" 
                         class="form-control" 
                         placeholder="Phone number" 
                         v-model="phoneNo" >
                </div>
              </div>
              <div class="form-row">
                <div class="form-group col-md">
                  <input type="email" class="form-control" id="email" placeholder="Email" v-model="email">
                </div>
              </div>
              <div class="form-row">
                <div class="form-group col-md">
                  <input type="password" class="form-control" id="pwd" placeholder="Password" v-model="pwd" >
                </div>
              </div>
              <div class="form-row">
                <div class="form-group col-md">
                  <input type="password" class="form-control" id="cPwd" placeholder="Confirm password" v-model="cPwd" >
                </div>
              </div>
              <div class="form-footer ">
                <button class="btn btn-primary" @click.prevent="addUser()">Register</button>
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
  import {AXIOS} from '../http-common'

  export default {
    
    name: "Register",

    data() {
      return {
        fName : "",
        lName : "",
        email : "",
        phoneNo : "",
        pwd : "",
        cPwd : "",
        message : ""
      }
    },

    methods :{
  
      addUser(){
        AXIOS.post(`/api/register`,{
          fName : this.fName,
          lName : this.lName,
          email : this.email,
          phoneNo : this.phoneNo,
          pwd : this.pwd,
          cPwd : this.cPwd,
        })
        .then(response => {
          this.message  = response.data
        })
        .catch(e =>{})
        }
      }
    }

</script>

<style scoped>
</style>

