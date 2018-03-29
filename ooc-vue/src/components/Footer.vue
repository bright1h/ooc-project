<template>
  <div class='footer py-2'>
    <div class="container footer-bg text-center text-md-left text-light">

      <div class="row">

        <!--First column-->
        <div class="col-sm-6">
          <h5 class="text-uppercase">Brew & Bev</h5>
          <p>To be able to satisfy our valued customers in every possible way we can. We are here to make sure that the customers get what is feels like to be a customer, and we are here to ensure that our quality products and services will be delivered to our customers.</p>

        </div>
        <!--/.First column-->

        <!--Second column-->
        <div class="col-sm-6">
          <h5 class="text-uppercase">Contact Us</h5>

          <ul class="list-unstyled">
            <li class="">
              Phone Number : 02-441-0098
            </li>
            <li>

              Email : brewandbev.muic@gmail.com
            </li>
            <li>
              Open Time : 7:30 - 18:00
            </li>
            <li>
              Location : Mahidol University
            </li>
          </ul>
          <div class="icon-circle my-1 pb-1">
            <a href="https://www.facebook.com/brewnbev/" target="_blank" class="ifacebook" title="Facebook"><i class="fa fa-facebook"></i></a>
          </div>
          <!-- TODO Add Instagram icon http://instagram.com/brewnbev/ -->
          <!--<div class="icon-circle my-1 pb-1">-->
            <!--<a href="https://www.facebook.com/brewnbev/" target="_blank" title="Instagram"><i class="fa fa-facebook"></i></a>-->
          <!--</div>-->
        </div>
        <!--/.Second column-->

    </div>
   </div>
  <div class="footer-copyright-zone py-3 text-center text-light">
      © 2018 Copyright: Brew & Bev
  </div>
  </div>
</template>

<script>

  export default {
    name: 'Footer'
  }
</script>

<style>

@import url("//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css");
  .footer-copyright-zone {
    background-color: #13254f;
    height: 50px;
  }
  .footer {
    position: absolute;
    bottom: 0;
    left: 0;
    width: 100%;
    height: 210px;
    background-color: #0d47a1;
  }
  .footer-bg{
     background-color: #0d47a1;
  }
  .icon-circle .fa {
    font-size: 25px;
    margin: 0 auto;
    height: 50px;
    width: 50px;
    border-radius: 50%;
    line-height: 50px;
    cursor: pointer;
    -webkit-transition: all ease-in-out 0.35s;
    -moz-transition: all ease-in-out 0.35s;
    -o-transition: all ease-in-out 0.35s;
    -ms-transition: all ease-in-out 0.35s;
    transition: all ease-in-out 0.20s, background-color ease-in-out 0.05s;
  }
  .icon-circle .fa:hover {
    -moz-box-shadow: inset 0 0 0 5px #ffffff;
    -o-box-shadow: inset 0 0 0 5px #ffffff;
    -ms-box-shadow: inset 0 0 0 5px #ffffff;
    -webkit-box-shadow: inset 0 0 0 5px #ffffff;
    box-shadow: inset 0 0 0 3px #ffffff;
    -ms-transform: scale(1.2, 1.2);
    -webkit-transform: scale(1.2, 1.2);
    -moz-transform: scale(1.2, 1.2);
    -o-transform: scale(1.2, 1.2);
    transform: scale(1.2, 1.2);
  }
  .icon-circle i:before {
    margin-left: 0;
    font-size: 25px;
  }
  @media (min-width: 320px) and (max-width: 768px) {
    .icon-circle .fa {
      font-size: 10px;
      margin: 0 auto;
      height: 40px;
      width: 40px;
      border-radius: 50%;
      line-height: 40px;
      cursor: pointer;
      -webkit-transition: all ease-in-out 0.35s;
      -moz-transition: all ease-in-out 0.35s;
      -o-transition: all ease-in-out 0.35s;
      -ms-transition: all ease-in-out 0.35s;
      transition: all ease-in-out 0.20s, background-color ease-in-out 0.05s;
    }
    .icon-circle .fa:hover {
      color: #fff;
      -moz-box-shadow: inset 0 0 0 5px #ffffff;
      -o-box-shadow: inset 0 0 0 5px #ffffff;
      -ms-box-shadow: inset 0 0 0 5px #ffffff;
      -webkit-box-shadow: inset 0 0 0 5px #ffffff;
      box-shadow: inset 0 0 0 3px #ffffff;
      -ms-transform: scale(1.2, 1.2);
      -webkit-transform: scale(1.2, 1.2);
      -moz-transform: scale(1.2, 1.2);
      -o-transform: scale(1.2, 1.2);
      transform: scale(1.2, 1.2);
    }
    .icon-circle i:before {
      margin-left: 0;
      font-size: 20px;
    }
  }
  .ifacebook .fa {
    text-align: center;
    color: #3B5998;
    background-color: ghostwhite;
    border: 1px solid #3B5998;
  }
  .ifacebook .fa:hover {
    background-color: #3B5998;
    color: #fff;
    border: 1px solid #3B5998;
  }

</style>
