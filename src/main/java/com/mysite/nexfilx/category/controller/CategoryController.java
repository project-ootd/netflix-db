package com.mysite.nexfilx.category.controller;

import com.mysite.nexfilx.category.domain.Category;
import com.mysite.nexfilx.category.repository.CategoryRepository;
import com.mysite.nexfilx.category.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @Autowired
    private final CategoryRepository categoryRepository;

    @GetMapping("/category")
    public List<Category> getCategory(@RequestParam Long id) {
        List<Category> categoryList = categoryRepository.findAllByNetflixContentsId(id);
        return categoryList;
    }

}
