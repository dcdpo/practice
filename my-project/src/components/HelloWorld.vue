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
      @click="getMemberById()"
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
      </tr>
    </tbody>
  </table>
  </div>
</template>

<script setup>

import {reactive, ref} from "vue";

const searchForm = reactive({
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
    {id: 1, name: 'Billy', gender: 'male', subject: '數學', jobTitle: '教務主任'},
    {id: 2, name: 'Heidi', gender: 'female', subject: '英文', jobTitle: '教師'},
    {id: 3, name: 'Jacky', gender: 'male', class: 301, admissionYearMonth: 201910},
    {id: 4, name: 'Lawrence', gender: 'male', class: 801, admissionYearMonth: 201812}
  ]
})

let testList = ref([]);

function getMemberById() {
  let data = document.getElementById('input01').value;
  if (data > 0) {
    testList.value.push(searchForm.memberList[data - 1]);
  }else{
    let i;
    for ( i = 0; i < searchForm.memberList.length; i++)
      testList.value.push(searchForm.memberList[i]);
  }
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
