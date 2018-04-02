<template>
  <div class="order-list">
    <Header/>
    <div class="container py-2">
      <div class="row border-bottom my-4">
        <h1 class="text-dark ">Order List</h1>
      </div>
      <div class="row">
        <AdminSideBar/>
        <div class="col">
          <table class="table">
            <thead>
            <tr>
              <th>First Name</th>
              <th>Date</th>
              <th>Menu</th>
              <th>Quantity</th>
              <th>Price</th>
              <th>Status</th>
            </tr>
            </thead>
            <tbody>
            <tr>
              <td>Mike</td>
              <td>2018-02-20</td>
              <td>Blueberry Cheesecake</td>
              <td>1</td>
              <td>100</td>
              <td><button type="button" class="btn btn-primary">Preparing</button></td>
            </tr>
            <tr>
              <td>John</td>
              <td>2018-02-21</td>
              <td>Hot chocolate</td>
              <td>2</td>
              <td>240</td>
              <td><button type="button" class="btn btn-primary">Preparing</button></td>
            </tr>
            </tbody>
          </table>
        </div>
      </div>
    </div>
    <Footer/>
  </div>
</template>


<script>
  import AdminSideBar from '../components/AdminSideBar'
  import Header from "../components/Header";
  import Footer from "../components/Footer";

  export default {
    name: 'OrderList',
    components: {Footer, Header, AdminSideBar}
  }
</script>

<style scoped>

</style>
