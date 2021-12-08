<template>
  <div id="app">
    
    <header>
      <!-- Header is in App because it will always display even if router view changes -->
      <router-link class="brew-font-lg"  id="siteName" :to="{ name: 'home' }">Brews N' Buds</router-link>
      <div class="userButton">
        <logout-logo v-if="isLoggedIn" @click.native="toLogout"/>
        <user-button v-else @click.native="toLogin"/>
      </div>
    </header>

    <body>
      <router-view />
    </body>

  </div>
  <!--  Commenting out so we can build the site more to our needs
    <div id="nav">
      <router-link v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
    </div>
    -->
</template>

<script>
import UserButton from "@/components/UserButton.vue";
import LogoutLogo from "@/assets/SVG/LogoutLogo.vue"

export default {
  components: {
    UserButton,
    LogoutLogo
  },
  computed: {
    isLoggedIn: function() {
      return !(this.$store.state.token == '');
    }

  },

  methods: {
    toLogin(){
      this.$router.push({name: 'login'});
    },
    toLogout(){
      this.$router.push({name: 'logout'});
    }
  }
};
</script>

<style>
@import url("https://fonts.googleapis.com/css2?family=Fredoka+One&display=swap");

* {
  margin: 0;
  padding: 0;
}

#app {
  height: 100%;
  display: grid;
  grid-template-rows: 80px 91vh;
}

header {
  background-color: #2f3353;
  display: grid;
  grid-template-columns: 0.5fr 1fr 1fr 0.5fr;
  grid-template-areas: ". siteName userProfile .";
}

#siteName {
  grid-area: siteName;
  color: #fffefc;
  justify-self: start;
  align-self: center;
}

.userButton {
  grid-area: userProfile;
  justify-self: end;
  align-self: center;
  height: auto;
  width: 55px;
}

body {
  background-color: #fcf7e1;
}

.brew-font-lg{
  font-family: "Fredoka One", sans-serif;
  font-weight: normal;
  font-size: 32px;
  text-decoration: none;
}

.brew-font-sm{
  font-family: "Fredoka One", sans-serif;
  font-weight: 100;
  font-size: 18px;
}

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

.form-title{
  color: #fffefc;
}
</style>