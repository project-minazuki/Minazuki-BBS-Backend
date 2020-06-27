package com.minazuki.bbsbackend.bbs.tag.dao;

import com.minazuki.bbsbackend.bbs.tag.pojo.Tag;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TagDao {
    public final SqlSession sqlsession;
    @Autowired
    public TagDao(SqlSession sqlSession){this.sqlsession = sqlSession;}

    public void addTag(String name){this.sqlsession.insert("addTag",name);}

    public void deleteTag(Integer id){this.sqlsession.delete("deleteTag",id);}

    public List<Tag> getAllTags(){return this.sqlsession.selectList("getAllTags");}

    public Tag getTagByName(String name){ return this.sqlsession.selectOne("getTagByName",name);}

    public boolean isTagUnique(String name){
        if(this.getTagByName(name)!=null){
            return false;
        }
        else return true;
    }

}
