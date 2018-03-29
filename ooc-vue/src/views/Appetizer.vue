<template>
  <div class="appetizer content">
    <Header/>
    <div class="container py-2">

      <div class="container float-right"></div>

      <div class="row border-bottom py-2">
        <h1 class="text-dark ">Appetizer</h1>
      </div>
      <div class="row py-3">
        <div class="col-lg-3 col-md-4 col-sm-6 p-3 " v-bind:key="index" v-for="(data, index) in menus">
          <div class="card bg-dark text-secondary">
            <img class="card-img-top" src="../assets/logo.png" alt="Card image cap">
            <div class="card-body">
              <h5 class="card-title border-bottom text-light">{{data.name}}</h5>

            </div>
            <div class="card-footer">
              <div class="d-flex w-100">
                <div class="py-2 font-weight-bold text-light"> {{data.price}} ฿</div>
                <button class="btn btn-info p-auto ml-auto " data-toggle="modal" data-target="#myModal"> SELECT</button>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
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
  </div>

</template>

<script>
  import Header from '../components/Header'
  import Footer from '../components/Footer'
  import {AXIOS} from '../http-common'

  export default {
    name: 'Appetizer',
    components: {Header, Footer},
    data() {
      return {
        menus: [
        ]
      }
    },
    mounted() {
      AXIOS.get('api/appetizer')
        .then(response => {
          this.menus = response.data
        })
    }
  }

</script>

<style scoped>


</style>
