package com.minazuki.bbsbackend.bbs.tag.dao.sql;

import com.minazuki.bbsbackend.bbs.tag.pojo.Tag;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Mapper
public interface TagMapper {
    @Insert("INSERT INTO tag(tag_name) VALUES(#{name})")
    void addTag(@Param("name") String name);

    @Delete("DELETE FROM tag WHERE id = #{id}")
    void deleteTag(@Param("id") Integer id);

    @Select("SELECT * FROM tag")
    List<Tag> getAllTags();

    @Select("SELECT * FROM tag WHERE tag_name = #{name}")
    Tag getTagByName(@Param("name") String name);

}
