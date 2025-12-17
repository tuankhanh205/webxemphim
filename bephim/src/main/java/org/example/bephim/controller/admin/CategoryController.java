package org.example.bephim.controller.admin;

import org.example.bephim.dto.category.request.CategoryRequest;
import org.example.bephim.dto.category.response.CategoryResponse;
import org.example.bephim.service.admin.category.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/category")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }
    @GetMapping()
    List<CategoryResponse> getAll(){
        return categoryService.getAll();
    }
    @GetMapping("/finbyid/{id}")
    CategoryResponse getById(@PathVariable("id") Integer id){
        return categoryService.getById(id);
    }
    @PostMapping("/create")
    ResponseEntity<CategoryResponse> create(@RequestBody CategoryRequest categoryRequest){
        return ResponseEntity.ok(categoryService.create(categoryRequest));
    }
    @PutMapping("/update/{id}")
    ResponseEntity<CategoryResponse> update(@PathVariable("id") Integer id,@RequestBody CategoryRequest categoryRequest){
        return ResponseEntity.ok(categoryService.update(id,categoryRequest));
    }
}
