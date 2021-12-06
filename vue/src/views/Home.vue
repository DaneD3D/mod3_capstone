<template>
  <div class="home">
    <div class="beerFlags">
      <beer-type-flag v-for="beerType in this.$store.state.beerType" v-bind:key="beerType" v-bind="beerType"></beer-type-flag>
    </div>
  </div>
</template>

<script>
import BeerTypeFlag from '@/components/BeerTypeFlag.vue'

export default {
  name: "home",
  components:{
    BeerTypeFlag
  }
};
</script>

<style>

.home{
  display: grid;
  grid-template-rows: 1fr 1fr 6fr;
  padding: .5em;
}

.beerFlags{
  display: flex;
  flex-direction: row;
  align-content: center;
  justify-content: space-around;
}

</style>
