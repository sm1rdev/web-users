<script setup lang="ts">
import {ref} from 'vue';
import axios from "axios";

const userData = ref({
      name: "",
      email: ""
});

async function createUser() {
  try {
    const response = await axios.post("http://localhost:8080/api/users", userData.value);
  } catch (error) {
    console.error(error);
  }
}

</script>

<template>
  <div class="header">CREATE USER</div>
  <div class="content">
    <form class="user-form" @submit.prevent="createUser">
      <label for="name">Name:</label>
      <input v-model="userData.name" type="text">
      <label for="email">Email:</label>
      <input v-model="userData.email" type="email">
      <button type="submit">CREATE</button>
    </form>
  </div>
</template>

<style scoped>
.header{
  width: 100%;
  text-align: center;
  font-size: 36px;
  font-weight: bold;
}
.content {
  display: flex;
  flex-direction: column;
  align-items: center;
}
.user-form {
  display: flex;
  flex-direction: column;
  gap: 10px;
}
</style>