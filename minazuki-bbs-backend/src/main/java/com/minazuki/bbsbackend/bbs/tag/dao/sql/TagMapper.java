package com.minazuki.bbsbackend.bbs.tag.dao.sql;

import com.minazuki.bbsbackend.bbs.tag.dataobject.ThemeTagLinkDto;
import com.minazuki.bbsbackend.bbs.tag.pojo.Tag;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.tags.ThemeTag;

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

    @Insert("INSERT INTO theme_tag_record(tag_id, tag_theme_id) VALUES(#{tagId}, #{themeId})")
    void addTagToTheme(@Param("themeTagLinkDto")ThemeTagLinkDto themeTagLinkDto);

    @Delete("DELETE FROM theme_tag_record WHERE tag_id = #{tagId} AND tag_theme_id = #{themeId}")
    void deleteTagFromTheme(@Param("themeTagLinkDto")ThemeTagLinkDto themeTagLinkDto);

    @Select("SELECT * FROM tag INNER JOIN theme_tag_record on tag.id = theme_tag_record.tag_id WHERE theme_tag_record.tag_theme_id = #{themeId}")
    List<Tag> getTagsOfTheme(@Param("themeId") Integer themeId);

}
