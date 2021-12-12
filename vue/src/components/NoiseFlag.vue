<template>
  <div v-on:click="changeAmount" class="noiseFlag">
    <h2 class="brew-font-sm">Noise</h2>
    <music-note v-for="index in noiseLevel" :key="index" class="toggleImage"></music-note>
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
      noiseLevel: 1,
    };
  },
  methods: {
    changeAmount() {
      if (this.noiseLevel == 3) {
        this.noiseLevel = 1;
      } else this.noiseLevel++;
    },
  },
};
</script>

<style>
.noiseFlag {
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