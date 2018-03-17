<template>
  <div class="home content">
    <Header/>
    <div class="container py-2">
      <div class="row border-bottom py-2">
        <h1 class="text-dark ">News</h1>
      </div>
      <div class="row py-4">
        <div class="col">

         <Carousel/>
        </div>
      </div>
  
      
    </div>
        <Footer/>
      
  </div>

</template>

<script>
  import Header from '../components/Header'
  import Footer from '../components/Footer'
  import Carousel from "../components/Carousel";

  export default {
    name: 'Home',
    components: {Carousel, Header, Footer}
  }
</script>

<style scoped>

</style>
