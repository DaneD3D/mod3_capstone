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
      <input
        type="text"
        class="brew-font-sm"
        name="brewerySearch"
        id="searchField"
        placeholder="Search by Name..."
      />
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
  gap: 15px;
  grid-template-rows: 65px 55px 6fr;
  grid-template-columns: auto;
  grid-template-areas:
    "beers"
    "toggles"
    "beerCards";
  margin-top: 15px;
  margin-left: 25px;
  margin-right: 25px;
}

#beerFlagContainer {
  display: flex;
  margin-left: 6.5vw;
  margin-right: 6.5vw;
  flex-direction: row;
  align-items: center;
  justify-content: space-between;
  gap: 10px;
  grid-area: beers;
}

#toggleFlags {
  display: flex;
  margin-left: 6.5vw;
  margin-right: 6.5vw;
  flex-direction: row;
  align-items: center;
  justify-content: space-between;
  gap: 10px;
  grid-area: toggles;
}

#searchField {
  height: 55px;
  width: 70%;
  border-style: solid;
  border-color: #2f3353;
  border-radius: 10px;
  padding-left: 25px;
  border-width: 0.2em;
  grid-area: toggles;
}



@media only screen and (max-width: 768px) {
  .home {
    background-color: black;
    grid-template-rows: 130px 55px 55px 6fr;
    grid-template-areas:
      "beers"
      "toggles"
      "search"
      "beerCards";
  }

  
  #toggleFlags {
    flex-wrap: wrap;
  }

  #searchField {
    width: 60vw;
    min-width: 10%;
    grid-area: search;
  }

  #beerFlagContainer {
    align-items: flex-start;
    flex-wrap: wrap;
    gap: 5px;
  }
}
</style>
