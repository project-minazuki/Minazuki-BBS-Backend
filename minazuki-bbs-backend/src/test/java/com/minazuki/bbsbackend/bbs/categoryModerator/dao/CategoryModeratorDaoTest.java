package com.minazuki.bbsbackend.bbs.categoryModerator.dao;

import com.minazuki.bbsbackend.bbs.categoryModerator.dataObject.PrimaryKeyDto;
import com.minazuki.bbsbackend.bbs.categoryModerator.pojo.CategoryModerator;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CategoryModeratorDaoTest {

    @Resource
    private CategoryModeratorDao categoryModeratorDao;

    @Test
    void addCategoryModerator() {
        CategoryModerator categoryModerator = CategoryModerator.builder().moderatorId(1).categoryId(1).createdAt(LocalDateTime.now()).build();

        categoryModeratorDao.addCategoryModerator(categoryModerator);
    }

    @Test
    void deleteCategoryModerator() {
        PrimaryKeyDto primaryKeyDto = new PrimaryKeyDto();
        primaryKeyDto.setCategoryId(1);
        primaryKeyDto.setModeratorId(1);
        categoryModeratorDao.deleteCategoryModerator(primaryKeyDto);
    }
}