import axios from "axios";
import type { CategoryRequest,CategoryResponse } from "../types/Category";
const apiAdmin=axios.create({
    baseURL:"http://localhost:8080/admin/category"
})
apiAdmin.interceptors.request.use(config => {
  const token = sessionStorage.getItem("token");
  if (token) {
    config.headers.Authorization = `Bearer ${token}`;
  }
  return config;
});
const CategoryService={
    getAll:async():Promise<CategoryResponse>=>{
        const response=await apiAdmin.get(``)
        return response.data
    }
}
export default CategoryService