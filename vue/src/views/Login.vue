<template>
  <div id="login" class="text-center">
    <form class="form-user" @submit.prevent="login">
      <h1 class="brew-font-lg form-title">Please Sign In</h1>
      <div class="input-pair">
        <div
          class="alert alert-danger"
          role="alert"
          v-if="invalidCredentials"
        >Invalid username and password!</div>
        <div
          class="alert alert-success"
          role="alert"
          v-if="this.$route.query.registration"
        >Thank you for registering, please sign in.</div>
      </div>
      <div class="input-pair">
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
      </div>
      <div class="input-pair">
        <label for="password" class="sr-only brew-font-sm">Password</label>
        <input
          type="password"
          id="password"
          class="form-control"
          placeholder="Password"
          v-model="user.password"
          required
        />
      </div>
      <router-link :to="{ name: 'register' }" class="brew-font-sm" id="registerLink">Need an account?</router-link>
      <button type="submit" id="submitButton">Sign in</button>
    </form>
  </div>
</template>

<script>
import authService from "../services/AuthService";

export default {
  name: "login",
  components: {},
  data() {
    return {
      user: {
        username: "",
        password: ""
      },
      invalidCredentials: false
    };
  },
  methods: {
    login() {
      authService
        .login(this.user)
        .then(response => {
          if (response.status == 200) {
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);
            this.$router.push("/");
          }
        })
        .catch(error => {
          const response = error.response;

          if (response.status === 401) {
            this.invalidCredentials = true;
          }
        });
    }
  }
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

.input-pair {
  display: flex;
  flex-direction: column;
}

input {
  justify-content: center;
  border-radius: 10px;
  padding: 12px 20px;
  font-size: 24px;
}

#submitButton {
  height: 40px;
  font-size: 26px;
  font-family: 'Source Sans Pro', sans-serif;
}

label{
  margin-bottom: 5px;
  font-size: 24px;
}

#registerLink{
  font-size: 24px;
}

</style>
