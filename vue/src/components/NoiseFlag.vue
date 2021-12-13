<template>
  <div v-on:click="changeAmount" class="noiseFlag">
    <h2 class="brew-font-sm">Noise</h2>
    <music-note
      v-for="index in noiseLevel"
      :key="index"
      class="toggleImage"
    ></music-note>
  </div>
</template>

<script>
import MusicNote from "@/assets/SVG/MusicNote.vue";

export default {
  components: {
    MusicNote,
  },
  name: "noise-flag",
  data() {
    return {
      noiseLevel: 0,
    };
  },
  methods: {
    changeAmount() {
      this.$store.commit("INCREMENT_NOISE_LEVEL");
      this.noiseLevel = this.$store.state.noiseLevel;
    },
  },
};
</script>

<style>
.noiseFlag {
  display: flex;
  justify-content: space-around;
  align-items: center;
  background-color: #fffefc;
  border-style: solid;
  border-color: #2f3353;
  border-radius: 10px;
  width: 10%;
  height: 55px;
  padding-left: 5px;
  padding-right: 5px;
}

.toggleImage {
  height: 28px;
  width: auto;
}
</style>