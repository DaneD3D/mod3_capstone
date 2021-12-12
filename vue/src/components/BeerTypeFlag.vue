<template>
  <div id="beerTypeFlag">
    <img id="beerMug" src="@/assets/1x/BeerMug.png" alt="beer-mug" />
    <div id="innerBox">
      <h1 class="brew-font-sm beer-type-font">{{ beerType }}</h1>
    </div>
  </div>
</template>

<script>
export default {
  name: "beer-type-flag",
  props: ["beerType"],
};
</script>

<style>
#beerTypeFlag {
  display: flex;
  justify-content: center;
  align-items: center;
  background-color: #f9a333;
  border-style: solid;
  border-color: #2f3353;
  width: 135px;
  height: 58px;
  border-radius: 10px;
}

#innerBox {
  display: flex;
  justify-content: center;
  align-items: center;
  background-color: #fffefc;
  border-color: #2f3353;
  height: 44px;
  width: 85px;
  border-style: solid;
  border-radius: 10px;
}

#beerMug {
  height: 60%;
  width: auto;
  margin-right: 5px;
}

@media only screen and (max-width: 768px) {
  #beerTypeFlag {
    width: 125px;
    height: 45px;
  }
  #innerBox {
    height: 35px;
    width: 78px;
  }
  #beerMug {
    height: 55%;
  }
}
</style>