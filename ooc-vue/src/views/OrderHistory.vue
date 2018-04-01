<template>
  <div class="order-history">
<<<<<<< HEAD
    <Header/>
=======
    <!-- <Header/> -->
>>>>>>> origin/register
    <div class="container py-2">
      <div class="row border-bottom py-2">
        <h1 class="text-dark ">Order History</h1>
      </div>
      <div class="row my-4">
        <AdminSideBar/>
        <div class="col">
          <form class="form-inline">
            <div class="form-group mx-sm-3 mb-2">
              <label for="inputDate" class="sr-only">Date</label>
<<<<<<< HEAD
              <input type="date" class="form-control" id="inputDate" v-bind:max="today">
=======
              <input type="date" class="form-control" id="inputDate">
>>>>>>> origin/register
            </div>
            <button type="submit" class="btn btn-primary mb-2">Search</button>
          </form>
          <table class="table">
            <thead>
            <tr>
              <th>First Name</th>
              <th>Date</th>
              <th>Menu</th>
              <th>Quantity</th>
              <th>Price</th>
              <th>From</th>
              <th>Till</th>
              <th>Status</th>
            </tr>
            </thead>
            <tbody>
            <tr>
              <td>Sorawit</td>
              <td>2018-02-20</td>
              <td>Blueberry Cheesecake</td>
              <td>1</td>
              <td>100</td>
              <td>2018-02-20</td>
              <td>2018-02-22</td>
              <td>Done</td>
            </tr>
            </tbody>
          </table>
        </div>
      </div>
    </div>
<<<<<<< HEAD
    <Footer/>
=======
    <!-- <Footer/> -->
>>>>>>> origin/register
  </div>
</template>

<script>
  import AdminSideBar from '../components/AdminSideBar'
  import Header from "../components/Header";
  import Footer from "../components/Footer";

<<<<<<< HEAD
  function getToday() {
    let today = new Date();
    let dd = today.getDate();
    let mm = today.getMonth() + 1; //January is 0!
    const yyyy = today.getFullYear();

    if(dd<10) {
      dd = '0'+dd
    }

    if(mm<10) {
      mm = '0'+mm
    }

    today = yyyy + '-' + mm + '-' + dd;
    return today;
  }

  export default {
    name: 'OrderHistory',
    components: {Footer, Header, AdminSideBar},
    data() {
      return {
        today: ''
      }
    },
    created() {
      this.today = getToday();
    }
=======
  export default {
    name: 'OrderHistory',
    components: {Footer, Header, AdminSideBar}
>>>>>>> origin/register
  }
</script>

<style scoped>

</style>
