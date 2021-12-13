<template>
  <div id="brewCardPage">
    <button id="leftButton" v-on:click="pageDown" v-if="this.pageNumber != 1" class="pageButton">
      <arrow-symbol
        class="navArrow"
        id="leftArrow"
        v-if="this.pageNumber != 1"
      />
    </button>
    <button id="rightButton" v-on:click="pageUp" class="pageButton">
      <arrow-symbol class="navArrow" id="rightArrow"/>
    </button>
    <div id="brewCardTable">
      <brewery-card
        v-for="(brewery, index) in arrayPage"
        :key="brewery.name"
        :brewery="brewery"
        :id="`brewCard${index}`"
      />
    </div>
    <h1 id="pageNum">Page: {{ this.pageNumber }}</h1>
  </div>
</template>

<script>
import BreweryCard from "@/components/BreweryCard.vue";
import ArrowSymbol from "@/assets/SVG/ArrowSymbol.vue";

export default {
  name: "brew-card-display",
  data() {
    return {
      window: {
        width: 0,
        height: 0,
      },
      pageNumber: 1,
    };
  },
  components: {
    BreweryCard,
    ArrowSymbol,
  },
  methods: {
    handleResize() {
      this.window.width = window.innerWidth;
      this.window.height = window.innerHeight;
    },
    pageUp() {
      this.pageNumber = this.pageNumber + 1;
    },
    pageDown() {
      if (this.page == 1) {
        this.pageNumber = 1;
      } else this.pageNumber = this.pageNumber - 1;
    },
  },
  computed: {
    arrayPage() {
      return this.$store.getters.filteredList.slice(
        (this.pageNumber - 1) * this.numOfCards,
        this.pageNumber * this.numOfCards
      );
    },
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

.pageButton {
  background: transparent;
  border: none;
  font-size: 0;
}

#leftArrow {
  transform: translateX(-18%);
  
  align-self: center;
}

#leftButton{
  grid-area: arrowLeft;
}

#rightButton{
  grid-area: arrowRight;
}

#rightArrow {
  
  align-self: center;
  transform: rotateZ(180deg);
}

a {
  text-decoration: none;
}

.navArrow {
  height: 100px;
}
#pageNum {
  grid-area: brewCardDisplay;
  position: absolute;
  top: 96.5%;
  left: 45%;
  font-family: "Fredoka One", sans-serif;
  font-weight: normal;
  font-size: 22px;
  text-decoration: none;
  color: #2f3353;
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