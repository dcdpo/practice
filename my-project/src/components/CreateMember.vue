<template>
  <h1>新增功能</h1>
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
  <button
      type="button"
      class="btn btn-primary"
      @click="cleanData"
  >
    清除
  </button>
  <button
    type="button"
    class="btn btn-primary"
    @click="createData"
  >
      儲存
    </button>
</template>

<script setup>
import {reactive} from "vue";
import axios from 'axios';
import response from "core-js/internals/is-forced";
import {useRouter} from "vue-router";

const router = useRouter();

const createForm = reactive({
  identity: '',
  blank: '',
  input01: '',
  input02: '',
  input03: '',
  input04: '',
  input05: '',
  input06: '',
  input07: '',
})

function createData(){
    let id = String(createForm.input01);
    let name = String(createForm.input02);
    let gender = String(createForm.input03);
    let subject = String(createForm.input04);
    let jobTitle = String(createForm.input05);
    let classes = String(createForm.input06);
    let admissionYearMonth = String(createForm.input07);

    if(createForm.input01 == ''){
      window.alert("id要填!!")
      return;
    } else if (createForm.identity == ''){
      window.alert("職業要選!!")
      return;
    }
    else if(id !== null && createForm.identity !== null) {
        axios
            .post('http://localhost:8081/create',
                {
                  "id": id,
                  "name": name,
                  "gender": gender,
                  "subject": subject,
                  "jobTitle": jobTitle,
                  "classes": classes,
                  "admissionYearMonth": admissionYearMonth
                }
                )
            .then(function (response) {
              window.alert(response.data);
              if (response.data === "新增成功"){
               router.push("/");
                }
            })
    }else {
      window.alert(response.data);
    }
  }

function cleanData() {
  createForm.genre = '';
  createForm.blank = '';
  createForm.identity = '';
  createForm.input01 = '';
  createForm.input02 = '';
  createForm.input03 = '';
  createForm.input04 = '';
  createForm.input05 = '';
  createForm.input06 = '';
  createForm.input07 = '';
}
</script>

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