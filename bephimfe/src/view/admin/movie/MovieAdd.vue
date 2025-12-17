<template>
  <div class="w-full h-full p-10">
    <!-- Container 2 cột: Movie + Danh mục -->
    <div class="flex flex-col md:flex-row md:space-x-8">
      <!-- Cột Movie -->
      <div class="movie flex flex-col mb-6 md:mb-0">
        <label class="font-medium mb-1">Tên phim</label>
        <input type="text" placeholder="Nhập tên phim"
               class="border border-black p-2 rounded-lg h-10 w-full max-w-md focus:outline-none">

        <label class="font-medium mt-4 mb-1">Mô tả</label>
        <input type="text" placeholder="Nhập Mô Tả"
               class="border border-black p-2 rounded-lg h-10 w-full max-w-md focus:outline-none">

        <label class="font-medium mt-4 mb-1">Số tập</label>
        <input type="number" placeholder="Nhập Số Tập"
               class="border border-black p-2 rounded-lg h-10 w-full max-w-md focus:outline-none">
      </div>

      <!-- Cột Danh mục -->
      <div class="danhmuc flex flex-col">
        <label class="font-medium mb-1">Chọn thể loại</label>
        <select class="border border-black p-2 rounded-lg h-10 w-full max-w-sm focus:outline-none">
          <option value="">Chọn thể loại</option>
          <option value="1">Phim Hành Động</option>
          <option value="2">Phim Hài</option>
          <option value="3">Phim Chiếu Rạp</option>
        </select>
      </div>
    </div>

    <hr class="mt-10 mb-7 border-gray-300">

    <!-- Container Episode + Link -->
    <div class="flex flex-col md:flex-row md:space-x-6">
      <!-- Episode -->
      <div class="episolide flex flex-col md:flex-row md:items-center mb-4 md:mb-0">
        <label class="font-medium mb-1 md:mb-0 md:mr-2">Tập Số</label>
        <select class="border border-black p-1 rounded-lg h-8 w-20 md:mr-6 focus:outline-none">
          <option value="1">1</option>
          <option value="2">2</option>
          <option value="3">3</option>
          <option value="4">4</option>
        </select>

        <label class="font-medium mt-2 md:mt-0 md:mr-2">Mô tả Tập</label>
        <input type="text" placeholder="Nhập Mô Tả Tập"
               class="border border-black p-2 rounded-lg h-10 w-full max-w-md focus:outline-none">
      </div>

      <!-- Link Video -->
      <div class="link flex flex-col md:flex-row md:items-center">
        <label class="font-medium mb-1 md:mb-0 md:mr-2">Loại</label>
        <select class="border border-black p-1 rounded-lg h-8 w-20 md:mr-6 focus:outline-none">
          <option value="4k">4k</option>
          <option value="5k">5k</option>
        </select>

        <label class="font-medium mt-2 md:mt-0 md:mr-2">Video</label>
        <input type="file" accept="video/*"
               class="border rounded-lg w-full max-w-md focus:outline-none">
      </div>
    </div>
  </div>
</template>
