package org.example.bephim.service.admin.category;

import org.example.bephim.dto.category.request.CategoryRequest;
import org.example.bephim.dto.category.response.CategoryResponse;
import org.example.bephim.entity.Category;
import org.example.bephim.exception.NotFoundException;
import org.example.bephim.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryIlm implements CategoryService{
    private final CategoryRepository categoryRepository;

    public CategoryIlm(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<CategoryResponse> getAll() {
        List<Category> categories = categoryRepository.findAll();
        return categories.stream().map(c->mapResponse(c)).collect(Collectors.toList());

    }

    @Override
    public CategoryResponse getById(Integer id) {
        Category category=categoryRepository.findById(id).orElseThrow(()->new NotFoundException("Category not found"));
        return mapResponse(category);
    }

    @Override
    public CategoryResponse getByName(String name) {
        return null;
    }

    @Override
    public CategoryResponse create(CategoryRequest categoryRequest) {
        Category category=new Category();
        category.setName(categoryRequest.getName());
        categoryRepository.save(category);
        return mapResponse(category);
    }

    @Override
    public CategoryResponse update(Integer id,CategoryRequest categoryRequest) {
        Category category=categoryRepository.findById(id).orElseThrow(()->new NotFoundException("Category not found"));
        category.setName(categoryRequest.getName());
        categoryRepository.save(category);
        return mapResponse(category);
    }
    CategoryResponse mapResponse(Category category){
        CategoryResponse categoryResponse = new CategoryResponse();
        categoryResponse.setId(category.getId());
        categoryResponse.setName(category.getName());
        return categoryResponse;
    }

}
