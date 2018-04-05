<template>
  <div class="admin_home content">
    <div class="container">
      <div class="row border-bottom py-2">
        <h1 class="text-dark ">Admin Page</h1>
      </div>

      <div class="row py-3">
        <div class="col-sm-3">
          <div class="nav flex-column nav-pills py-2" id="v-pills-tab" role="tablist" aria-orientation="vertical"
              style="
               background-color: #ffffff;">
            <a class="nav-link active" id="v-pills-home-tab" data-toggle="pill" href="#v-pills-home" role="tab" aria-controls="v-pills-home" aria-selected="true">Home</a>
            <a class="nav-link" id="v-pills-menus-tab" data-toggle="pill" href="#v-pills-menus" role="tab" aria-controls="v-pills-menus" aria-selected="false">Menus</a>
            <a class="nav-link" id="v-pills-order-tab" data-toggle="pill" href="#v-pills-order" role="tab" aria-controls="v-pills-order" aria-selected="false">OrderList</a>
            <a class="nav-link" id="v-pills-history-tab" data-toggle="pill" href="#v-pills-history" role="tab" aria-controls="v-pills-history" aria-selected="false">History</a>
          </div>
        </div>
        <div class="col-sm-9">
          <div class="tab-content" id="v-pills-tabContent">
            <div class="tab-pane fade show active" id="v-pills-home" role="tabpanel" aria-labelledby="v-pills-home-tab">
              <Carousel/>
            </div>
            <div class="tab-pane fade" id="v-pills-menus" role="tabpanel" aria-labelledby="v-pills-menus-tab">
              <Menu/>
            </div>
            <div class="tab-pane fade" id="v-pills-order" role="tabpanel" aria-labelledby="v-pills-order-tab">
              <OrderList/>
            </div>
            <div class="tab-pane fade" id="v-pills-history" role="tabpanel" aria-labelledby="v-pills-history-tab">
              <OrderHistory/>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
  //   import CustomerSideBar from '../components/AdminSideBar'
  import Carousel from '../components/Carousel'
  import OrderList from '../views/OrderList'
  import Menu from '../views/Menu'
  import OrderHistory from '../views/OrderHistory'

  export default {
    name: 'AdminHome',
    components: { Carousel, OrderList, Menu, OrderHistory }
  }
</script>

<style scoped>

</style>
