<template>
  <div id="app">
<<<<<<< HEAD
    <router-view/>
=======
    <Header/>
    <router-view/>
    <Footer/>
>>>>>>> origin/register
  </div>
</template>

<script>
<<<<<<< HEAD
  
=======
  import Header from './components/Header'
  import Footer from './components/Footer'
  
  export default {
    name: 'Home',
    components: {Header, Footer},
  }
 
>>>>>>> origin/register
</script>

<style>

<<<<<<< HEAD
=======
@import url("https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css ");
  
>>>>>>> origin/register
  html {
    position: relative;
    min-height: 100%;
    margin:0;
    padding: 0;
  }

  body {
    background-color: #e9ebee ;
   
  }

<<<<<<< HEAD
=======
  .dg-btn--ok {
     border-color: #42adf4;
   }
 
  .dg-btn-loader .dg-circle {
      background-color: #42adf4;
  }

>>>>>>> origin/register
  .content{
    margin-bottom: 220px;
  }

 

  #app {
    font-family: "Avenir", Helvetica, Arial, sans-serif;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    text-align: center;
    color: #2c3e50;
  }

 

</style>
