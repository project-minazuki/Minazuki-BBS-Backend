package com.minazuki.bbsbackend.bbs.category.service;

import com.minazuki.bbsbackend.bbs.category.dataobject.CategoryCreateDto;
import com.minazuki.bbsbackend.bbs.category.dataobject.CategoryUpdateDto;
import com.minazuki.bbsbackend.bbs.category.exception.DuplicateCategoryModeratorException;
import com.minazuki.bbsbackend.bbs.category.exception.DuplicateCategoryNameException;
import com.minazuki.bbsbackend.bbs.category.pojo.Category;
import com.minazuki.bbsbackend.bbs.categorymoderator.dataobject.ModeratorPrimaryKeyDto;

import java.util.List;

public interface CategoryService {

    Category getByIndex(Integer id);

    void createCategory(CategoryCreateDto categoryCreateDto) throws DuplicateCategoryNameException;

    void updateCategory(CategoryUpdateDto categoryUpdateDto) throws DuplicateCategoryNameException;

    List<Category> getAllCategories();

    List<Category> getAllOpenCategories();

    void addModerator(ModeratorPrimaryKeyDto moderatorPrimaryKeyDto) throws DuplicateCategoryModeratorException;

    void removeModerator(ModeratorPrimaryKeyDto moderatorPrimaryKeyDto);

    List<Integer> getModerators(Integer categoryId);

    List<Integer> getManagedCategories(Integer moderator);

    boolean isModerator(Integer userId);
}
