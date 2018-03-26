<template>
  <div id="app">
    <Header/>
    <router-view/>
    <Footer/>
  </div>
</template>

<script>
  import Header from './components/Header'
  import Footer from './components/Footer'
  
  export default {
    name: 'Home',
    components: {Header, Footer},
  }
 
</script>

<style>

@import url("https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css ");
  
  html {
    position: relative;
    min-height: 100%;
    margin:0;
    padding: 0;
  }

  body {
    background-color: #e9ebee ;
   
  }

  .dg-btn--ok {
     border-color: #42adf4;
   }
 
  .dg-btn-loader .dg-circle {
      background-color: #42adf4;
  }

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
