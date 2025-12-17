import { createRouter, createWebHistory } from "vue-router";
import MainFrame from "../layout/admin/MainFrame.vue";
import HelloWorld from "../components/HelloWorld.vue";
import Movie from "../view/admin/movie/Movie.vue";
import Category from "../view/admin/Category.vue";
import MovieAdd from "../view/admin/movie/MovieAdd.vue";

const routes = [
  {
    path: '/',
    component: MainFrame,  // Layout chính
    children: [
      { path: '', name: 'home', component: HelloWorld },   // Route mặc định
      { path: 'movie', name: 'movie', component: Movie }, 
      { path: 'movieadd', name: 'movieadd', component: MovieAdd },  // Route /movie
      { path: 'category', name: 'danhmuc', component: Category },   // Route /movie
      // Có thể thêm các route khác ở đây
    ]
  }
];

const router = createRouter({
  history: createWebHistory(),
  routes
});

export default router;
