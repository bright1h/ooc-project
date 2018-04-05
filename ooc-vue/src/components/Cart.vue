<template>
  <div class="cart">

    
    <li class="nav-item dropdown ml-3">
      <a class="nav-link text-light" 
         id="navbardrop" 
         data-toggle="dropdown"
        >
      
          <div class="icon-circle">
            <i class="fa  bg-primary text-white">{{totalQuantity}}</i>
          </div>  
      </a>
      <div class="dropdown-menu dropdown-menu-right cart-bg mt-3 "
          id = "myDropdown"
          @click="$event.stopPropagation();">
        <div class="container" v-if="totalQuantity===0" >
          Your cart is currently empty.
        
        </div>
        <div class="container" v-if="totalQuantity>0">
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
            <div class="col-3 border-right ">
              Quantity
            </div>

            <div class="col-3 border-right ">
                Price
            </div>
            <div class="col-2">
            </div>
          </div>
          
          <div class="row" 
              v-bind:key="data.name"
              v-for="data in cart"
              style="font-size: 15px;">
            <div class="col-4 border-right pt-2 break">
                {{data.name}}
            </div>
            <div class="col-3 border-right pt-2" >
               {{data.quantity}}
            </div>
            <div class="col-3 border-right pt-2">
                {{data.sumPrice}} ฿
            </div> 
            <div class="col-2 my-1 ">
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
          
          <!-- <div class="row border-top border-bottom mt-2   ">
            <div class="col-7 pt-1 border-right font-italic">
              Total Items: 
            </div>

             <div class="col-5 pt-1 m-auto">
              {{totalQuantity}}
            </div>
          </div> -->

          <div class="row border-top border-bottom">
            <div class="col-4 pt-1 border-right font-italic">
              Total Price: 
            </div>

             <div class="col- pt-1 m-auto ">
              {{totalPrice}} ฿
            </div>
          </div>
          
          <div class="row">
            <div class="col">
              <a class="btn btn-primary w-100 my-2" href="/checkout">Checkout</a>
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
      totalQuantity(){
        return this.$store.state.cartQuantity
      },
      cart(){
        return this.$store.state.cart
      },
      totalPrice(){
        return this.$store.state.totalPrice
      }
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
  min-width: 350px;
  width: 100%;
  max-height: 500px;
  overflow-y: auto; 
}
.cart-bg{
  background: #444;
  color: #f9f9f9;
}

 .icon-circle .fa {
    font-size: 20px;
    height: 35px;
    width: 35px;
    line-height: 35px;
    
  }
  @media (min-width: 320px) and (max-width: 768px) {
    .icon-circle .fa {
      font-size: 20px;
      height: 35px;
      width: 35px;
      line-height: 35px;
      } 
  }
</style>
