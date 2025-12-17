package org.example.bephim.service.admin.category;

import org.example.bephim.dto.category.request.CategoryRequest;
import org.example.bephim.dto.category.response.CategoryResponse;

import java.util.List;

public interface CategoryService {
     List<CategoryResponse> getAll();
     CategoryResponse getById(Integer id);
     CategoryResponse getByName(String name);
     CategoryResponse create(CategoryRequest categoryRequest);
     CategoryResponse update(Integer id,CategoryRequest categoryRequest);
}
