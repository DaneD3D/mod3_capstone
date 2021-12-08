<template>
  <div id="brewCardTable">
    <brewery-card
      v-for="brewery in breweryShortList"
      v-bind:key="brewery.name"
      v-bind="brewery"
    />
    
  </div>
</template>

<script>
import BreweryCard from "@/components/BreweryCard.vue";

import BreweryService from "@/services/BreweryService.js";

export default {
  name: "brew-card-display",
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
  align-items: stretch;
  gap: 10px;
}
</style>