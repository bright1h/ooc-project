<template>
  <div class="checkout">
    <Header/>
    <div class="container">
      <div class="row border-bottom py-3">
        <h1 class="text-dark ">Your Order</h1>
      </div>
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
  import TypeRadioBox from '../components/TypeRadioBox'
  import SweetnessRadioBox from '../components/SweetnessRadioBox'
  import ValueInputButton from '../components/ValueInputButton'
  import ToppingsDropDown from '../components/ToppingsDropDown'

  export default {
    name: 'CheckOut',
    components: {Header, Footer, TypeRadioBox, SweetnessRadioBox, ToppingsDropDown, ValueInputButton}
  }
</script>

<style scoped>
</style>
