<template>
  <div id="brewCardTable">
    <brewery-card
      v-for="brewery in breweryShortList"
      v-bind:key="brewery.name"
      :brewery="brewery"
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
      window: {
        width: 0,
        height: 0,
      },
    };
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
    handleResize() {
      this.window.width = window.innerWidth;
      this.window.height = window.innerHeight;
    },
  },
  computed: {
    breweryShortList() {
      return this.$store.state.breweryList.slice(0, 6);
    },
  },
  created() {
    this.getBreweries();
    window.addEventListener("resize", this.handleResize);
    this.handleResize();
  },
  destroyed() {
    window.removeEventListener("resize", this.handleResize);
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