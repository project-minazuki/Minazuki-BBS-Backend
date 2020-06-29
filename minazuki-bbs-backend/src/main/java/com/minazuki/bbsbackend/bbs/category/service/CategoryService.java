package com.minazuki.bbsbackend.bbs.category.service;

import com.minazuki.bbsbackend.bbs.category.dataobject.CategoryCreateDto;
import com.minazuki.bbsbackend.bbs.category.dataobject.CategoryUpdateDto;
import com.minazuki.bbsbackend.bbs.category.exception.DuplicateCategoryModeratorException;
import com.minazuki.bbsbackend.bbs.category.exception.DuplicateCategoryNameException;
import com.minazuki.bbsbackend.bbs.category.pojo.Category;
import com.minazuki.bbsbackend.bbs.categorymoderator.dataobject.ModeratorPrimaryKeyDto;
import com.minazuki.bbsbackend.bbs.themereport.pojo.ThemeReport;
import com.minazuki.bbsbackend.user.exception.PermissionDeniedException;

import java.util.List;

public interface CategoryService {

    Category getByIndex(Integer id);

    void createCategory(CategoryCreateDto categoryCreateDto) throws DuplicateCategoryNameException;

    void deleteCategory(Integer categoryId);

    void updateCategory(CategoryUpdateDto categoryUpdateDto) throws DuplicateCategoryNameException, PermissionDeniedException;

    List<Category> getAllCategories();

    List<Category> getAllOpenCategories();

    void addModerator(ModeratorPrimaryKeyDto moderatorPrimaryKeyDto) throws DuplicateCategoryModeratorException;

    void removeModerator(ModeratorPrimaryKeyDto moderatorPrimaryKeyDto);

    List<Integer> getModerators(Integer categoryId);

    List<Integer> getManagedCategories(Integer moderator);

    void closeCategory(Integer categoryId);

    void openCategory(Integer categoryId);

    // theme report 相关

    List<ThemeReport> findAllThemeReportsByCategoryId(Integer categoryId) throws PermissionDeniedException;

    void deleteCheckedReports(Integer categoryId) throws PermissionDeniedException;
}
