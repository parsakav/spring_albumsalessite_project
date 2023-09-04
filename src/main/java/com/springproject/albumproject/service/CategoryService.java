package com.springproject.albumproject.service;

import com.springproject.albumproject.model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getAllCategories();
    Category saveCategory(Category cattegory);
    Category getCategoryByName(String name);

}
