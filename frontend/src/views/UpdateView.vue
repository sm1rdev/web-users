<script setup lang="ts">
import {ref} from "vue";
import axios from "axios";

const id = ref<any>();
const userData = ref({
  name: "",
  email: ""
})

async function updateUser() {
  try {
    const response = await axios.put(`http://localhost:8080/api/users/${id.value}`, userData.value);
  } catch (error) {
    console.error(error);
  }
}

</script>

<template>
  <div class="header">UPDATE USER</div>
  <div class="content">
    <form class="user-form" @submit.prevent="updateUser">
      <label for="name">Id:</label>
      <input v-model="id" type="number">
      <label for="name">Name:</label>
      <input v-model="userData.name" type="text">
      <label for="name">Email:</label>
      <input v-model="userData.email" type="email">
      <button type="submit">UPDATE</button>
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