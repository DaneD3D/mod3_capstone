<template>
  <div class="breweryCard">
    <img src="@/assets/barPhotos/3.png" alt="bar-photo"/>
    <h1>{{ this.$attrs.name }}</h1>
  </div>
</template>

<script>
export default {
  name: "brewery-card",
  data() {
    return {
      barPhoto: ''
    }
  },
  methods:{
    getImage() {
      this.barPhoto = '@/assets/barPhotos/3.png'
    }
  }
};
</script>

<style>
.breweryCard {
  background-color: #f9a333;
  width: 31vw;
  height: 350px;
}
</style>