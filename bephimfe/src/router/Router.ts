import { createRouter, createWebHistory } from "vue-router";
import MainFrame from "../layout/admin/MainFrame.vue";
import HelloWorld from "../components/HelloWorld.vue";
import Movie from "../layout/admin/Movie.vue";

const routes = [
  {
    path: '/',
    component: MainFrame,  // Layout chính
    children: [
      { path: '', name: 'home', component: HelloWorld },   // Route mặc định
      { path: 'movie', name: 'movie', component: Movie },   // Route /movie
      // Có thể thêm các route khác ở đây
    ]
  }
];

const router = createRouter({
  history: createWebHistory(),
  routes
});

export default router;
