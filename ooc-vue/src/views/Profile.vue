<template>
  <div class="profile">
    <div class="container py-2">
      <div class="row border-bottom py-2">
        <h1 class="text-dark ">User Setting</h1>
      </div>
      <div class="row py-3">
        <div class="col-sm-3">
          <div class="nav flex-column nav-pills py-2" id="v-pills-tab" role="tablist" aria-orientation="vertical"
              style="
               background-color: #ffffff;">
            <a class="nav-link active" id="v-pills-home-tab" data-toggle="pill" href="#v-pills-home" role="tab" aria-controls="v-pills-home" aria-selected="true">Profile</a>
            <a class="nav-link" id="v-pills-menus-tab" data-toggle="pill" href="#v-pills-menus" role="tab" aria-controls="v-pills-menus" aria-selected="false">Change Password</a>
          </div>
        </div>
        <div class="col-sm-9">
          <div class="tab-content" id="v-pills-tabContent">
            <div class="tab-pane fade show active" id="v-pills-home" role="tabpanel" aria-labelledby="v-pills-home-tab">
              <UserProfile/>
            </div>
            <div class="tab-pane fade" id="v-pills-menus" role="tabpanel" aria-labelledby="v-pills-menus-tab">
              <ChangePassword/>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
  import UserProfile from './UserProfile'
  import ChangePassword from "./ChangePassword"
  export default {
    name: "Profile",
    components : {UserProfile, ChangePassword}
  };
</script>

<style scoped>
  .border {
    padding: 30px;
  }
</style>
