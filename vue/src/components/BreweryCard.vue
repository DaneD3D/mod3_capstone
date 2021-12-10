<template>
  <div class="breweryCard">
    <h1>{{ brewery.name }}</h1>
  </div>
</template>

<script>
export default {
  name: "brewery-card",
  props: ["brewery", "index"],
  data() {
    return {
      barPhoto: "https://tinyurl.com/yw39c6rn",
    };
  },
  computed: {
    randomImage: () =>{
      return 'background-image' + ':' + 'url("' + this.$store.state.tempPhotoList[this.index] + '")'
    }
  }
};
</script>

<style>
.breweryCard {
  background-color: #f9a333;
  width: 31vw;
  height: 350px;
  border-radius: 10px;
  background-size: cover;
  background-position: center;
}

.barPhoto {
  object-fit: cover;
  width: 31vw;
  height: 350px;
  border-radius: 10px;
}
</style>