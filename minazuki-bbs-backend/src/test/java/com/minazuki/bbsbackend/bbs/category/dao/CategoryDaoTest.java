package com.minazuki.bbsbackend.bbs.category.dao;

import com.minazuki.bbsbackend.bbs.category.dataobject.CategoryCreateDto;
import com.minazuki.bbsbackend.bbs.category.dataobject.CategoryUpdateDto;
import com.minazuki.bbsbackend.bbs.category.pojo.Category;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.time.LocalDateTime;

@SpringBootTest
class CategoryDaoTest {

    @Resource
    private CategoryDao categoryDao;

    @Test
    public void addCategory() {
        CategoryCreateDto categoryCreateDto = new CategoryCreateDto();
        categoryCreateDto.setName("测试dto");
        categoryCreateDto.setDescription("test");
        categoryDao.addCategory(categoryCreateDto);

    }

    @Test
    public void deleteCategory() {
        Integer id = 1;
        categoryDao.deleteCategory(id);
    }

    @Test
    public void updateCategoryById(){
        CategoryUpdateDto categoryUpdateDto = new CategoryUpdateDto();
        categoryUpdateDto.setId(1);
        categoryUpdateDto.setName("更新");
        categoryUpdateDto.setDescription("更新描述");
        categoryUpdateDto.setCoverUrl("更新后的路径");
        categoryDao.updateCategoryById(categoryUpdateDto);
    }

    @Test
    public void getCategoryById() {
        System.out.println(categoryDao.getCategoryById(1));
    }

    @Test
    void findAllCategories() {
        System.out.println(categoryDao.findAllCategories());
    }

    @Test
    void findAllOpenCategories() {
        System.out.println(categoryDao.findAllOpenCategories());
    }

    @Test
    void getCategoryByName() {
        System.out.println(categoryDao.getCategoryByName("测试版块"));
    }

    @Test
    void addVisitsCountByIdTest() {
        categoryDao.addVisitsCountById(3);
    }

    @Test
    void openCategoryTest() {
        categoryDao.openCategory(3);
    }

    @Test
    void closeCategoryTest() {
        categoryDao.closeCategory(3);
    }
}