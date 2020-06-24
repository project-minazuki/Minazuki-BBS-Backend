package com.minazuki.bbsbackend.bbs.category.dao;

import com.minazuki.bbsbackend.bbs.category.pojo.Category;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CategoryDao {
    private final SqlSession sqlSession;
    @Autowired
    public CategoryDao(SqlSession sqlSession){this.sqlSession = sqlSession;}

    public void addCategory(Category category){this.sqlSession.insert("addCategory",category);}

    public void deleteCategory(Integer id){this.sqlSession.delete("deleteCategory",id);}

}
