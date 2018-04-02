<template>
  <div class="checkout content">
    <div class="container">
      <div class="row border-bottom py-3">
        <h1 class="text-dark ">Your Order</h1>
      </div>

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
  import TypeRadioBox from '../components/TypeRadioBox'
  import SweetnessRadioBox from '../components/SweetnessRadioBox'
  import ValueInputButton from '../components/ValueInputButton'
  import ToppingsDropDown from '../components/ToppingsDropDown'


  import {mapMutations} from 'vuex'

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
        reset: 'resetCart',
        remove: 'removeItem'
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
