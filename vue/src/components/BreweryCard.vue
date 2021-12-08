<template>
  <div class="breweryCard">
    <h1>{{this.$attrs.name}}</h1>
  </div>
</template>

<script>


export default {
    name: 'brewery-card',
    props: ['brewery']
}
</script>

<style>
.breweryCard{
  background-color: rgb(169, 131, 201);
}

</style>