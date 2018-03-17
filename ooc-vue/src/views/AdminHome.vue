<template>
  <div class="admin_home">
    <Header/>
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
    <Footer/>
  </div>
</template>

<script>
  //   import CustomerSideBar from '../components/AdminSideBar'
  import Carousel from '../components/Carousel'
  import AdminSideBar from "../components/AdminSideBar";
  import Footer from "../components/Footer";
  import Header from "../components/Header";

  export default {
    name: 'AdminHome',
    components: {Header, Footer, AdminSideBar, Carousel}
  }
</script>

<style scoped>

</style>
