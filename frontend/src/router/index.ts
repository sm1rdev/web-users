import {createRouter, createWebHistory} from "vue-router"
import type { RouteRecordRaw } from 'vue-router'
import MainView from "../views/MainView.vue";
import CreateView from "../views/CreateView.vue";
import ReadView from "../views/ReadView.vue";
import UpdateView from "../views/UpdateView.vue";
import DeleteView from "../views/DeleteView.vue";

const routes: Array<RouteRecordRaw> = [
    {
        path: '/',
        name: 'main',
        component: MainView
    },
    {
        path: '/create',
        name: 'create',
        component: CreateView
    },
    {
        path: '/read',
        name: 'read',
        component: ReadView
    },
    {
        path: '/update',
        name: 'update',
        component: UpdateView
    },
    {
        path: '/delete',
        name: 'delete',
        component: DeleteView
    },
]

const router = createRouter({
    history: createWebHistory(),
    routes: routes,
})

export default router