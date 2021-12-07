<template>
  <div id="beerTypeFlag">
      <img id="beerMug" src="@/assets/1x/BeerMug.png" alt="beer-mug">
      <div id="innerBox">

      </div>
  </div>
</template>

<script>
export default {
    name: 'beer-type-flag',
    props:[]

}
</script>

<style>
#beerTypeFlag{
    background-color: #F9A333;
    border-style: solid;
    border-color: #2F3353;
    width: 7.2em;
    height: 3.5em;
    border-radius: .7em;
    display: flex;
    align-content: center;
    justify-content: center;
}

#innerBox{
    background-color: #FFFEFC;
    border-color: #2F3353;
    height: 70%;
    width: 60px;
    border-style: solid;
}

#beerMug{
    height: 50%;
    width: auto;
}

</style>