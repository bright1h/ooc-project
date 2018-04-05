<template>
  <div class="admin_home">
    <div class="container py-2">
      <div class="row border-bottom py-2">
        <h1 class="text-dark ">Admin Home</h1>
      </div>
      <div class="row my-4">
        <AdminSideBar/>
        <div class="col">
          <img src="../assets/logo.png" alt="Brew and bev logo">
        </div>
      </div>
    </div>
  </div>
</template>

<script>
  import Carousel from '../components/Carousel'
  import AdminSideBar from "../components/AdminSideBar";

  export default {
    name: 'AdminHome',
    components: {AdminSideBar, Carousel}
  }
</script>

<style scoped>

</style>
