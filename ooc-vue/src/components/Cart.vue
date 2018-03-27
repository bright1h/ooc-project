<template>
  <div class="cart">

    
    <li class="nav-item dropdown ml-3">
      <a class="nav-link dropdown-toggle text-light btn btn-primary" 
         id="navbardrop" 
         data-toggle="dropdown"
        >
        Your Orders
      </a>
      <div class="dropdown-menu dropdown-menu-right cart-bg mt-3 "
          id = "myDropdown"
          @click="$event.stopPropagation();">
        <div class="container" v-if="quantity===0" >
          Your cart is currently empty.
        
        </div>
        <div class="container " v-if="quantity>0">
          <div class="row py-2">
            <div class="col h4 font-weight-bold">
              <u> Your Orders </u>
              <button class=" btn btn-danger btn-sm float-right" @click="reset()">Reset</button>
        
            </div>
          </div>
          <div class="row border-bottom font-italic">
            <div class="col-4 border-right ">
                Name
            </div>
            <div class="col-3 border-right px-auto">
                QTY
            </div>
            <div class="col-3 border-right">
                Price
            </div>
          </div>
          
          <div class="row border-bottom" 
              v-bind:key="data.id"
              v-for="data in cart"
              style="font-size: 15px;">
            <div class="col-4 border-right">
                {{data.name}}
            </div>
            <div class="col-3 border-right">
                {{data.sumQuantity}}
            </div>
            <div class="col-3 border-right">
                {{data.sumPrice}} ฿
            </div> 
            <div class="col-2 my-1 ">
              <button type="submit" 
                      class="btn btn-sm btn-danger"
                      v-confirm="{
                          ok: dialog => remove(data.id),
                          okText :'Remove',
                          animation : 'fade',
                          cancel: doNothing,
                          message: 'Do you want to remove ' +data.name+ ' from the list?',
                        }">
                <i class="fa fa-minus"></i>

              </button>
            </div>
          </div>
          
          <div class="row border-top border-bottom">
            <div class="col-4 pt-1 border-right font-italic">
              Total : 
            </div>

             <div class="col-3 pt-1 m-auto border-right">
              {{quantity}}
            </div>
            <div class="col-5 pt-1 m-auto">
              {{total}} ฿
            </div>
          </div>
          
          <div class="row">
            <div class="col">
              <button class="btn btn-primary w-100 my-2">Checkout</button>
            </div>
          </div>

        </div>
      </div>
    </li>
  </div>

</template>

<script>

  import { mapGetters } from 'vuex'
  import { mapMutations } from 'vuex'

  export default {
    
    name: 'Cart',
    
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
  }

</script>

<style scoped>

.container{
  min-width: 300px;
  width: 100%;
  max-height: 500px;
  overflow: auto;
}
.cart-bg{
  background: #444;
  color: #f9f9f9;
}
</style>
