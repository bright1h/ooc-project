import Vue from 'vue';
import Vuex from 'vuex';
import createPersistedState from 'vuex-persistedstate'
import * as Cookies from 'js-cookie'
import axios from './vue-axios/axios'
import './vue-axios'

Vue.use(Vuex);

var expireIn = 1/60; 

export const store = new Vuex.Store({
    state: {
        count: 0,
        cartQuantity : 0,
        cart : [],
        totalPrice : 0,
        user: {
          email: '',
          userType: 'ADMIN'
        },
        specialRequest: ''
      },
      plugins: [createPersistedState({
        storage: {
          getItem: key => Cookies.get(key),
          setItem: (key, value) => Cookies.set(key, value, { expires: expireIn, secure: false }),
          removeItem: key => Cookies.remove(key)
        }
      })],

      mutations: {
        submitCart(state){
          axios.post(`/api/checkout`,{
            email : this.state.user.email,
            order : this.state.cart,
            specialRequest : this.state.specialRequest,
          })
          .then(response => {
            this.resetCart();
            this.message  = response.data;
            console.log(this.message);
            if ( this.message == 'Order Successfully') {
              alert(this.message);
              this.resetForm();
              window.location.href="/" ;
            }
          })
          .catch(e =>{

          })
          
        },
  
        addItem(state, addedItem ){
          var name = addedItem.name;
          var newPrice = addedItem.price;
          if(addedItem.sweetness){
            if(!addedItem.sweetness ==="Normal"){
              name += ' (' + addedItem.sweetness +' )';
              console.log(name);
            }
          }
          if(addedItem.topping && addedItem.topping.id !== 1){
            console.log(addedItem);
            name += ' (' + addedItem.topping.toppingType +' )';
            newPrice += addedItem.topping.price;
          }
          var item = state.cart.find(item => item.name === name);
          if(!item){

            var copyItem = Object.assign({}, addedItem);
            copyItem.name = name;
            copyItem.quantity=1;
            copyItem.sumPrice = newPrice;
            state.cart.push(copyItem);
          }
          else{
            item.quantity++;
            item.sumPrice+=newPrice;
          }
          state.cartQuantity++;
          state.totalPrice += addedItem.price;
        },

        removeItem(state, removedItem){
          
          var item = state.cart.find(item => item.name === removedItem.name);
          if(item){
            if(item.quantity===1){
              var index = state.cart.indexOf(item);       
              state.cart.splice(index,1);
            }
            else if(item.quantity>1){
              item.quantity--;
              item.sumPrice-=removedItem.price;
            }
          }
          else{
            console.log("Error in remove function");
          }
          
          
          state.cartQuantity--;
          state.totalPrice-=item.price;

        
        },
        resetCart(state){
          state.cart = [];
          state.cartQuantity=0;
          state.totalPrice=0;
        },

        authUser(state, data){
          state.user.email = data.email;
          state.user.userType = data.userType;
        },
        logout(state){
          state.user.email = "";
          state.user.userType ="";
        }
      },
});
