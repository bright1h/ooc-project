<template>
  <div class="order-list">
    <div class="container">
      <div class="row border-bottom py-1">
        <h1 class="text-dark ">Order List</h1>
      </div>
      <div class="row my-4">
        <div class="col">
          <div id="accordion">
              <div class="card">
                <div class="card-header" id="headingOne">
                  <h5 class="mb-0">
                    <button class="btn btn-link" data-toggle="collapse" data-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
                      Collapsible Group Item #1
                    </button>
                  </h5>
                </div>

                <div id="collapseOne" class="collapse show" aria-labelledby="headingOne" data-parent="#accordion">
                  <div class="card-body">
                    Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad squid. 3 wolf moon officia aute, non cupidatat skateboard dolor brunch. Food truck quinoa nesciunt laborum eiusmod. Brunch 3 wolf moon tempor, sunt aliqua put a bird on it squid single-origin coffee nulla assumenda shoreditch et. Nihil anim keffiyeh helvetica, craft beer labore wes anderson cred nesciunt sapiente ea proident. Ad vegan excepteur butcher vice lomo. Leggings occaecat craft beer farm-to-table, raw denim aesthetic synth nesciunt you probably haven't heard of them accusamus labore sustainable VHS.
                  </div>
                </div>
              </div>
              <div class="card">
                <div class="card-header" id="headingTwo">
                  <h5 class="mb-0">
                    <button class="btn btn-link collapsed" data-toggle="collapse" data-target="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
                      Collapsible Group Item #2
                    </button>
                  </h5>
                </div>
                <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordion">
                  <div class="card-body">
                    Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad squid. 3 wolf moon officia aute, non cupidatat skateboard dolor brunch. Food truck quinoa nesciunt laborum eiusmod. Brunch 3 wolf moon tempor, sunt aliqua put a bird on it squid single-origin coffee nulla assumenda shoreditch et. Nihil anim keffiyeh helvetica, craft beer labore wes anderson cred nesciunt sapiente ea proident. Ad vegan excepteur butcher vice lomo. Leggings occaecat craft beer farm-to-table, raw denim aesthetic synth nesciunt you probably haven't heard of them accusamus labore sustainable VHS.
                  </div>
                </div>
              </div>
              <div class="card">
                <div class="card-header" id="headingThree">
                  <h5 class="mb-0">
                    <button class="btn btn-link collapsed" data-toggle="collapse" data-target="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
                      Collapsible Group Item #3
                    </button>
                  </h5>
                </div>
                <div id="collapseThree" class="collapse" aria-labelledby="headingThree" data-parent="#accordion">
                  <div class="card-body">
                    Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad squid. 3 wolf moon officia aute, non cupidatat skateboard dolor brunch. Food truck quinoa nesciunt laborum eiusmod. Brunch 3 wolf moon tempor, sunt aliqua put a bird on it squid single-origin coffee nulla assumenda shoreditch et. Nihil anim keffiyeh helvetica, craft beer labore wes anderson cred nesciunt sapiente ea proident. Ad vegan excepteur butcher vice lomo. Leggings occaecat craft beer farm-to-table, raw denim aesthetic synth nesciunt you probably haven't heard of them accusamus labore sustainable VHS.
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
        
      
      <!-- <div class="row">
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
      </div> -->
    </div>
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
