<template>
  <div class="dropdown">
    <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown"
            aria-haspopup="true" aria-expanded="false">
      Toppings
    </button>
    <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
      <a class="dropdown-item" href="#">Nothing</a>
      <a class="dropdown-item" href="#">1st Topping</a>
      <a class="dropdown-item" href="#">2nd Topping</a>
      <a class="dropdown-item" href="#">3nd Topping</a>
      <a class="dropdown-item" href="#">4nd Topping</a>
      <a class="dropdown-item" href="#">5nd Topping</a>
    </div>
  </div>
</template>

<script>
  export default {
    name: "ToppingsDropDown"
  }
</script>

<style scoped>

</style>
