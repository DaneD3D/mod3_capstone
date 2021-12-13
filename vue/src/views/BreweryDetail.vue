<template>
  <div id="breweryDetail">
    <div
      id="headSplash"
      :style="{ backgroundImage: `url(${brewery.image_url})` }"
      class="bodyObject"
    ></div>
    <div id="barHead" class="bodyObject">
      <h1 id="barTitle">{{ this.brewery.brewery_name }}</h1>
      <div id="noiseMoney">
        <music-note
            id="noiseDisplay"
            v-for="index in brewery.noise_rating"
            :key="index"
          />
          <dollar-sign
            id="moneyDisplay"
            v-for="index in brewery.cost_rating"
            :key="index"
          />
      </div>
    </div>

    <div id="barBody" class="bodyObject">
      <button id="editButton" @click="flipEdit">EDIT</button>
      <p>{{brewery.opening_time}}</p>
    </div>
    <div id="barMenu" class="bodyObject">
      <ul>
        <li>Beer 1</li>
        <li>Beer 2</li>
      </ul>
    </div>
    <div id="barSocial" class="bodyObject">
      <p>Comments!</p>
    </div>
  </div>
</template>

<script>
import MusicNote from "@/assets/SVG/MusicNote.vue";
import DollarSign from "@/assets/SVG/DollarSign.vue";

export default {
  name: "brewery-detail",
  data() {
    return {
      currentBrewery: {},
      brewery_name: '',
      brewery_type: '',
      street: '',
      city: '',
      state: '',
      postal_code: '',
      phone: '',
      country: '',
      image_url: '',
      brewery_desc: '',
      openingTime: 0,
      closing_time: 0,
      three_word_desc: '',

      editMode: false
    }
  },
  components: {
    MusicNote,
    DollarSign
  },
  created() {
    const activeBreweryId = this.$route.params.id;
    this.$store.commit("SET_ACTIVE_BREWERY", activeBreweryId);
    this.currentBrewery = this.$store.state.activeBrewery;
  },
  computed: {
    brewery() {
      return this.$store.state.breweryList.find(
        (bar) => bar.bb_brewery_id == this.$route.params.id
      );
    },
  },
  method: {
    flipEdit() {
      !this.editMode
    }
  }
};
</script>

<style>
#breweryDetail {
  display: grid;
  height: 87vh;
  grid-template-columns: 1fr 3fr 3fr 3fr 1fr;
  grid-template-rows: 1fr 2fr 2fr 1fr;
  grid-template-areas:
    ". head head head ."
    ". body beer menu ."
    ". body beer menu ."
    ". social social social .";
  gap: 13px;
  margin-top: 20px;
  margin-left: 25px;
  margin-right: 25px;
}

#barHead {
  width: auto;
  grid-area: head;
  background: rgb(249, 163, 51);
  background: linear-gradient(
    90deg,
    rgba(249, 163, 51, 1) 0%,
    rgba(249, 163, 51, 1) 59%,
    rgba(249, 163, 51, 0) 85%
  );
}

#moneyDisplay{
  height: 50px;
}

#noiseDisplay{
  height: 50px;
}

#headSplash {
  width: auto;
  grid-area: head;
}

#barTitle {
  font-family: "Fredoka One", sans-serif;
  font-weight: 100;
  font-size: 74px;
  color: #FFFEFC;
  -webkit-text-stroke-width: 4px;
  -webkit-text-stroke-color: #2f3353;
}

#barBody {
  grid-area: body;
  background-color: brown;
}

#barMenu {
  grid-area: menu;
  background-color: cadetblue;
}

#barSocial {
  grid-area: social;
  background-color: blueviolet;
}

.bodyObject {
  border-radius: 15px;
  padding: 15px;
}
</style>