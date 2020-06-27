package com.minazuki.bbsbackend.bbs.categorymoderator.dao;

import com.minazuki.bbsbackend.bbs.categorymoderator.dataobject.ModeratorPrimaryKeyDto;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CategoryModeratorDao {
    private final SqlSession sqlSession;
    @Autowired
    public CategoryModeratorDao(SqlSession sqlSession){ this.sqlSession = sqlSession;}

    public void addCategoryModerator(ModeratorPrimaryKeyDto mpkDto){this.sqlSession.insert("addCategoryModerator", mpkDto);}

    public void deleteCategoryModerator(ModeratorPrimaryKeyDto moderatorPrimaryKeyDto){this.sqlSession.delete("deleteCategoryModerator", moderatorPrimaryKeyDto);}

    public List<Integer> getManageCategoryIds(Integer userId) {return this.sqlSession.selectList("getManagedCategoryIds", userId);}

    public List<Integer> getModeratorIds(Integer categoryId) {return this.sqlSession.selectList("getModeratorIds", categoryId);}
}
