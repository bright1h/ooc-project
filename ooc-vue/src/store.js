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
        email: '',
        userType: ''
      },
      plugins: [createPersistedState({
        storage: {
          getItem: key => Cookies.get(key),
          setItem: (key, value) => Cookies.set(key, value, { expires: expireIn, secure: false }),
          removeItem: key => Cookies.remove(key)
        }
      })],
      mutations: {

        addItem(state, addedItem ){
          var item = state.cart.find(item => item.id === addedItem.id);
          state.cart.push(item);
          state.cartQuantity++;
          state.totalPrice += addedItem.price;
        },

        removeItem(state, name){
          // console.log(removedItem.id)
          var item = state.cart.find(item => item.name === name);         
          var index = state.cart.indexOf(item);
            
          state.cartQuantity--;
          state.totalPrice-=item.price;
          state.cart.splice(index,1);

        
        },
        resetCart(state){
          state.cart = [];
          state.cartQuantity=0;
          state.totalPrice=0;
        },

        setAuth(state, email, userType) {
          state.email = email,
          state.userType = userType
        }
      },
});
