package com.minazuki.bbsbackend.bbs.categoryModerator.dao;

import com.minazuki.bbsbackend.bbs.categoryModerator.dataObject.PrimaryKeyDto;
import com.minazuki.bbsbackend.bbs.categoryModerator.pojo.CategoryModerator;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CategoryModeratorDao {
    private final SqlSession sqlSession;
    @Autowired
    public CategoryModeratorDao(SqlSession sqlSession){ this.sqlSession = sqlSession;}

    public void addCategoryModerator(CategoryModerator categoryModerator){this.sqlSession.insert("addCategoryModerator", categoryModerator);}

    public void deleteCategoryModerator(PrimaryKeyDto primaryKeyDto){this.sqlSession.delete("deleteCategoryModerator", primaryKeyDto);}

    public List<Integer> getManageCategoryIds(Integer userId) {return this.sqlSession.selectList("getManagedCategoryIds", userId);}

    public List<Integer> getModeratorIds(Integer categoryId) {return this.sqlSession.selectList("getModeratorIds", categoryId);}
}
