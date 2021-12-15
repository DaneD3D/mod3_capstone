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
          :key="`noise${index}`"
        />
        <dollar-sign
          id="moneyDisplay"
          v-for="index in brewery.cost_rating"
          :key="`money${index}`"
        />
      </div>
      <dir id="webLink">
        <a
          v-if="this.brewery.website_url != null"
          id="brewLink"
          class="brew-font-sm-wht"
          :href="`${this.brewery.website_url}`"
          >{{ this.brewery.brewery_name }}.com</a
        >
      </dir>
    </div>

    <div id="barBody" class="bodyObject">
      <div id="adminBreweryOptions" v-if="isAdmin">
        <button id="editButton" @click="flipEdit">EDIT</button>
        <button id="deleteButton" @click="deleteBrewery">DELETE</button>
      </div>
      <ol id="breweryInformation">
        <li class="infoItem">
          {{ this.brewery.opening_time }} - {{ this.brewery.closing_time }}
        </li>
        <br />
        <li class="infoItem">{{ this.brewery.brewery_type }} Brewery</li>
        <br />
        <li class="infoItem">{{ this.brewery.brewery_desc }}</li>
        <br />
        <li class="infoItem">{{ this.brewery.phone }}</li>
        <br />
        <li class="infoItem">{{ this.brewery.country }}</li>
        <li class="infoItem">{{ this.brewery.state }}</li>
        <li class="infoItem">
          {{ this.brewery.city }} {{ this.brewery.postal_code }}
        </li>
      </ol>
    </div>

    <div id="barMenu" class="bodyObject">
      <form
        v-if="editMode"
        v-on:submit.prevent="updateBrewery"
        id="breweryForm"
      >
        <label for="brewName">Brewery Name</label>
        <input
          type="text"
          name="brewName"
          id=""
          v-model="currentBrewery.brewery_name"
        />
        <label for="brewType">Type of Brewery:</label>
        <input
          type="text"
          name="brewType"
          id=""
          v-model="currentBrewery.brewery_type"
        />
        <label for="street">Street</label>
        <input
          type="text"
          name="street"
          id=""
          v-model="currentBrewery.street"
        />
        <label for="city">City</label>
        <input type="text" name="city" id="" v-model="currentBrewery.city" />
        <label for="state">State</label>
        <input type="text" name="state" id="" v-model="currentBrewery.state" />
        <label for="postalCode">Postal Code</label>
        <input
          type="text"
          name="postalCode"
          id=""
          v-model="currentBrewery.postal_code"
        />
        <label for="phone">Phone</label>
        <input type="text" name="phone" id="" v-model="currentBrewery.phone" />
        <label for="country">Country</label>
        <input
          type="text"
          name="country"
          id=""
          v-model="currentBrewery.country"
        />
        <label for="imageUrl">Image URL</label>
        <input
          type="text"
          name="imageUrl"
          id=""
          v-model="currentBrewery.image_url"
        />
        <label for="brewDesc">Brewery Description</label>
        <input
          type="text"
          name="brewDesc"
          id=""
          v-model="currentBrewery.brewery_desc"
        />
        <label for="threeWord">Three Word Description</label>
        <input
          type="text"
          name="threeWord"
          id=""
          v-model="currentBrewery.three_word_desc"
        />
        <label for="openTime">Opens At</label>
        <input
          type="time"
          name="openTime"
          id=""
          v-model="currentBrewery.openingTime"
        />
        <label for="closeTime">Closes At</label>
        <input
          type="time"
          name="closeTime"
          id=""
          v-model="currentBrewery.closing_time"
        />
        <input type="submit" />
      </form>
      <ul v-else>
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

import BreweryService from "@/services/BreweryService.js";

export default {
  name: "brewery-detail",
  data() {
    return {
      currentBrewery: {},

      errorMsg: "",

      editMode: false,
    };
  },
  components: {
    MusicNote,
    DollarSign,
  },
  mounted() {
    this.$store.commit("SET_ACTIVE_BREWERY", this.$route.params.id);
    this.currentBrewery = this.$store.state.activeBrewery;
  },
  computed: {
    brewery() {
      return this.$store.state.breweryList.find(
        (bar) => bar.bb_brewery_id == this.$route.params.id
      );
    },
    isAdmin() {
      return this.$store.state.user.authorities[0].name == "ROLE_ADMIN";
    },
  },
  methods: {
    flipEdit() {
      this.editMode = !this.editMode;
    },
    updateBrewery() {
      this.flipEdit();
      BreweryService.updateBrewery(this.currentBrewery)
        .then((response) => {
          if (response.status === 200) {
            location.reload();
          }
        })
        .catch((error) => {
          if (error.response) {
            this.errorMsg =
              "Error Updating Brewery. Response received was '" +
              error.response.statusText +
              "'.";
          } else if (error.request) {
            this.errorMsg =
              "Error Updating Brewery. Server could not be reached.";
          } else {
            this.errorMsg =
              "Error updating Brewery. Request could not be created.";
          }
        });
    },
    deleteBrewery() {
      BreweryService.deleteBrewery(this.currentBrewery.bb_brewery_id)
        .then((response) => {
          if (response.status === 200) {
            this.getBreweries();
            this.$router.push("home");
          }
        })
        .catch((error) => {
          if (error.response) {
            this.errorMsg =
              "Error deleting Brewery. Response received was '" +
              error.response.statusText +
              "'.";
          } else if (error.request) {
            this.errorMsg =
              "Error deleting Brewery. Server could not be reached.";
          } else {
            this.errorMsg =
              "Error deleting Brewery. Request could not be created.";
          }
        });
    },
    getBreweries() {
      BreweryService.list().then((response) => {
        this.$store.commit("SET_BREWERIES", response.data);
      });
    },
  },
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
    ". body menu menu ."
    ". body menu menu ."
    ". social social social .";
  gap: 13px;
  margin-top: 20px;
  margin-left: 25px;
  margin-right: 25px;
}

#breweryInformation {
  font-family: "Source Sans Pro", sans-serif;
  font-weight: 100;
  font-size: 26px;
  color: #fffefc;
}

.infoItem {
  margin-top: 5px;
  margin-bottom: 5px;
}

#barHead {
  display: grid;
  grid-template-columns: 5fr 2fr;
  grid-template-rows: 1fr 0.5fr 0.2fr;
  grid-template-areas:
    "title ."
    "rating ."
    "link .";
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

#noiseMoney {
  grid-area: rating;
}

#moneyDisplay {
  height: 50px;
}

#noiseDisplay {
  height: 50px;
}

#headSplash {
  width: auto;
  grid-area: head;
}

#webLink {
  grid-area: link;
  margin-top: 5px;
}

#brewLink {
  font-family: "Fredoka One", sans-serif;
  font-weight: 100;
  font-size: 24px;
  color: #2f3353;
}

#barTitle {
  grid-area: title;
  font-family: "Fredoka One", sans-serif;
  font-weight: 100;
  font-size: 74px;
  color: #fffefc;
  -webkit-text-stroke-width: 4px;
  -webkit-text-stroke-color: #2f3353;
}

#barBody {
  grid-area: body;
  background-color: #2f3353;
}

#editInfoForm {
  grid-area: menu;
}

#barMenu {
  grid-area: menu;
  background-color: cadetblue;
}

#breweryForm {
  display: flex;
  flex-direction: column;
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