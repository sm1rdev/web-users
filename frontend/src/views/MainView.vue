<script setup lang="ts">
import {ref, onMounted} from "vue";
import { useRouter } from "vue-router";
import axios from "axios";

const router = useRouter();

const users = ref<any[]>([]);

async function loadUsers() {
  try {
    const response = await axios.get("http://localhost:8080/api/users");
    users.value = await response.data;
    console.log(response.data);
  } catch (error) {
    console.error(error);
  }
}

const goToCreate = () => {
  router.push("/create");
}
const goToRead = () => {
  router.push("/read");
}
const goToUpdate = () => {
  router.push("/update");
}
const goToDelete = () => {
  router.push("/delete");
}

onMounted(() => {
  loadUsers();
})

</script>

<template>
  <div class="header">SIMPLE CRUD APP</div>
  <div class="content">
    <div class="crud-buttons">
      <button @click="goToCreate">CREATE</button>
      <button @click="goToRead">READ</button>
      <button @click="goToUpdate">UPDATE</button>
      <button @click="goToDelete">DELETE</button>
    </div>
    <h4>All users:</h4>
    <div class="users-list">
      <div v-for="user in users" class="user-container">
        <div class="user-id">#{{ user.id }}</div>
        <div class="user-name">{{ user.name }}</div>
      </div>
    </div>
  </div>
</template>

<style scoped>
.header{
  width: 100%;
  text-align: center;
  font-size: 36px;
  font-weight: bold;
}
.crud-buttons{
  margin: 20px;
  display: flex;
  justify-content: center;
  gap: 10px;
}
h4 {
  text-align: center;
}
.content {
  display: flex;
  flex-direction: column;
  align-items: center;
}
.users-list {
  width: 30%;
}
.user-container {
  display: flex;
  gap: 10px;
  margin: 10px;
}
.user-id {
  background-color: #7354be;
  padding: 5px;
}
.user-name {
  align-content: center;
}
</style>
