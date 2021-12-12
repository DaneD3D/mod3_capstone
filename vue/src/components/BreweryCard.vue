<template>
  <div
    class="breweryCard"
    :style="{ backgroundImage: `url(${brewery.image_url})` }"
  >
  <h1>{{brewery.noise_rating}}</h1>
  <h1>{{brewery.cost_rating}}</h1>
    <div id="cardOverlay"></div>
    <div id="cardContent">
      <h2 id="barName" class="brew-font-sm-wht">{{ brewery.brewery_name }}</h2>
      <p id="barDescription" class="brew-font-sm-wht">{{brewery.brewery_desc}}</p>
    </div>
  </div>
</template>

<script>
export default {
  name: "brewery-card",
  props: ["brewery"],
  data() {
    return {};
  },
};
</script>

<style>
.breweryCard {
  background-color: #f9a333;
  width: 400px;
  height: 300px;
  border-radius: 10px;
  background-size: cover;
  background-position: center;
  border: solid;
  border-color: #2f3353;
  border-width: 5px;
}

.card-font-lg {
  font-family: "Fredoka One", sans-serif;
  font-weight: lighter;
  font-size: 12px;
  text-decoration: none;
}

.barPhoto {
  object-fit: cover;
  width: 31vw;
  height: 350px;
  border-radius: 10px;
}

#barDescription {
  position: relative;
  top: 14px;
  font-size: 16px;
  padding: 2px;

}

#cardOverlay {
  position: relative;
  top: 100%;
  transform: translateY(-98%);
  width: 100%;
  height: 125px;
  border-radius: 0px 0px 10px 10px;
  background: #2f3353;
  backdrop-filter: blur(10px);
  opacity: 0.8;
}

#cardContent {
  position: relative;
  top: 51px;
  left: 4px;
}

#barName {
  position: relative;
  transform: translate(2px, 10px);
}

@media only screen and (max-width: 1319px) {
  .breweryCard {
    width: 350px;
    height: 280px;
  }
}
</style>