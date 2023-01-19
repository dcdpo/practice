<template>
  <h1>查詢功能</h1>
  <nav>
    <RouterLink to="/">查詢功能</RouterLink>
    <RouterLink to="/CreateMember">新增功能</RouterLink>
  </nav>
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
  <div v-if="memberList.length > 0">
    <table style="margin-left: auto;margin-right: auto;">
      <thead>
      <tr>
        <th v-for="header in searchForm.headers" :key="header.text">
          {{ header.text }}
        </th>
      </tr>
      </thead>
      <tbody>
      <tr v-for="(member, key) in memberList" :key="key">
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
          有
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
        <RouterLink :to="{name: 'UpdateMember',
                          query: {id: member.id, name: member.name,
                                  gender: member.gender, subject: member.subject,
                                  jobTitle: member.jobTitle, class: member.class,
                                  admissionYearMonth: member.admissionYearMonth}}"
                    custom v-slot="{ navigate }">
          <button @click="navigate" role="link">
            修改
          </button>
        </RouterLink>
      </tr>
      </tbody>
    </table>
  </div>
  <div v-else-if="message.length > 0">
    {{ message[0] }}
  </div>
</template>

<script setup>
import {reactive, ref} from "vue";
import axios from 'axios';
import {RouterLink, useRouter} from "vue-router";

const router = useRouter();

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
  ]
})
let memberList = ref([]);
let message = ref([]);

function getDataBySearch() {
  let blank = searchForm.blank;
  memberList.value.length = 0;

  if (blank > 0) {
    if (searchForm.genre == 'student') {
      console.log()
      axios
          .get('http://localhost:8081/rest/student?id=' + blank).then(({data}) => {
        if (typeof data != "string") {
          memberList.value.push(data);
        } else {
          message.value.push(data);
        }
      })
    } else if (searchForm.genre == 'teacher') {
      axios
          .get('http://localhost:8081/rest/teacher?id=' + blank).then(({data}) => {
        if (typeof data != "string") {
          memberList.value.push(data);
        } else {
          message.value.push(data);
        }
      })
    } else {
      axios
          .get('http://localhost:8081/rest/all/' + blank).then(({data}) => {
        if (typeof data != "string") {
          memberList.value.push(data);
        } else {
          message.value.push(data);
        }
      })
    }
  } else if (blank == '') {
    if (searchForm.genre == 'student') {
      axios
          .get('http://localhost:8081/rest/all-student').then(({data}) => {
        for (let i = 0; i < data.length; i++)
          memberList.value.push(data[i]);
      })
    } else if (searchForm.genre == 'teacher') {
      axios
          .get('http://localhost:8081/rest/all-teacher').then(({data}) => {
        for (let i = 0; i < data.length; i++)
          memberList.value.push(data[i]);
      })
    } else {
      axios
          .get('http://localhost:8081/rest/all').then(({data}) => {
        for (let i = 0; i < data.length; i++)
          memberList.value.push(data[i]);
      })
    }
  }
}

function deleteData(id, member) {

  if (confirm('確定要刪除嗎?') == true) {
    axios
        .delete('http://localhost:8081/delete/'+id)
        .then(function (response) {
          window.alert(response.data);
        })
  } else {
    return;
  }
  router.go(0)
}

function cleanData() {
  searchForm.genre = '';
  memberList.value.length = 0;
  searchForm.blank = '';
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h3 {
  margin: 40px 0 0;
}

nav > a{
  margin: 0 10px;
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
