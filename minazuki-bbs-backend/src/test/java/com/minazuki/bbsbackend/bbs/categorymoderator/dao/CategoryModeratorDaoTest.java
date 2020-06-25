package com.minazuki.bbsbackend.bbs.categorymoderator.dao;

import com.minazuki.bbsbackend.bbs.categorymoderator.dataobject.PrimaryKeyDto;
import com.minazuki.bbsbackend.bbs.categorymoderator.pojo.CategoryModerator;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.time.LocalDateTime;

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


    @Test
    void getManageCategoryIds() {
        System.out.println(categoryModeratorDao.getManageCategoryIds(1));
    }

    @Test
    void getModeratorIds() {
        System.out.println(categoryModeratorDao.getModeratorIds(1));
    }
}