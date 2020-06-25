package com.minazuki.bbsbackend.bbs.category.service.impl;

import com.minazuki.bbsbackend.bbs.category.dao.CategoryDao;
import com.minazuki.bbsbackend.bbs.category.dataObject.CategoryCreateDto;
import com.minazuki.bbsbackend.bbs.category.dataObject.CategoryUpdateDto;
import com.minazuki.bbsbackend.bbs.category.exception.DuplicateCategoryNameException;
import com.minazuki.bbsbackend.bbs.category.pojo.Category;
import com.minazuki.bbsbackend.bbs.category.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {
    private final CategoryDao categoryDao;

    @Autowired
    public CategoryServiceImpl(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }


    @Override
    public Category getByIndex(Integer id) {
        return categoryDao.getCategoryById(id);
    }

    @Override
    public void createCategory(CategoryCreateDto categoryCreateDto) throws DuplicateCategoryNameException {

    }

    @Override
    public void updateCategory(CategoryUpdateDto categoryUpdateDto) throws DuplicateCategoryNameException{
        
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryDao.findAllCategories();
    }

    @Override
    public List<Category> getAllOpenCategories() {
        return categoryDao.findAllOpenCategories();
    }
}
