package com.minazuki.bbsbackend.bbs.category.dao;

import com.minazuki.bbsbackend.bbs.category.dataobject.CategoryCreateDto;
import com.minazuki.bbsbackend.bbs.category.dataobject.CategoryUpdateDto;
import com.minazuki.bbsbackend.bbs.category.pojo.Category;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CategoryDao {
    private final SqlSession sqlSession;
    @Autowired
    public CategoryDao(SqlSession sqlSession){this.sqlSession = sqlSession;}

    public void addCategory(CategoryCreateDto categoryCreateDto){this.sqlSession.insert("addCategory",categoryCreateDto);}

    public List<Category> findAllCategories() {
        return this.sqlSession.selectList("findAllCategories");
    }

    public List<Category> findAllOpenCategories() {
        return this.sqlSession.selectList("findAllOpenCategories");
    }

    public Category getCategoryById(Integer id) {
        return this.sqlSession.selectOne("getCategoryById", id);
    }

    public Category getCategoryByName(String categoryName) {
        return this.sqlSession.selectOne("getCategoryByName", categoryName);
    }

    public void deleteCategory(Integer id){this.sqlSession.delete("deleteCategory",id);}

    public void updateCategoryById(CategoryUpdateDto categoryUpdateDto){this.sqlSession.update("updateCategoryById",categoryUpdateDto);}

    //delete
    public void addVisitsCountById(Integer id) {
        this.sqlSession.update("addVisitsCountById", id);
    }

    public void openCategory(Integer id) {
        this.sqlSession.update("openCategory", id);
    }

    public void closeCategory(Integer id) {
        this.sqlSession.update("closeCategory", id);
    }

}
