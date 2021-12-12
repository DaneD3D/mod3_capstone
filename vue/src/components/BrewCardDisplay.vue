<template>
  <div id="brewCardPage">
    <arrow-symbol :click="pageRight" class="navArrow" id="leftArrow"></arrow-symbol>
    <arrow-symbol :click="pageLeft" class="navArrow" id="rightArrow"></arrow-symbol>
    <div id="brewCardTable">
      <brewery-card
        v-for="(brewery, index) in breweryShortList"
        :key="brewery.name"
        :brewery="brewery"
        :id="`brewCard${index}`"
      />
      
    </div>
  </div>
</template>

<script>
import BreweryCard from "@/components/BreweryCard.vue";
import ArrowSymbol from "@/assets/SVG/ArrowSymbol.vue";

import BreweryService from "@/services/BreweryService.js";

export default {
  name: "brew-card-display",
  data() {
    return {
      window: {
        width: 0,
        height: 0,
      },
      pageNumber: 1
    };
  },
  components: {
    BreweryCard,
    ArrowSymbol,
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
    pageRight() {

    }
  },
  computed: {
    breweryShortList() {
      return this.$store.getters.filteredList.slice(0, this.numOfCards);
    },
    numOfCards() {
      let vW = this.window.width - 50;
      let vH = (this.window.height / 100) * 90;

      if (vW < 1319) {
        return Math.round(vW / 360) * Math.round(vH / 290);
      } else
        return Math.floor(
          ((Math.round(vW / 420) * Math.round(vH / 300)) / 100) * 64
        );
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
#brewCardPage {
  justify-content: center;
  display: grid;
  grid-template-columns: 50px 90vw 50px;
  grid-template-areas: "arrowLeft brewCardDisplay arrowRight";
  
}

#leftArrow {
  grid-area: arrowLeft;
  align-self: center;
}

#rightArrow {
  grid-area: arrowRight;
  align-self: center;
}

.navArrow {
  height: 100px;
}

#brewCardTable {
  grid-area: brewCardDisplay;
  margin-top: 5px;
  margin-bottom: 5px;
  display: flex;
  flex-direction: row;
  flex-wrap: wrap;
  justify-content: center;
  align-items: center;
  gap: 15px;
}

@media only screen and (max-width: 768px) {
  #brewCardTable {
    justify-content: center;
    align-items: flex-start;
  }
}
</style>