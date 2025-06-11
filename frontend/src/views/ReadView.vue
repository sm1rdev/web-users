<script setup lang="ts">
import {ref} from "vue";
import axios from "axios";

const id = ref<number>();
const user = ref<any>();

async function getUserById() {
  try {
    const response = await axios.get(`http://localhost:8080/api/users/${id.value}`);
    user.value = await response.data;
  } catch (error) {
    console.error(error);
  }
}

</script>

<template>
  <div class="header">GET USER BY ID</div>
  <div class="content">
    <input v-model="id" type="number">
    <button @click="getUserById">GET</button>
  </div>
  <div v-if="user" class="user">
    <div>Name: {{ user.name }}</div>
    <div>Email: {{ user.email }}</div>
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
  gap: 10px;
}
.user {
  text-align: center;
  font-size: 36px;
}
</style>