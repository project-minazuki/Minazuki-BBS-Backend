package com.minazuki.bbsbackend.bbs.category.service.impl;

import com.minazuki.bbsbackend.bbs.category.dao.CategoryDao;
import com.minazuki.bbsbackend.bbs.category.dataobject.CategoryCreateDto;
import com.minazuki.bbsbackend.bbs.category.dataobject.CategoryUpdateDto;
import com.minazuki.bbsbackend.bbs.category.exception.DuplicateCategoryModeratorException;
import com.minazuki.bbsbackend.bbs.category.exception.DuplicateCategoryNameException;
import com.minazuki.bbsbackend.bbs.category.pojo.Category;
import com.minazuki.bbsbackend.bbs.category.service.CategoryService;
import com.minazuki.bbsbackend.bbs.categorymoderator.dao.CategoryModeratorDao;
import com.minazuki.bbsbackend.bbs.categorymoderator.dataobject.ModeratorPrimaryKeyDto;
import com.minazuki.bbsbackend.bbs.categorymoderator.pojo.CategoryModerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {
    private final CategoryDao categoryDao;
    private final CategoryModeratorDao categoryModeratorDao;

    @Autowired
    public CategoryServiceImpl(CategoryDao categoryDao,CategoryModeratorDao categoryModeratorDao) {
        this.categoryDao = categoryDao;
        this.categoryModeratorDao = categoryModeratorDao;
    }


    @Override
    public Category getByIndex(Integer id) {
        return categoryDao.getCategoryById(id);
    }

    @Override
    public void createCategory(CategoryCreateDto categoryCreateDto) throws DuplicateCategoryNameException {
        if (categoryDao.getCategoryByName(categoryCreateDto.getName()) != null) {
            throw new DuplicateCategoryNameException();
        }
        else {
            categoryDao.addCategory(categoryCreateDto);
        }
    }

    @Override
    public void updateCategory(CategoryUpdateDto categoryUpdateDto) throws DuplicateCategoryNameException{
        if (categoryUpdateDto.isAllNull()) return;
        if (categoryDao.getCategoryByName(categoryUpdateDto.getName()) != null) {
            throw new DuplicateCategoryNameException();
        }
        else {
            categoryDao.updateCategoryById(categoryUpdateDto);
        }
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryDao.findAllCategories();
    }

    @Override
    public List<Category> getAllOpenCategories() {
        return categoryDao.findAllOpenCategories();
    }

    @Override
    public void addModerator(ModeratorPrimaryKeyDto moderatorPrimaryKeyDto) throws DuplicateCategoryModeratorException {
        if (getModerators(moderatorPrimaryKeyDto.getCategoryId()).contains(moderatorPrimaryKeyDto.getModeratorId())) {
            throw new DuplicateCategoryModeratorException();
        }
        else {
            categoryModeratorDao.addCategoryModerator(moderatorPrimaryKeyDto);
        }
    }

    @Override
    public void removeModerator(ModeratorPrimaryKeyDto moderatorPrimaryKeyDto) {
        categoryModeratorDao.deleteCategoryModerator(moderatorPrimaryKeyDto);
    }

    @Override
    public List<Integer> getModerators(Integer categoryId) {
        return categoryModeratorDao.getModeratorIds(categoryId);
    }

    @Override
    public List<Integer> getManagedCategories(Integer moderator) {
        return categoryModeratorDao.getManageCategoryIds(moderator);
    }

    @Override
    public boolean isModerator(Integer userId) {
        return getManagedCategories(userId).size() != 0;
    }
}
