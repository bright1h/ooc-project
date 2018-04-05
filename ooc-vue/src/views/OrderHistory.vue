<template>
  <div class="order-list p-2 rounded"
  style="
    background-color: #ffffff;">
    <div class="container">
      <div class="row border-bottom py-1">
        <h1 class="text-dark ">Order History</h1>
      </div>
      <div class="row my-4">
        <div class="col">
          <div id="accordion">
            <!-- add this later v-bind:key="index" v-for="(order,index) in orderlist" -->
              <div class="card"  >
                <div class="card-header alert-success" id="headingOne">
                  <!-- Change collapse one to other name otherwise it's not gonna toggle -->
                  <h6 class="row mb-0 font-weight-bold" data-toggle="collapse" data-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
                    
                    <div class="col-sm-4 m-auto">
                    
                      <span class="">OrderID # 1</span>
                    
                    </div>
                    <div class="col-sm-4 m-auto">
                      <span>  
                        By FirstName, LastName
                      </span>
                    
                    </div>
                    <div class="col-sm-4 m-auto">
                      xx/xx/xxxx
                    </div>
                    
                  </h6>
                </div>

                <div id="collapseOne" class="collapse show" aria-labelledby="headingOne" data-parent="#accordion">
                  <div class="card-body text-left">
                    <u>Order: </u>
                    <ul>
                      <li v-bind:key="index" v-for="(data,index) in order">
                        <div class="row">
                          <div class="col">
                            {{data.name}}
                          </div>
                          <div class="col">
                            {{data.quantity}}
                          </div>
                        </div>
                      </li>
                      <li>1</li>
                      <li>2</li>
                      <li>3</li>
                      <li>4</li>
                    </ul>
                    <u>Special Request: </u>
                    <ul>
                      <!-- <li>{{data.specialRequest}}</li> -->
                      <li>test</li>
                    </ul>
                    <div class="alert alert-danger text-right">
                      <span class="font-weight-bold"> Price : xx</span>
                    </div>
                  </div>

                </div>
              </div>
              
            </div>
          </div>
        </div>
    </div>
  </div>
</template>


<script>
  export default {
    name: 'OrderHistory',
  }
</script>

<style scoped>
  .card-body{

    background-color: #e9ebee ;
  }

  .alert{
    font-size: 15px;

  }
</style>
