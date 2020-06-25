package com.minazuki.bbsbackend.bbs.category.service;

import com.minazuki.bbsbackend.bbs.category.dataObject.CategoryCreateDto;
import com.minazuki.bbsbackend.bbs.category.dataObject.CategoryUpdateDto;
import com.minazuki.bbsbackend.bbs.category.pojo.Category;

import java.util.List;

public interface CategoryService {

    Category getByIndex(Integer id);

    void createCategory(CategoryCreateDto categoryCreateDto);

    void updateCategory(CategoryUpdateDto categoryUpdateDto);

    List<Category> getAllCategories();

    List<Category> getAllOpenCategories();
}
