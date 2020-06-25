package com.minazuki.bbsbackend.bbs.category.dao;

import com.minazuki.bbsbackend.bbs.category.dataObject.CategoryUpdateDto;
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

    public Category getCategoryById(Integer id) {
        return this.sqlSession.selectOne("getCategoryById", id);
    }

    public void deleteCategory(Integer id){this.sqlSession.delete("deleteCategory",id);}

    public void updateCategoryById(CategoryUpdateDto categoryUpdateDto){this.sqlSession.update("updateCategoryById",categoryUpdateDto);}

}
