package com.minazuki.bbsbackend.bbs.categorymoderator.dao;

import com.minazuki.bbsbackend.bbs.categorymoderator.dataobject.ModeratorPrimaryKeyDto;
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
        ModeratorPrimaryKeyDto mpkDto = new ModeratorPrimaryKeyDto();
        mpkDto.setCategoryId(3);
        mpkDto.setModeratorId(4);
        categoryModeratorDao.addCategoryModerator(mpkDto);
    }

    @Test
    void deleteCategoryModerator() {
        ModeratorPrimaryKeyDto moderatorPrimaryKeyDto = new ModeratorPrimaryKeyDto();
        moderatorPrimaryKeyDto.setCategoryId(1);
        moderatorPrimaryKeyDto.setModeratorId(1);
        categoryModeratorDao.deleteCategoryModerator(moderatorPrimaryKeyDto);
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