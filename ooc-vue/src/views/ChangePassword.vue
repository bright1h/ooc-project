<template>
    <div class="changePwd p-2 rounded"
        style="background-color: #ffffff;">
    <div class="container">
        <div class="row border-bottom py-1">
            <div class="col text-left">
                <h1>Your Profile</h1>
            </div>
        </div>
        <div class="form-row mt-4">
            <div class="form-group col-md">
                <input type="password"
                        class="form-control"
                        placeholder="New Password"
                        name="password"
                        v-validate="'required'"
                        v-model="editPwd.pwd">
                    <span v-if="errors.has('password')">
                        <p class="alert alert-warning py-0 text-left my-1">{{errors.first('password')}}</p>
                    </span>
            </div>
        </div>
        <div class="form-row">
            <div class="form-group col-md">
                <input type="password"
                               class="form-control"
                               placeholder="Confirmed New Password"
                               name="confirmed password"
                               v-validate="'required|confirmed:password'"
                               v-model="editPwd.cPwd">
                    <span v-if="errors.has('confirmed password')">
                        <p class="alert alert-warning py-0 text-left my-1">{{errors.first('confirmed password')}}</p>
                    </span>
            </div>

        </div>
        <div class="form-footer ">
            <button class="btn btn-primary">Change Password</button>
        </div>
    </div>

    </div>
</template>

<script>
  export default {
    name: "ChangePassword",
    data(){
        return {
            editPwd : {
                newPwd : "",
                newCPwd : "",
            }
        }
    },
    methods : {
        changePwd(){

        }
    }
  };
</script>

<style scoped>
  .border {
    padding: 30px;
  }
</style>
