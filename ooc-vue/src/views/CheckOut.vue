<template>
  <div class="checkout content">
    <div class="container">
      <div class="row border-bottom py-3">
        <h1 class="text-dark ">Your Order</h1>
      </div>
      <div class="container" v-if="totalQuantity===0" >
        <div class="w-100 mx-auto font-weight-bold h1">
          Your cart is currently empty.<br>

        </div>

      </div>
      <div class="container " v-if="totalQuantity>0">
        <div class="row border-bottom font-weight-bold h4 py-3">
          <div class="col-1">
            No.
          </div>
          <div class="col-5">
            Name
          </div>
          <div class="col-3">
            Quantity
          </div>
          <div class="col-2">
            Price
          </div>
          <div class="col-1">

          </div>
        </div>

        <div class="row font-weight-bold py-1 "
             v-bind:key="data.name"
             v-for="(data,index) in cart"
        >
          <div class="col-1 pt-1">
            {{index+1}}
          </div>
          <div class="col-5 pt-1">
            {{data.name}}
          </div>
          <div class="col-3 pt-1">
            {{data.quantity}}
          </div>
          <div class="col-2 pt-1">
            {{data.sumPrice}} ฿
          </div>

          <div class="col-1 pb-2">
            <button type="submit"
                    class="btn btn-sm btn-danger"
                    v-confirm="{
                          ok: dialog => remove(data),
                          okText :'Remove',
                          animation : 'fade',
                          cancel: doNothing,
                          message: 'Do you want to remove ' +data.name+ ' from the list?',
                        }">
              <i class="fa fa-minus"></i>

            </button>
          </div>
        </div>

        <div class="row border-top border-bottom mt-4">
          <div class="col-3 pt-1  font-weight-bold h5">
            Total Items:
          </div>
          <div class="col-3 pt-1 font-weight-bold m-auto">
            {{totalQuantity}}
          </div>
          <div class="col-3 pt-1  font-weight-bold h5">
            Total Price:
          </div>
          <div class="col-3 pt-1 font-weight-bold m-auto">
            {{totalPrice}} ฿
          </div>
        </div>
        <div class="row text-left font-weight-bold h5 my-2">
          Special Request
        </div>
        <div class="row">

          <form class="w-100">
              <textarea class="form-control"
                        placeholder="Add Your Special Request"
                        
                        v-model="cart.special_request">
              </textarea>

              {{cart}}
          </form>
          <!-- {{data.special_request}} -->
        </div>

        <div class="row">
          <div class="col">
            <button v-if="!isLogin" 
                    class="btn btn-primary w-25 my-2 float-right"
                    @click="submit">Confirm</button>

            <div>
              <span v-if="!isLogin"
                    class="float-right my-2">
                  Please <u class="font-weight-bold">Login</u> to continue.
                </span>
            </div>

          </div>
        </div>

      </div>
    </div>
  </div>
</template>

<script>
  
  import Login from '../components/Login'

  import {mapMutations} from 'vuex'

  export default {

    name: 'CheckOut',
    components: {Login},

    computed : {
      totalQuantity(){
        return this.$store.state.cartQuantity
      },
      cart(){
        return this.$store.state.cart
      },
      totalPrice(){
        return this.$store.state.totalPrice
      },
      specialRequest(){
        return this.$store.state.specialRequest
      },
      isLogin(){
        return this.$store.state.isLogin
      }
    },
    methods: {
      ...mapMutations([
        'addItem',
        'resetCart',
        'removeItem',
        'submitCart'
      ]),
      ...mapMutations({
        add: 'addItem', // map `this.add()` to `this.$store.commit('increment')`
        reset: 'resetCart',
        remove: 'removeItem',
        submit: 'submitCart',
      }),
      doNothing(){},
    }
  }
</script>

<style scoped>
  .break {
    word-wrap: break-word;
  }

</style>
