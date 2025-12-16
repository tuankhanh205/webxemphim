<template>
  <div class=" w-screen h-screen flex">
    <!-- Sidebar đỏ chứa hình tròn ở trên -->
    <div class="w-50 h-screen bg-red-600 flex flex-col">
      <div class="admin h-38">
         <img src="/src/assets/tải xuống (13).jpg" alt="" class="w-50 h-28" >
      </div>
      <div class="nut pl-2 ">
        <RouterButton/>
      </div>
     
      <!-- Bạn có thể thêm các item khác dưới đây -->
    </div>

    <!-- Main Content -->
    <main class="flex-1">
      <!-- Nội dung main ở đây -->
       <RouterView/>
    </main>
  </div>
</template>
<script setup lang="ts">
    import { useRoute } from 'vue-router';
    const route=useRoute()
    import RouterButton from '../../components/admin/RouterButton.vue';
    

</script>
