<template>
<<<<<<< HEAD
  <div class="checkout">
    <Header/>
=======
  <div class="checkout content">
>>>>>>> origin/register
    <div class="container">
      <div class="row border-bottom py-3">
        <h1 class="text-dark ">Your Order</h1>
      </div>
<<<<<<< HEAD
      <div class="row">
        <div class="col">
          <table class="table border-bottom">
            <thead>
            <tr class="border-bottom">
              <!-- the first column should be item number (AutoIncrement) -->
              <th></th>
              <!-- <th>Img</th> -->
              <th>Name</th>
              <th>Price</th>
              <th>Type</th>
              <th>Sweetness Level</th>
              <th>Toppings</th>
              <th>Quantity</th>
            </tr>
            </thead>
            <tbody>
            <tr>
              <td>1</td>
              <!-- <td>foo.png</td> -->
              <td>Blueberry Cheesecake</td>
              <td>1000</td>
              <td>
                <TypeRadioBox/>
              </td>
              <td>
                <SweetnessRadioBox/>
              </td>
              <td>
                <ToppingsDropDown/>
              </td>
              <td>
                <ValueInputButton/>
              </td>
            </tr>
            </tbody>
          </table>
          <form>
            <label for="specialRequest" class="h4 float-left text-dark">Special Requests:</label>
            <input type="text" class="form-control" id="specialRequest" name="specialRequest">
          </form>
          <form class="pt-3">
            <button type="submit" class="btn btn-primary mt-2 float-right">Submit</button>
          </form>
        </div>
      </div>
    </div>
    <Footer/>
  </div>
</template>

<script>
  import Header from '../components/Header'
  import Footer from '../components/Footer'
=======

      <div class="container" v-if="quantity===0" >
        <div class="w-100mx-auto font-weight-bold h1">
          Your cart is currently empty.<br>
            
        </div>
       
      </div>
        <div class="container " v-if="quantity>0">
          <div class="row border-bottom font-weight-bold h4 py-3">
            <div class="col-1">
              No.
            </div>
            <div class="col-6">
              Name
            </div>
            <div class="col-3">
              Price
            </div>
            <div class="col-1">

            </div>
          </div>
          
          <div class="row font-weight-bold py-1 " 
              v-bind:key="data.id"
              v-for="(data,index) in cart"
               >
            <div class="col-1 pt-1">
                {{index+1}}
            </div>
            <div class="col-6 pt-1">
                {{data.name}}
            </div>
            <div class="col-3 pt-1">
                {{data.sumPrice}} ฿
            </div> 
            <div class="col-2 pb-2">
              <button type="submit" 
                      class="btn btn-sm btn-danger"
                      v-confirm="{
                          ok: dialog => remove(data.id),
                          okText :'Remove',
                          animation : 'fade',
                          cancel: doNothing,
                          message: 'Do you want to remove ' +data.name+ ' from the list?',
                        }">
                        <i class="fa fa-times"></i>

              </button>
            </div>
          </div>
          
          <div class="row border-top border-bottom mt-4">
            <div class="col-3 pt-1  font-weight-bold h5">
              Total Items: 
            </div>
             <div class="col-3 pt-1 font-weight-bold m-auto">
              {{quantity}}
            </div>
            <div class="col-3 pt-1  font-weight-bold h5">
              Total Price: 
            </div>
            <div class="col-3 pt-1 font-weight-bold m-auto">
              {{total}} ฿
            </div>
          </div>
          <div class="row text-left font-weight-bold h5 my-2">
            Special Request
          </div>
          <div class="row">
            
            <form class="w-100">
              <textarea class="form-control">
              </textarea>
            </form>
          </div>
          
          <div class="row">
            <div class="col">
              <button class="btn btn-primary w-25 my-2 float-right">Confirm</button>
            </div>
          </div>

        </div>
      </div>
    </div>
</template>

<script>
>>>>>>> origin/register
  import TypeRadioBox from '../components/TypeRadioBox'
  import SweetnessRadioBox from '../components/SweetnessRadioBox'
  import ValueInputButton from '../components/ValueInputButton'
  import ToppingsDropDown from '../components/ToppingsDropDown'

<<<<<<< HEAD
  export default {
    name: 'CheckOut',
    components: {Header, Footer, TypeRadioBox, SweetnessRadioBox, ToppingsDropDown, ValueInputButton}
=======
  
  import { mapGetters } from 'vuex'
  import { mapMutations } from 'vuex'

  export default {
    
    name: 'CheckOut',
    components: {TypeRadioBox, SweetnessRadioBox, ToppingsDropDown, ValueInputButton},
  
    computed : {
      quantity(){
        return this.$store.state.cartQuantity
      },
      cart(){
        return this.$store.state.cart
      },
      total(){
        return this.$store.state.totalPrice
      },
      status(){
        return this.$store.state.checkoutStatus
      },
    },
     methods: {
    ...mapMutations([
      'addItem', 
      'resetCart',
      'removeItem',
      ]),
    ...mapMutations({
      add: 'addItem', // map `this.add()` to `this.$store.commit('increment')`
      reset:'resetCart',
      remove : 'removeItem'
      }),
      doNothing(){},
    }
>>>>>>> origin/register
  }
</script>

<style scoped>
<<<<<<< HEAD
=======
.break{
  word-wrap: break-word;
}

>>>>>>> origin/register
</style>
