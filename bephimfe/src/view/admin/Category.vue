<template> <div class="p-6">
    <h2 class="text-2xl font-semibold mb-4">Danh sách phim</h2>

    <div class="overflow-x-auto">
      <table class="min-w-full border border-gray-200 rounded-lg">
        <thead class="bg-gray-100">
          <tr>
            <th class="px-4 py-2 border">ID</th>
            <th class="px-4 py-2 border">Tên danh mục</th>
            <th class="px-4 py-2 border">Thao tác</th>
        
          </tr>
        </thead>

        <tbody>
          <tr
            v-for="cate in categoryRes "
            :key="cate.id"
            class="hover:bg-gray-50"
          >
            <td class="px-4 py-2 border text-center">{{ cate.id }}</td>
            <td class="px-4 py-2 border">{{ cate.name }}</td>
           
            <td class="px-4 py-2 border text-center">
              <div class="flex gap-2">
                <RouterLink to="/movieadd">
  <button class="px-4 py-2 bg-green-600 text-white rounded-lg hover:bg-green-700 transition"> Thêm</button> 
  </RouterLink>
<button class="px-4 py-2 bg-blue-600 text-white rounded-lg hover:bg-blue-700 transition" > Sửa</button>
</div>

            </td>
          </tr>
        </tbody>
      </table>
    </div>
  </div></template>
<script setup lang="ts">
    import type { CategoryResponse } from '../../types/Category';
    import CategoryService from '../../service/categoryService';
    import { ref,onMounted } from 'vue';
    const categoryRes=ref<CategoryResponse[]>([])
    const getAll=async()=>{
        const data=await CategoryService.getAll();
        if(Array.isArray(data)){
        categoryRes.value=data
        console.log(data)
        }
        else{
            categoryRes.value= [data]
             console.log(data)
        }

        
    }
    onMounted(()=>{
        getAll()
    })
</script>