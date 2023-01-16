<template>
  <SearchMember/>
</template>

<script>
// import CreateMember from "@/components/CreateMember.vue";
import  SearchMember from "@/components/SearchMember.vue"

export default {
  name: 'App',
  components: {
    SearchMember,
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
