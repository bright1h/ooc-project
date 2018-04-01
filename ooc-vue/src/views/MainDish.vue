<template>
  <div class="main_dish content">
<<<<<<< HEAD
    <Header/>
=======
    <!-- <Header/> -->
>>>>>>> origin/register
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
<<<<<<< HEAD
                <button class="btn btn-info p-auto ml-auto " data-toggle="modal" data-target="#myModal"> SELECT</button>
              </div>
=======
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
>>>>>>> origin/register
            </div>
          </div>
        </div>
      </div>
    </div>
<<<<<<< HEAD
    <!-- The Modal -->
    <div class="modal fade" id="myModal">
      <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content">

          <!-- Modal Header -->
          <div class="modal-header">
            <h4 class="modal-title">Add to list?</h4>
            <button type="button" class="close" data-dismiss="modal">&times;</button>
          </div>

          <!-- Modal body
          <div class="modal-body">
            Modal body..
          </div>
           -->
          <!-- Modal footer -->
          <div class="modal-footer">
            <button type="button" class="btn btn-success" data-dismiss="modal">Add</button>

            <button type="button" class="btn btn-danger" data-dismiss="modal">Cancel</button>
          </div>

        </div>
      </div>
    </div>
    <Footer/>
=======
>>>>>>> origin/register
  </div>
</template>

<script>
<<<<<<< HEAD
  import Header from '../components/Header'
  import Footer from '../components/Footer'
=======

  import { mapGetters } from 'vuex'
  import { mapMutations } from 'vuex'
>>>>>>> origin/register
  import {AXIOS} from "../http-common";

  export default {
    name: 'Home',
<<<<<<< HEAD
    components: {Header, Footer},
=======
>>>>>>> origin/register
    data() {
      return {
        main_dish: [
        ]
      }
    },
    mounted() {
<<<<<<< HEAD
      AXIOS.get('api/main_dish')
        .then(response => {
          this.main_dish = response.data
        })
    }
=======
      AXIOS.get('api/main_dishes')
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

>>>>>>> origin/register
  }
</script>

<style scoped>

</style>
