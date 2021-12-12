<template>
  <main id="app">
    <header>
      <!-- Header is in App because it will always display even if router view changes -->
      <router-link class="brew-font-lg" id="siteName" :to="{ name: 'home' }"
        >Brews N' Buds</router-link
      >
      <div class="userButton">
        <logout-logo v-if="isLoggedIn" @click.native="toLogout" />
        <user-button v-else @click.native="toLogin" />
      </div>
    </header>

    <body>
      <router-view />
    </body>
  </main>
</template>

<script>
import UserButton from "@/components/UserButton.vue";
import LogoutLogo from "@/assets/SVG/LogoutLogo.vue";

export default {
  components: {
    UserButton,
    LogoutLogo,
  },
  computed: {
    isLoggedIn: function () {
      return !(this.$store.state.token == "");
    },
  },

  methods: {
    toLogin() {
      this.$router.push({ name: "login" });
    },
    toLogout() {
      this.$router.push({ name: "logout" });
    },
  },
};
</script>

<style>
@import url("https://fonts.googleapis.com/css2?family=Fredoka+One&display=swap");

/* http://meyerweb.com/eric/tools/css/reset/ 
   v2.0 | 20110126
   License: none (public domain)
*/

html, body, div, span, applet, object, iframe,
h1, h2, h3, h4, h5, h6, p, blockquote, pre,
a, abbr, acronym, address, big, cite, code,
del, dfn, em, img, ins, kbd, q, s, samp,
small, strike, strong, sub, sup, tt, var,
b, u, i, center,
dl, dt, dd, ol, ul, li,
fieldset, form, label, legend,
table, caption, tbody, tfoot, thead, tr, th, td,
article, aside, canvas, details, embed, 
figure, figcaption, footer, header, hgroup, 
menu, nav, output, ruby, section, summary,
time, mark, audio, video {
	margin: 0;
	padding: 0;
	font-size: 100%;
	font: inherit;
	vertical-align: baseline;
}
/* HTML5 display-role reset for older browsers */
article, aside, details, figcaption, figure, 
footer, header, hgroup, menu, nav, section {
	display: block;
}
body {
	line-height: 1;
}
ol, ul {
	list-style: none;
}
blockquote, q {
	quotes: none;
}
blockquote:before, blockquote:after,
q:before, q:after {
	content: '';
	content: none;
}
table {
	border-collapse: collapse;
	border-spacing: 0;
}

* {
  margin: 0;
  padding: 0;
}

#app {
  display: grid;
  grid-template-rows: 8% 92%;
  grid-template-areas: 
    "siteTop"
    "siteBody";
  position: absolute;
  width: 100%;
  height: 100%;
  left: 0;
  top: 0;
}

header {
  grid-area: siteTop;
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
  grid-area: siteBody;
  background-color: #fcf7e1;
  height: 100%;
}

.brew-font-lg {
  font-family: "Fredoka One", sans-serif;
  font-weight: normal;
  font-size: 32px;
  text-decoration: none;
}

.brew-font-sm {
  font-family: "Fredoka One", sans-serif;
  font-weight: 100;
  font-size: 18px;
  color: #2f3353;
}

.brew-font-sm-wht {
  font-family: "Fredoka One", sans-serif;
  font-weight: 100;
  font-size: 24px;
  color: #fffefc;
}

.form-title {
  color: #fffefc;
}

@media only screen and (max-width: 1200px) {
}
</style>