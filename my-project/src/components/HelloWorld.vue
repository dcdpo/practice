<template>
  <h1>查詢功能</h1>
  <div class="input-item">
    <label class="form-label" for="input01">
      學號
    </label>
    <input
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
    >
      <option selected>
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
      type="button"
      class="btn btn-primary"
  >
    清除
  </button>
  <button
      type="button"
      class="btn btn-primary"
      @click="myFunction()"
  >
    查詢
  </button>
  <br><br><br><br><br>
  <table style="margin-left: auto;margin-right: auto;">
    <thead>
    <tr>
      <th v-for="header in headers" :key="header.text">
        {{header.text}}
      </th>
    </tr>
    </thead>
    <tbody>
    <tr v-for="member in searchForm.memberList" :key="member.id">
      <td>
        {{member.id}}
      </td>
      <td>
        {{member.name}}
      </td>
      <td>
        {{member.gender}}
      </td>
      <td>
        {{member.subject}}
      </td>
      <td>
        {{member.jobTitle}}
      </td>
      <td>
        {{member.class}}
      </td>
      <td>
        {{member.admissionYearMonth}}
      </td>
    </tr>
    </tbody>
  </table>

</template>

<script setup>
import {reactive} from "vue";

const headers = [
  { text: "學號"},
  { text: "姓名"},
  { text: "性別"},
  { text: "科目"},
  { text: "職位"},
  { text: "班級"},
  { text: "入學年度"},
];

const searchForm = reactive({
    memberList: [
      {id: 1, name: 'Billy', gender: 'male', subject: '數學', jobTitle: '教務主任'},
      {id: 2, name: 'Heidi', gender: 'female', subject: '英文', jobTitle: '教師'},
      {id: 3, name: 'Jacky', gender: 'male', class: 301, admissionYearMonth: 201910},
      {id: 4, name: 'Lawrence', gender: 'male', class: 801, admissionYearMonth: 201812}
    ]
})

function myFunction() {
  let data = document.getElementById('input01').value;
  console.log("data = ",data)
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
