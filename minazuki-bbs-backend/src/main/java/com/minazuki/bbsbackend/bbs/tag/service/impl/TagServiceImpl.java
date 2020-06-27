package com.minazuki.bbsbackend.bbs.tag.service.impl;

import com.minazuki.bbsbackend.bbs.tag.dao.TagDao;
import com.minazuki.bbsbackend.bbs.tag.exception.DuplicatedTagNameException;
import com.minazuki.bbsbackend.bbs.tag.pojo.Tag;
import com.minazuki.bbsbackend.bbs.tag.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TagServiceImpl implements TagService {
    private final TagDao tagDao;
    @Autowired
    public TagServiceImpl(TagDao tagDao){this.tagDao = tagDao;}


    @Override
    public void createTag(String name) throws DuplicatedTagNameException {
        if(tagDao.isTagUnique(name)){
            tagDao.addTag(name);
        }
        else {
            throw new DuplicatedTagNameException();
        }
    }

    @Override
    public void deleteTad(Integer id) {
        tagDao.deleteTag(id);
    }

    @Override
    public List<Tag> getAllTags() {
        return tagDao.getAllTags();
    }
}
