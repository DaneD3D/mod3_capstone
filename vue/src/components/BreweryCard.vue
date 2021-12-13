<template>
  <router-link
    v-bind:to="{
      name: 'brewery-detail',
      params: { id: brewery.bb_brewery_id },
    }"
  >
    <div
      class="breweryCard"
      :style="{ backgroundImage: `url(${brewery.image_url})` }"
    >
      <div id="cardTop">
        <div id="topLeft">
          <music-note
            id="noiseDisplay"
            v-for="index in brewery.noise_rating"
            :key="index"
          />
        </div>
        <div id="topRight">
          <dollar-sign
            id="moneyDisplay"
            v-for="index in brewery.cost_rating"
            :key="index"
          />
        </div>
      </div>
      <div id="cardBot">
        <h2 id="barName" class="brew-font-sm-wht">
          {{ breweryNameShort }}
        </h2>
        <p id="barDescription" class="brew-font-sm-wht">
          {{ brewery.brewery_desc }}
        </p>
      </div>
    </div>
  </router-link>
</template>

<script>
import MusicNote from "@/assets/SVG/MusicNote.vue";
import DollarSign from "@/assets/SVG/DollarSign.vue";

export default {
  name: "brewery-card",
  props: ["brewery"],
  components: {
    MusicNote,
    DollarSign,
  },
  data() {
    return {};
  },
  computed: {
    breweryNameShort() {
      let newString = `${this.brewery.brewery_name}`;
      return newString.slice(0, 24);
    },
  },
};
</script>

<style>
.breweryCard {
  background-color: #f9a333;
  width: 400px;
  height: 285px;
  border-radius: 10px;
  background-size: cover;
  background-position: center;
  border: solid;
  border-color: #2f3353;
  border-width: 5px;
  display: grid;
  grid-auto-rows: 1fr 1fr;
  grid-template-areas:
    "top"
    "bot";
}

#cardTop {
  grid-area: top;
  display: grid;
  grid-template-columns: 1fr 1fr;
  grid-template-columns: "topLeft topRight";
  padding: 6px;
}

#noiseDisplay {
  width: 9%;
  height: auto;
  grid-area: topLeft;
}

#moneyDisplay {
  width: 9%;
  height: auto;
  grid-area: topRight;
}

#topLeft {
  display: flex;
  flex-direction: row;
  align-items: flex-start;
}

#topRight {
  display: flex;
  flex-direction: row-reverse;
  align-items: flex-start;
}

#cardBot {
  grid-area: bot;
  width: 101%;
  background-color: #2f3353;
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

#barName {
  position: relative;
  transform: translate(7px, 7px);
}

@media only screen and (max-width: 1319px) {
  .breweryCard {
    width: 350px;
    height: 280px;
  }
}
</style>