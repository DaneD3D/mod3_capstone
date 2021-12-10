<template>
  <div class="breweryCard" :style="{backgroundImage:`url(${brewery.image_url})`}">
    <h1>{{ brewery.name }}</h1>
  </div>
</template>

<script>
export default {
  name: "brewery-card",
  props: ["brewery"],
  data() {
    return {
      
    };
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