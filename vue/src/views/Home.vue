<template>
  <div class="home">
    <div class="beerFlags">
      <beer-type-flag v-for="beerType in this.$store.state.beerType" v-bind:key="beerType" v-bind="beerType"></beer-type-flag>
      <noise-flag></noise-flag>
      <money-flag></money-flag>
      <brewery-card v-for="brewery in this.$store.state.breweryList" v-bind:key="brewery"></brewery-card>
    </div>
  </div>
</template>

<script>
import BeerTypeFlag from '@/components/BeerTypeFlag.vue'
import NoiseFlag from '@/components/NoiseFlag.vue'
import MoneyFlag from '@/components/MoneyFlag.vue'
import BreweryCard from '@/components/BreweryCard.vue'

export default {
  name: "home",
  components:{
    BeerTypeFlag,
    NoiseFlag,
    MoneyFlag,
    BreweryCard
  }
};
</script>

<style>

.home{
  display: grid;
  grid-template-rows: 1fr 1fr 6fr;
  grid-template-areas: "beers searches breweries";
  padding: .5em;
}

.beerFlags{
  display: flex;
  flex-direction: row;
  align-content: center;
  justify-content: space-around;
  grid-area: "beers";
}

</style>
