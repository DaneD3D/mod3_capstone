<template>
  <div id="app">
    <header>
      <!-- Header is in App because it will always display even if router view changes -->
      <h1 id="siteName">Brews N' Buds</h1>
      <user-button id="userButton"></user-button>
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

export default {
  components: {
    UserButton,
  },
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
  grid-template-rows: 8vh 92vh;
}

header {
  background-color: #2f3353;
  display: grid;
  grid-template-columns: 0.5fr 1fr 1fr 0.5fr;
  grid-template-areas: ". siteName userProfile .";
}

#siteName {
  grid-area: siteName;
  font-family: "Fredoka One", sans-serif;
  color: #fffefc;
  font-size: 4.7vh;
  justify-self: start;
  align-self: center;
  font-weight: normal;
}

#userButton {
  grid-area: userProfile;
  justify-self: end;
  align-self: center;
  height: auto;
  width: 55px;
}

body {
  background-color: #fcf7e1;
}
</style>