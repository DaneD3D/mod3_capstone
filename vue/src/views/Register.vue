<template>
  <div id="register" class="text-center">
    <form class="form-user" @submit.prevent="register">
      <h1 class="brew-font-lg form-title">Create Account</h1>
      <div class="alert alert-danger" role="alert" v-if="registrationErrors">
        {{ registrationErrorMsg }}
      </div>

      <label for="username" class="sr-only brew-font-sm">Username</label>
      <input
        type="text"
        id="username"
        class="form-control"
        placeholder="Username"
        v-model="user.username"
        required
        autofocus
      />

      <label for="password" class="sr-only brew-font-sm">Password</label>

      <input
        type="password"
        id="password"
        class="form-control"
        placeholder="Password"
        v-model="user.password"
        required
      />
      <input
        type="password"
        id="confirmPassword"
        class="form-control"
        placeholder="Confirm Password"
        v-model="user.confirmPassword"
        required
      />

      <router-link :to="{ name: 'login' }" class="brew-font-sm"
        >Already have an Account?</router-link
      >
      <button class="btn btn-lg btn-primary btn-block" type="submit">
        Create Account
      </button>
    </form>
  </div>
</template>

<script>
import authService from "../services/AuthService";

export default {
  name: "register",
  data() {
    return {
      user: {
        username: "",
        password: "",
        confirmPassword: "",
        role: "user",
      },
      registrationErrors: false,
      registrationErrorMsg: "There were problems registering this user.",
    };
  },
  methods: {
    register() {
      if (this.user.password != this.user.confirmPassword) {
        this.registrationErrors = true;
        this.registrationErrorMsg = "Password & Confirm Password do not match.";
      } else {
        authService
          .register(this.user)
          .then((response) => {
            if (response.status == 201) {
              this.$router.push({
                path: "/login",
                query: { registration: "success" },
              });
            }
          })
          .catch((error) => {
            const response = error.response;
            this.registrationErrors = true;
            if (response.status === 400) {
              this.registrationErrorMsg = "Bad Request: Validation Errors";
            }
          });
      }
    },
    clearErrors() {
      this.registrationErrors = false;
      this.registrationErrorMsg = "There were problems registering this user.";
    },
  },
  computed: {},
};
</script>

<style scoped>
.form-user {
  display: flex;
  gap: 10px;
  margin-top: 15vh;
  margin-left: 35vw;
  margin-right: 35vw;
  padding: 40px;
  justify-content: center;
  flex-direction: column;
  border-radius: 10px;
  background-color: #F9A333;
  border-style: solid;
  border-color: #2f3353;
  border-width: .5em;
}

input {
  justify-content: center;
  border-radius: 10px;
  padding: 12px 20px;
}
</style>
