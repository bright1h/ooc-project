<template>
  <div class="drink content">
    <!-- <Header/> -->
    <div class="container py-2">

      <div class="container float-right"></div>

      <div class="row border-bottom py-2">
        <h1 class="text-dark ">Coffee</h1>
      </div>
      <div class="row py-3">
        <div class="col-lg-3 col-md-4 col-sm-6 p-3 " v-bind:key="index" v-for="(data, index) in coffee">
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

      <div class="row border-bottom py-2">
        <h1 class="text-dark ">Non Coffee</h1>
      </div>
      <div class="row py-3">
        <div class="col-lg-3 col-md-4 col-sm-6 p-3 " v-bind:key="index" v-for="(data, index) in non_coffee">
          <div class="card bg-dark text-secondary">
            <img v-if="data.imageName !== null" class="card-img-top" :src="'http://localhost:8088/api/image/'+data.imageName" alt="Card image cap">
            <img v-else class="card-img-top" src="../assets/logo.png" alt="Card image cap">
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
  import {AXIOS} from '../http-common'

  export default {
    name: 'Drink',
    data() {
      return {
        coffee: [],
        non_coffee: []
      }
    },
    mounted() {
      AXIOS.get('api/non_coffee')
        .then(response => {
          this.non_coffee = response.data
        });
      AXIOS.get('api/coffee')
        .then(response => {
          this.coffee = response.data
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
