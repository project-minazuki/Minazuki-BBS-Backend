package com.minazuki.bbsbackend.bbs.tag.service.impl;

import com.minazuki.bbsbackend.bbs.tag.dao.TagDao;
import com.minazuki.bbsbackend.bbs.tag.pojo.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TagServiceImplTest {
    @Resource
    private TagDao tagDao;

    @Test
    void createTag() {
        tagDao.addTag("tag1");
    }

    @Test
    void deleteTad() {
        Integer id = 1;
        tagDao.deleteTag(id);
    }

    @Test
    void getAllTags() {
        List<Tag> list = tagDao.getAllTags();
        System.out.println(list);
    }
}