package com.minazuki.bbsbackend.bbs.tag.service;

import com.minazuki.bbsbackend.bbs.tag.exception.DuplicatedTagNameException;
import com.minazuki.bbsbackend.bbs.tag.pojo.Tag;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TagService {

    public void createTag(String name) throws DuplicatedTagNameException;

    public void deleteTad(Integer id);

    public List<Tag> getAllTags();

}
