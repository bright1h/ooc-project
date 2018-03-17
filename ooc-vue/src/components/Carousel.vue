<template>
  <div id="demo" class="carousel slide" data-ride="carousel">

    <!-- Indicators -->
    <ul class="carousel-indicators">
      <li data-target="#demo" data-slide-to="0" class="active"></li>
      <li data-target="#demo" data-slide-to="1"></li>
      <li data-target="#demo" data-slide-to="2"></li>
      <li data-target="#demo" data-slide-to="3"></li>
    </ul>

    <!-- The slideshow -->
    <div class="carousel-inner">
      <div class="carousel-item active">
        <img src="../assets/carousel1.jpg" class="w-100" alt="Carousel 1">
      </div>
      <div class="carousel-item">
        <img src="../assets/carousel2.jpg" class="w-100" alt="Carousel 2">
      </div>
      <div class="carousel-item">
        <img src="../assets/carousel3.jpg" class="w-100" alt="Carousel 3">
      </div>
      <div class="carousel-item">
        <img src="../assets/carousel4.jpg" class="w-100" alt="Carousel 4">
      </div>
    </div>

    <!-- Left and right controls -->
    <a class="carousel-control-prev" href="#demo" data-slide="prev">
      <span class="carousel-control-prev-icon"></span>
    </a>
    <a class="carousel-control-next" href="#demo" data-slide="next">
      <span class="carousel-control-next-icon"></span>
    </a>

  </div>
</template>

<script>
  export default {
    name: "Carousel"
  };
</script>

<style scoped>
  .carousel-inner img {
    /*width: 100%;*/
    /*height: 60%;*/
    width: 300px;
    height: 500px;
    min-width: 150px;
    min-height: 250px;
  }
</style>

