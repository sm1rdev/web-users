<script setup lang="ts">
import {ref} from "vue";
import axios from "axios";

const id = ref<number>();

async function deleteUserById() {
  try {
    const response = await axios.delete(`http://localhost:8080/api/users/${id.value}`);
  } catch (error) {
    console.error(error);
  }
}

</script>

<template>
  <div class="header">DELETE USER</div>
  <div class="content">
    <input v-model="id" type="number">
    <button @click="deleteUserById">DELETE</button>
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
</style>