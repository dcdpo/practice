<template>
  <CreateMember/>
</template>

<script>
import CreateMember from "@/components/CreateMember.vue";

export default {
  name: 'App',
  components: {
    CreateMember,
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
