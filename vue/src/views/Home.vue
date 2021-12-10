<template>
  <div class="home">
    <div id="beerFlagContainer">
      <beer-type-flag
        v-for="beerType in this.$store.state.beerType"
        v-bind:key="beerType"
        :beerType="beerType"
      >
      </beer-type-flag>
    </div>
    <div id="toggleFlags">
      <noise-flag></noise-flag>
      <money-flag></money-flag>
      <input type="text" name="" id="">
    </div>
    <brew-card-display></brew-card-display>
  </div>
</template>

<script>

import BeerTypeFlag from "@/components/BeerTypeFlag.vue";
import NoiseFlag from "@/components/NoiseFlag.vue";
import MoneyFlag from "@/components/MoneyFlag.vue";
import BrewCardDisplay from "@/components/BrewCardDisplay.vue";

export default {
  name: "home",
  components: {
    BeerTypeFlag,
    NoiseFlag,
    MoneyFlag,
    BrewCardDisplay,
  },

};
</script>

<style>
.home {
  display: grid;
  grid-template-rows: 65px 55px 6fr;
  margin: 0.5em;
}

#beerFlagContainer {
  display: flex;
  flex-direction: row;
  align-items: center;
  justify-content: space-around;
  grid-area: "beers";
}

#toggleFlags{
  display: flex;
  flex-direction: row;
  align-items: center;
  justify-content: center;
}
</style>
