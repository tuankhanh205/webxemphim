<script lang="ts" setup>
import { ref } from 'vue'

interface MenuItem {
  label: string
  icon?: string
  to?: string
  items?: MenuItem[]
}

// Menu model
const model = ref<MenuItem[]>([
  {
    label: 'Trang Chủ',
    items: [
      { label: 'Thống Kê', icon: 'pi pi-fw pi-home', to: '/home' },
      { label: 'Movie', icon: 'pi pi-fw pi-video', to: '/movie' },
      { label: 'Danh mục', icon: 'pi pi-fw pi-video', to: '/category' }
    ]
  },
  {
    label: 'Quản Lý',
    items: [
      { label: 'Người Dùng', icon: 'pi pi-fw pi-user', to: '/users' },
      { label: 'Sản Phẩm', icon: 'pi pi-fw pi-box', to: '/products' }
    ]
  }
])
</script>
<template>
  <aside >
    <div v-for="group in model" :key="group.label">
      <h3 class="text-white font-bold mb-2">{{ group.label }}</h3>
      <div v-for="item in group.items" :key="item.label">
        <router-link
          :to="item.to as string"
          class="flex items-center gap-2 text-white px-2 py-1 rounded hover:bg-red-500"
        >
          <i :class="item.icon"></i>
          {{ item.label }}
        </router-link>
      </div>
    </div>
  </aside>
</template>
