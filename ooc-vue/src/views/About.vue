<template>
  <div class="about content">
    <Header/>
    <div class="container py-2">
      <div class="row border-bottom py-2">
        <h1 class="text-dark ">About</h1>

      </div>
    </div>
    <Footer/>
  </div>

</template>

<script>
import Header from "../components/Header";
import Footer from "../components/Footer";

export default {
  name: "About",
  components: { Header, Footer },
  data: {
    items: []
  },
  created: function() {
    fetchItem;
  },
  methods: {}
};
</script>

<style scoped>

</style>
