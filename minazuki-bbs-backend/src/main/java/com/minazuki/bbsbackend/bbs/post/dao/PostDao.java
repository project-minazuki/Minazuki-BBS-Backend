package com.minazuki.bbsbackend.bbs.post.dao;

import com.minazuki.bbsbackend.bbs.post.dataobject.PostCreateDto;
import com.minazuki.bbsbackend.bbs.post.dataobject.PostUpdateDto;
import com.minazuki.bbsbackend.bbs.post.pojo.Post;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PostDao {
    private final SqlSession sqlSession;

    @Autowired
    public PostDao(SqlSession sqlSession){this.sqlSession = sqlSession;}

    public void addPost(PostCreateDto postCreateDto){this.sqlSession.insert("addPost",postCreateDto);}

    public void deletePost(Integer id){this.sqlSession.delete("deletePost",id);}

    public void updatePost(PostUpdateDto postUpdateDto) {
        this.sqlSession.update("updatePost", postUpdateDto);
    }

    public List<Post> findAllPostsByThemeId(Integer themeId) {
        return this.sqlSession.selectList("findAllPostsByThemeId", themeId);
    }

    public Integer getNextPostNumber(Integer themeId) {
        Integer maxPostNumber = this.sqlSession.selectOne("getMaxPostNumber", themeId);
        if (maxPostNumber == null) maxPostNumber = 0;
        return maxPostNumber + 1;
    }

    public void likePost(Integer id) {
        this.sqlSession.update("likePost", id);
    }

    public void unlikePost(Integer id) {
        this.sqlSession.update("unlikePost", id);
    }

}
