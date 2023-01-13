<template>
  <h1>查詢功能</h1>
  <div class="input-item">
    <label class="form-label" for="input01">
      學號
    </label>
    <input
        v-model="searchForm.blank"
        id="input01"
        class="form-control"
        type="text"
        name="text"
        required
    />
    <br>
    <label class="form-label" for="input01">
      職位
    </label>
    <select
        class="form-select"
        aria-label="select"
        v-model="searchForm.genre"
    >
      <option selected value="">
        無
      </option>
      <option value="teacher">
        老師
      </option>
      <option value="student">
        學生
      </option>
    </select>
  </div>
  <br>
  <button
      type="reset"
      class="btn btn-primary"
      @click="cleanData()"
  >
    清除
  </button>
  <button
      type="reset"
      class="btn btn-primary"
      @click="getDataBySearch"
  >
    查詢
  </button>
  <br><br><br><br><br>
    <div v-if="testList.length > 0">
      <table style="margin-left: auto;margin-right: auto;">
        <thead>
        <tr>
          <th v-for="header in searchForm.headers" :key="header.text">
            {{ header.text }}
          </th>
        </tr>
        </thead>
        <tbody>
        <tr v-for="(member, key) in testList" :key="key">
          <td>
            {{ member.id }}
          </td>
          <td>
            {{ member.name }}
          </td>
          <td>
            {{ member.gender }}
          </td>
          <td v-if="member.subject != null">
            {{ member.subject }}
          </td>
          <td v-else>
            無
          </td>
          <td v-if="member.jobTitle != null">
            {{ member.jobTitle }}
          </td>
          <td v-else>
            無
          </td>
          <td v-if="member.class != null">
            {{ member.class }}
          </td>
          <td v-else>
            無
          </td>
          <td v-if="member.admissionYearMonth != null">
            {{ member.admissionYearMonth }}
          </td>
          <td v-else>
            無
          </td>
          <button
              type="button"
              class="btn btn-primary"
              @click="deleteData(member.id)"
          >
            清除
          </button>
        </tr>
        </tbody>
      </table>
    </div>
    <div v-else></div>
</template>

<script setup>
import {reactive, ref} from "vue";
import axios from 'axios';

const searchForm = reactive({
  blank: '',
  genre: '',
  headers: [
    {text: "學號"},
    {text: "姓名"},
    {text: "性別"},
    {text: "科目"},
    {text: "職位"},
    {text: "班級"},
    {text: "入學年度"},
  ],
  memberList: [
  ]
})
let testList = ref([]);

function getDataBySearch() {
  // let data = searchForm.blank;
  testList.value.length = 0;

      for (let i = 0; i < searchForm.memberList.length; i++)
        testList.value.push(searchForm.memberList[i]);
}
axios
    .get('http://localhost:8081/rest/all').then(({ data }) => {
      searchForm.memberList = data;
})


function deleteData(id){
  console.log("id=", id)
}

function cleanData() {
  searchForm.genre = '';
  testList.value.length = 0;
  searchForm.blank = '';
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h3 {
  margin: 40px 0 0;
}

ul {
  list-style-type: none;
  padding: 0;
}

li {
  display: inline-block;
  margin: 0 10px;
}

a {
  color: #42b983;
}
</style>
