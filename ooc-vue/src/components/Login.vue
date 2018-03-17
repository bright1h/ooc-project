<template>
  <div class="login">
      <div class="row">
        <div class="col-md mt-2 mx-3">
            <form>
              <div class="form-row">
                <div class="form-group col-md">
                  <input type="text" class="form-control" placeholder="Email or Phone Number">
                </div>
              </div>
              <div class="form-row">
                <div class="form-group col-md">
                  <input type="password" class="form-control" placeholder="Password">
                </div>
              </div>

              <div class="form-footer ">
                <div class="row">
                        <div class="col-md">
                            <div class="d-flex">
                                <div class="pt-1">
                                  <button type="button" class="btn btn-primary">Login</button>
                                </div>
                                <div class="pt-2 pl-3">
                                    <a href="#" class="text-primary">Forget password ?</a>
                                </div>
                            </div>
                        </div>
                    </div>
              </div>
            </form>
        </div>
      </div>
    </div>
</template>

<script>

  export default {
    name: "Login",
  };
</script>

<style scoped>
</style>

