<template>
  <div class="p-6">
    <h2 class="text-2xl font-semibold mb-4">Danh sách phim</h2>

    <div class="overflow-x-auto">
      <table class="min-w-full border border-gray-200 rounded-lg">
        <thead class="bg-gray-100">
          <tr>
            <th class="px-4 py-2 border">ID</th>
            <th class="px-4 py-2 border">Tên phim</th>
            <th class="px-4 py-2 border">Mô tả</th>
            <th class="px-4 py-2 border">Số tập</th>
            <th class="px-4 py-2 border">Ngày đăng</th>
            <th class="px-4 py-2 border">Ngày sửa</th>
            <th class="px-4 py-2 border">Chức năng</th>
          </tr>
        </thead>

        <tbody>
          <tr
            v-for="movie in movieRes"
            :key="movie.id"
            class="hover:bg-gray-50"
          >
            <td class="px-4 py-2 border text-center">{{ movie.id }}</td>
            <td class="px-4 py-2 border">{{ movie.title }}</td>
            <td class="px-4 py-2 border">{{ movie.description }}</td>
            <td class="px-4 py-2 border text-center">{{ movie.totalEpisodes }}</td>
            <td class="px-4 py-2 border text-center">{{ movie.createDate }}</td>
            <td class="px-4 py-2 border text-center">{{ movie.updateDate }}</td>
            <td class="px-4 py-2 border text-center">
              <div class="flex gap-2">
  <button class="px-4 py-2 bg-green-600 text-white rounded-lg hover:bg-green-700 transition"> Thêm</button> 
<button class="px-4 py-2 bg-blue-600 text-white rounded-lg hover:bg-blue-700 transition" > Sửa</button>
</div>

            </td>
          </tr>
        </tbody>
      </table>
    </div>
  </div>
</template>
<script setup lang="ts">
import { ref, onMounted } from 'vue';
import type { MovieRespose } from '../../types/Moive';
import MovieService from '../../service/MovieService';
const movieRes = ref < MovieRespose[] > ([])
const getall = async () => {
    const data = await MovieService.getAllMovie();
    if (Array.isArray(data)) {
        movieRes.value = data
        console.log(data)
    }
    else {
        movieRes.value = [data]
    }
}
onMounted(() => {
    getall()
})
</script>