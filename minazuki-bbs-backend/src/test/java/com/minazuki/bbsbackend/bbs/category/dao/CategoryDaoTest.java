package com.minazuki.bbsbackend.bbs.category.dao;

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
        Category category =Category.builder().name("测试板块").status(true).description("用于测试").createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now()).visitsCount(100).coverUrl("附件路径").build();
        categoryDao.addCategory(category);

    }

    @Test
    public void deleteCategory() {
        Integer id = 1;
        categoryDao.deleteCategory(id);
    }
}