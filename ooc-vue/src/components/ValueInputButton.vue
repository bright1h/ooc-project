<template>
  <div class="row mx-auto" style="width:180px;">
    <div class="input-group" id="quantityButton">
      <div class="input-group-prepend">
        <button class="btn btn-outline-secondary" v-on:click="decrease"> -</button>
      </div>
      <label for="quantity"></label>
      <input id="quantity" type="number" class="form-control" v-model="quantity" min="1" max="20" disabled>
      <div class="input-group-append">
        <button class="btn btn-outline-secondary" v-on:click="increase"> +</button>
      </div>
    </div>
  </div>
</template>

<script>
  export default {
    name: "Value Input Button",
    data() {
      return {
        quantity: 1,
        min: 1,
        max: 20
      }
    },
    methods: {
      increase: function () {
        if (this.quantity < this.max) {
          this.quantity += 1
        }
      },
      decrease: function () {
        if (this.quantity > this.min) {
          this.quantity -= 1
        }
      }
    }
  }
</script>

<style scoped>

</style>
