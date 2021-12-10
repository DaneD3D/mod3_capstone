<template>
  <div id="brewCardTable">
    <brewery-card
      v-for="brewery, index in breweryShortList"
      v-bind:key="brewery.name"
      :brewery="brewery"
      :index="index"
    />
  </div>
</template>

<script>
import BreweryCard from "@/components/BreweryCard.vue";

import BreweryService from "@/services/BreweryService.js";

export default {
  name: "brew-card-display",
  data() {
    return {
      goof: 5
    }
  },
  components: {
    BreweryCard,
  },
  methods: {
    getBreweries() {
      BreweryService.list().then((response) => {
        this.$store.commit("SET_BREWERIES", response.data);
      });
    },
  },
  computed: {
    breweryShortList() {
      return this.$store.state.breweryList.slice(0,6);
    }

  },
  created() {
    this.getBreweries();
  },
};
</script>

<style>
#brewCardTable {
  display: flex;
  flex-direction: row;
  flex-wrap: wrap;
  justify-content: center;
  align-items: stretch;
  gap: 10px;
}
</style>