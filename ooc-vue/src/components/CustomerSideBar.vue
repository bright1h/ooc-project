<template>
  <div class="col-2">
    <nav class="nav flex-column">
      <router-link class="nav-link" to="/">Home</router-link>
      <router-link class="nav-link" to="/order_list">Promotion</router-link>
      <router-link class="nav-link" to="/order_history">Menu</router-link>
      <router-link class="nav-link" to="/promotion">Cart</router-link>
    </nav>
  </div>
</template>

<script>
  export default {
    name: 'CustomerSideBar'
  }
</script>

<style scoped>

</style>
