<template>
  <h1>修改功能</h1>
  <nav>
    <RouterLink to="/">查詢功能</RouterLink>
    <RouterLink to="/CreateMember">新增功能</RouterLink>
  </nav>
  <div class="input-item">
    <label class="form-label" for="id">
      <span style="color: red">*</span>
      學號
    </label>
    <input
        id="id"
        class="form-control"
        type="text"
        name="text"
        required
        v-model="createForm.id"
        disabled
    />
    <br>
    <label class="form-label" for="name">
      姓名
    </label>
    <input
        id="name"
        class="form-control"
        type="text"
        name="text"
        required
        v-model="createForm.name"
    />
    <br>
    <label class="form-label" for="gender">
      性別
    </label>
    <input
        id="gender"
        class="form-control"
        type="text"
        name="text"
        required
        v-model="createForm.gender"
    />
    <br>
    <label class="form-label" for="id">
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
    <label class="form-label" for="subject" v-show="createForm.identity == 'teacher'">
      科目
    </label>
    <input
        id="subject"
        class="form-control"
        type="text"
        name="text"
        required
        v-show="createForm.identity == 'teacher'"
        v-model="createForm.subject"
    />
    <br v-show="createForm.identity == 'teacher'">
    <label class="form-label" for="jobTitle" v-show="createForm.identity == 'teacher'">
      職位
    </label>
    <input
        id="jobTitle"
        class="form-control"
        type="text"
        name="text"
        required
        v-show="createForm.identity == 'teacher'"
        v-model="createForm.jobTitle"
    />
    <br v-show="createForm.identity == 'teacher'">
    <label class="form-label" for="classes" v-if="createForm.identity == 'student'">
      班級
    </label>
    <input
        id="classes"
        class="form-control"
        type="text"
        name="text"
        required
        v-show="createForm.identity == 'student'"
        v-model="createForm.classes"
    />
    <br v-show="createForm.identity == 'student'">
    <label class="form-label" for="admissionYearMonth" v-show="createForm.identity == 'student'">
      入學年度
    </label>
    <input
        id="admissionYearMonth"
        class="form-control"
        type="text"
        name="text"
        required
        v-show="createForm.identity == 'student'"
        v-model="createForm.admissionYearMonth"
    />
  </div>
  <br>
  <RouterLink :to="{name: 'SearchMember'}"
              custom v-slot="{ navigate }">
    <button @click="navigate" role="link">
      回上一頁
    </button>
  </RouterLink>
  <button
      type="button"
      class="btn btn-primary"
      @click="updateData"
  >
    儲存
  </button>
</template>

<script setup>
import {reactive} from "vue";
import {useRoute, useRouter} from "vue-router"
import axios from "axios";

const route = useRoute();
const router = useRouter();

const createForm = reactive({
  identity: genre(),
  id: route.query.id,
  name: route.query.name,
  gender: route.query.gender,
  subject: route.query.subject,
  jobTitle: route.query.jobTitle,
  classes: route.query.classes,
  admissionYearMonth: route.query.admissionYearMonth,
})

function genre() {
  if (route.query.subject != null) {
    return 'teacher';
  } else if (route.query.subject == null) {
    return 'student';
  }
}

function updateData() {
  let id = String(createForm.id);
  let name = String(createForm.name);
  let gender = String(createForm.gender);
  let subject = String(createForm.subject);
  let jobTitle = String(createForm.jobTitle);
  let classes = String(createForm.classes);
  let admissionYearMonth = String(createForm.admissionYearMonth);

  if (createForm.identity == '') {
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
          if (response.data === "更新成功") {
            router.push("/");
          }
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
          if (response.data === "更新成功") {
            router.push("/");
          }
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