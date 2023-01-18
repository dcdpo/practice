import { createRouter, createWebHistory } from 'vue-router';
import UpdateMember from "../components/UpdateMember.vue";
import SearchMember from "../components/SearchMember.vue";

const router = createRouter({
    history: createWebHistory(),
    routes: [
        {
            path: "/",
            name: "SearchMember",
            component: () => import("../components/SearchMember.vue"),
        },
        {
            path: '/UpdateMember',
            name: "UpdateMember",
            component: () => import("../components/UpdateMember.vue"),
        },
    ],
});

export default router;