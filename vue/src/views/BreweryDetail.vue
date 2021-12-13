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
      <button id="editButton" @click="flipEdit">EDIT</button>
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
        <input type="text" name="brewName" id="" v-model.lazy="brewery_name" />
        <label for="brewType">Type of Brewery:</label>
        <input type="text" name="brewType" id="" v-model.lazy="brewery_type" />
        <label for="street">Street</label>
        <input type="text" name="street" id="" v-model.lazy="street" />
        <label for="city">City</label>
        <input type="text" name="city" id="" v-model.lazy="city" />
        <label for="state">State</label>
        <input type="text" name="state" id="" v-model.lazy="state" />
        <label for="postalCode">Postal Code</label>
        <input type="text" name="postalCode" id="" v-model.lazy="postal_code" />
        <label for="phone">Phone</label>
        <input type="text" name="phone" id="" v-model.lazy="phone" />
        <label for="country">Country</label>
        <input type="text" name="country" id="" v-model.lazy="country" />
        <label for="imageUrl">Image URL</label>
        <input type="text" name="imageUrl" id="" v-model.lazy="imageUrl" />
        <label for="brewDesc">Brewery Description</label>
        <input type="text" name="brewDesc" id="" v-model.lazy="brewery_desc" />
        <label for="threeWord">Three Word Description</label>
        <input
          type="text"
          name="threeWord"
          id=""
          v-model.lazy="three_word_desc"
        />
        <label for="openTime">Opens At</label>
        <input type="time" name="openTime" id="" v-model.lazy="openingTime" />
        <label for="closeTime">Closes At</label>
        <input type="time" name="closeTime" id="" v-model.lazy="closing_time" />
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
      brewery_name: "",
      brewery_type: "",
      street: "",
      city: "",
      state: "",
      postal_code: "",
      phone: "",
      country: "",
      imageUrl: "",
      brewery_desc: "",
      openingTime: 0,
      closing_time: 0,
      three_word_desc: "",

      errorMsg: "",

      editMode: false,
    };
  },
  components: {
    MusicNote,
    DollarSign,
  },
  created() {
    const activeBreweryId = this.$route.params.id;
    this.$store.commit("SET_ACTIVE_BREWERY", activeBreweryId);
    this.currentBrewery = this.$store.state.activeBrewery;
    this.fillDefaultValues();
  },
  computed: {
    brewery() {
      return this.$store.state.breweryList.find(
        (bar) => bar.bb_brewery_id == this.$route.params.id
      );
    },
  },
  methods: {
    flipEdit() {
      this.editMode = !this.editMode;
    },
    fillDefaultValues() {
      this.brewery_name = this.brewery.brewery_name;
      this.brewery_type = this.brewery.brewery_type;
      this.street = this.brewery.street;
      this.city = this.brewery.city;
      this.state = this.brewery.state;
      this.postal_code = this.brewery.postal_code;
      this.phone = this.brewery.phone;
      this.country = this.brewery.country;
      this.imageUrl = this.brewery.image_url;
      this.brewery_desc = this.brewery.brewery_desc;
      this.openingTime = this.brewery.opening_time;
      this.closing_time = this.brewery.closing_time;
      this.three_word_desc = this.brewery.three_word_Desc;
    },
    updateBrewery() {
      function createUpdatedBrewery() {
        const updateBrewery = {
          brewery_desc: this.brewery_desc,
          brewery_name: this.brewery_name,
          brewery_type: this.brewery_type,
          city: this.city,
          closing_time: this.closing_time,
          country: this.country,
          imageUrl: this.imageUrl,
          openingTime: this.openingTime,
          phone: this.phone,
          postal_code: this.postal_code,
          state: this.state,
          street: this.street,
          three_word_desc: this.three_word_desc,
          address_2: this.brewery.address_2,
          address_3: this.brewery.address_3,
          bb_brewery_id: this.brewery.bb_brewery_id,
          brewery_id: this.brewery.brewery_id,
          cost_rating: this.brewery.cost_rating,
          county_province: this.brewery.county_province,
          latitude: this.brewery.latitude,
          longitude: this.brewery.longitude,
          noise_rating: this.brewery.noise_rating,
          tags: this.brewery.tags,
          website_url: this.brewery.website_url,
        };
        return updateBrewery;
      }
      this.flipEdit();
      BreweryService.updateBrewery(createUpdatedBrewery)
        .then((response) => {
          if (response.status === 200) {
            alert("Brewery Updated");
            location.reload();
          }
        })
        .carch((error) => {
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