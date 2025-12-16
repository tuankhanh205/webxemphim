import axios from "axios";
import type { MovieRespose } from "../types/Moive";
const apiAdmin=axios.create({
    baseURL:"http://localhost:8080/admin/movie"
})
apiAdmin.interceptors.request.use(config => {
  const token = sessionStorage.getItem("token");
  if (token) {
    config.headers.Authorization = `Bearer ${token}`;
  }
  return config;
});
const MovieService={
  getAllMovie:async(): Promise<MovieRespose>=>{
    const response=await apiAdmin.get(`get_all`)
    return response.data
  }
}
export default MovieService