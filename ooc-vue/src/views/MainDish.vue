<template>
  <div class="main_dish content">
    <!-- <Header/> -->
    <div class="container py-2">

      <div class="container float-right"></div>

      <div class="row border-bottom py-2">
        <h1 class="text-dark ">Main Dish</h1>
      </div>
      <div class="row py-3">
        <div class="col-lg-3 col-md-4 col-sm-6 p-3 " v-bind:key="index" v-for="(data, index) in main_dish">
          <div class="card bg-dark text-secondary">
            <img class="card-img-top" src="../assets/logo.png" alt="Card image cap">
            <div class="card-body">
              <h5 class="card-title border-bottom text-light">{{data.name}}</h5>

            </div>
            <div class="card-footer">
              <div class="d-flex w-100">
                <div class="py-2 font-weight-bold text-light"> {{data.price}} ฿</div>
                <button type="submit"
                        class="btn btn-info p-auto ml-auto "
                        v-confirm="{
                          ok: dialog => add(data),
                          okText : 'Add',
                          animation: 'fade',
                          cancel: doNothing,
                          message: 'Add to List?'
                        }"
                >
                  SELECT
                </button>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>

  import {mapMutations} from 'vuex'
  import {AXIOS} from "../http-common";

  export default {
    name: 'Home',
    data() {
      return {
        main_dish: [
        ]
      }
    },
    mounted() {
      AXIOS.get('api/main_dish')
        .then(response => {
          this.main_dish = response.data
        })
    },
    methods : {
      ...mapMutations([
        'addItem',
      ]),
      ...mapMutations({
        add: 'addItem', // map `this.add()` to `this.$store.commit('increment')`

      }),
      doNothing(){}
    }

  }
</script>

<style scoped>

</style>
