<template>
  <h1>修改功能</h1>
  <nav>
    <RouterLink to="/">查詢功能</RouterLink>
    <RouterLink to="/CreateMember">新增功能</RouterLink>
  </nav>
  <div class="input-item">
    <label class="form-label" for="input01">
      <span style="color: red">*</span>
      學號
    </label>
    <input
        id="input01"
        class="form-control"
        type="text"
        name="text"
        required
        v-model="createForm.input01"
    />
    <br>
    <label class="form-label" for="input02">
      姓名
    </label>
    <input
        id="input02"
        class="form-control"
        type="text"
        name="text"
        required
        v-model="createForm.input02"
    />
    <br>
    <label class="form-label" for="input03">
      性別
    </label>
    <input
        id="input03"
        class="form-control"
        type="text"
        name="text"
        required
        v-model="createForm.input03"
    />
    <br>
    <label class="form-label" for="input01">
      職業
    </label>
    <select
        class="form-select"
        aria-label="select"
        v-model="createForm.identity"
    >
      <option selected value="">
        無
      </option>
      <option selected value="teacher">
        老師
      </option>
      <option value="student">
        學生
      </option>
    </select>
    <br>
    <label class="form-label" for="input04" v-show="createForm.identity == 'teacher'">
      科目
    </label>
    <input
        id="input04"
        class="form-control"
        type="text"
        name="text"
        required
        v-show="createForm.identity == 'teacher'"
        v-model="createForm.input04"
    />
    <br v-show="createForm.identity == 'teacher'">
    <label class="form-label" for="input05" v-show="createForm.identity == 'teacher'">
      職位
    </label>
    <input
        id="input05"
        class="form-control"
        type="text"
        name="text"
        required
        v-show="createForm.identity == 'teacher'"
        v-model="createForm.input05"
    />
    <br v-show="createForm.identity == 'teacher'">
    <label class="form-label" for="input06" v-if="createForm.identity == 'student'">
      班級
    </label>
    <input
        id="input06"
        class="form-control"
        type="text"
        name="text"
        required
        v-show="createForm.identity == 'student'"
        v-model="createForm.input06"
    />
    <br v-show="createForm.identity == 'student'">
    <label class="form-label" for="input07" v-show="createForm.identity == 'student'">
      入學年度
    </label>
    <input
        id="input07"
        class="form-control"
        type="text"
        name="text"
        required
        v-show="createForm.identity == 'student'"
        v-model="createForm.input07"
    />
  </div>
  <br>
  <RouterLink :to="{name: 'SearchMember'}"
              custom v-slot="{ navigate }">
    <button @click="navigate" role="link">
      回上一頁
    </button>
  </RouterLink>
  <RouterLink :to="{name: 'SearchMember'}">
    <button @click="updateData">
      儲存
    </button>
  </RouterLink>
</template>

<script setup>
import {reactive} from "vue";
import {useRoute} from "vue-router"
import axios from "axios";

const route = useRoute();

const createForm = reactive({
  identity: genre(),
  input01: route.query.id,
  input02: route.query.name,
  input03: route.query.gender,
  input04: route.query.subject,
  input05: route.query.jobTitle,
  input06: route.query.class,
  input07: route.query.admissionYearMonth,
})

function genre() {
  if (route.query.subject != null) {
    return 'teacher';
  } else if (route.query.subject == null) {
    return 'student';
  }
}

function updateData() {
  let id = String(createForm.input01);
  let name = String(createForm.input02);
  let gender = String(createForm.input03);
  let subject = String(createForm.input04);
  let jobTitle = String(createForm.input05);
  let classes = String(createForm.input06);
  let admissionYearMonth = String(createForm.input07);

  if (createForm.input01 == '') {
    window.alert("id要填!!")
    return;
  } else if (createForm.identity == '') {
    window.alert("職業要選!!")
    return;
  } else if (createForm.identity == 'teacher') {
    axios
        .put('http://localhost:8081/update/' + id,
            {
              "id": id,
              "name": name,
              "gender": gender,
              "subject": subject,
              "jobTitle": jobTitle,
              "classes": null,
              "admissionYearMonth": null
            }
        )
        .then(function (response) {
          window.alert(response.data);
        })
  } else if (createForm.identity == 'student') {
    axios
        .put('http://localhost:8081/update/' + id,
            {
              "id": id,
              "name": name,
              "gender": gender,
              "subject": null,
              "jobTitle": null,
              "classes": classes,
              "admissionYearMonth": admissionYearMonth
            }
        )
        .then(function (response) {
          window.alert(response.data);
        })
  }

}
</script>

<style scoped>
h3 {
  margin: 40px 0 0;
}

nav > a {
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