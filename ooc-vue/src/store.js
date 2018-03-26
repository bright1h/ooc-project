import Vue from 'vue';
import Vuex from 'vuex';
import createPersistedState from 'vuex-persistedstate'
import * as Cookies from 'js-cookie'


Vue.use(Vuex);

var expireIn = 1/144; //10mins

export const store = new Vuex.Store({
    state: {
        count: 0,
        cartQuantity : 0,
        cart : [],
        totalPrice : 0,
        checkoutStatus : 0,
      },
      plugins: [createPersistedState({
        storage: {
          getItem: key => Cookies.get(key),
          setItem: (key, value) => Cookies.set(key, value, { expires: expireIn, secure: false }),
          removeItem: key => Cookies.remove(key)
        }
      })],
      mutations: {
        increment: state => state.count++,
        decrement: state => state.count--,

        addItem(state, addedItem ){
          var item = state.cart.find(item => item.id === addedItem.id);
          if(!item){
            addedItem.sumQuantity =1;
            addedItem.sumPrice = addedItem.price;
            state.cart.push(addedItem);
          }
          else{
            item.sumQuantity++;
            item.sumPrice+=addedItem.price;
          }
          state.cartQuantity++;
          state.totalPrice += addedItem.price;
        },

        removeItem(state, removedItem){
          console.log(removedItem.id)
          var item = state.cart.find(item => item.id === removedItem.id);
          console.log(item.id);
          if(item.sumQuantity===1){
            console.log('in here');

            var index = state.cart.indexOf(item);
            console.log(index);
            if (index !== -1){
              state.cart.splice(index,1);
            }
          }
          else{
            item.sumQuantity--;
            item.sumPrice-=removedItem.price;
          }

          state.cartQuantity--;
          state.totalPrice-=item.price;
        },
        resetCart(state){
          state.cart = [];
          state.cartQuantity=0;
          state.totalPrice=0;
        }
      },
});
