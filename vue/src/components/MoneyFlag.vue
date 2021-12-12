<template>
  <div v-on:click="changeAmount" class="moneyFlag">
    <h2 class="brew-font-sm">Cost</h2>
    <dollar-sign v-for="index in moneyLevel" :key="index" class="toggleImage"></dollar-sign>
  </div>
</template>

<script>
import DollarSign from "@/assets/SVG/DollarSign.vue";

export default {
  components: {
    DollarSign,
  },
  name: "money-flag",
  data() {
    return {
      moneyLevel: 1,
    };
  },
  methods: {
    changeAmount() {
      if (this.moneyLevel == 3) {
        this.moneyLevel = 1;
      } else this.moneyLevel++;
    },
  },
};
</script>

<style>
.moneyFlag {
  display: flex;
  justify-content: space-around;
  align-items: center;
  background-color: #FFFEFC;
  border-style: solid;
  border-color: #2F3353;
  border-radius: 10px;
  width: 10%;
  height: 55px;
  padding-left: 5px;
  padding-right: 5px;
}

.toggleImage{
  height: 28px;
  width: auto;
}
</style>