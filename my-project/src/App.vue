<template>
  <SearchMember />
</template>

<script>
// import CreateMember from "@/components/CreateMember.vue";
import SearchMember from "@/components/SearchMember.vue";
// import RouterView from "vue-router";
// import UpdateMember from "@/components/UpdateMember.vue";

export default {
  name: 'App',
  components: {
    // CreateMember,
    SearchMember,
    // UpdateMember,
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
