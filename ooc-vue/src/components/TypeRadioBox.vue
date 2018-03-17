<template>
  <div class="btn-group btn-group-toggle" data-toggle="buttons">
    <label class="btn btn-secondary active">
      <input type="radio" name="options" id="option1" autocomplete="off" checked> Hot
    </label>
    <label class="btn btn-secondary">
      <input type="radio" name="options" id="option2" autocomplete="off"> Cold
    </label>
    <label class="btn btn-secondary">
      <input type="radio" name="options" id="option3" autocomplete="off"> Blend
    </label>
  </div>
</template>

<script>
  export default {
    name: "TypeRadioBox"
  }
</script>

<style scoped>

</style>
