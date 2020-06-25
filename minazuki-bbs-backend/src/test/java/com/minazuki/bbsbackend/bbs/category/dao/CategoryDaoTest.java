package com.minazuki.bbsbackend.bbs.category.dao;

import com.minazuki.bbsbackend.bbs.category.dataObject.CategoryUpdateDto;
import com.minazuki.bbsbackend.bbs.category.pojo.Category;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CategoryDaoTest {

    @Resource
    private CategoryDao categoryDao;

    @Test
    public void addCategory() {
        Category category =Category.builder().name("测试关闭版块").status(false).description("用于测试").createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now()).visitsCount(100).coverUrl("附件路径").build();
        categoryDao.addCategory(category);

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
        categoryUpdateDto.setStatus(false);
        categoryUpdateDto.setUpdatedAt(LocalDateTime.now());
        categoryUpdateDto.setCoverUrl("更新后的路径");
        categoryUpdateDto.setVisitsCount(555);
        categoryDao.updateCategoryById(categoryUpdateDto);
    }

    @Test
    public void addVisitsCountById(){
        Integer id = 1;
        categoryDao.addVisitsCountById(id);
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
}