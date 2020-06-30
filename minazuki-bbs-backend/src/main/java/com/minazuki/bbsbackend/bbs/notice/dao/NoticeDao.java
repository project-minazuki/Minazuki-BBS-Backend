package com.minazuki.bbsbackend.bbs.notice.dao;

import com.minazuki.bbsbackend.bbs.notice.dataobject.NoticeCreateDto;
import com.minazuki.bbsbackend.bbs.notice.dataobject.NoticeUpdateDto;
import com.minazuki.bbsbackend.bbs.notice.pojo.Notice;
import com.minazuki.bbsbackend.user.interceptor.AuthenticationInterceptor;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class NoticeDao {
    private final SqlSession sqlSession;

    @Autowired
    public NoticeDao(SqlSession sqlSession){this.sqlSession = sqlSession;}

    public void addNotice(NoticeCreateDto noticeCreateDto){this.sqlSession.insert("addNotice", noticeCreateDto);}

    public Notice getNoticeById(Integer id) {
        return this.sqlSession.selectOne("getNoticeById", id);
    }

    //按更新顺序排序
    public List<Notice> findAllNotices(Integer categoryId) {
        return this.sqlSession.selectList("findAllNotices", categoryId);
    }

    public void deleteNotice(Integer id){this.sqlSession.delete("deleteNotice",id);}

    public void updateNotice(NoticeUpdateDto noticeUpdateDto){this.sqlSession.update("updateNotice",noticeUpdateDto);}

    public List<Integer> getCategoryAdministrators(Integer id){return this.sqlSession.selectList("getCategoryAdministrators",id);}

    public boolean isUserCategoryAdministrator(Integer id){

        Integer currentUserId = AuthenticationInterceptor.getCurrentUserId();

        //用于测试
        //currentUserId = 3;

        List<Integer> categoryAdministrators = getCategoryAdministrators(id);
        int i = 0;
        for (i=0;i<categoryAdministrators.size();i++){
            if(currentUserId == categoryAdministrators.get(i))
                return true;
        }
        return false;
    }

    public Integer getCreatorIdByNoticeId(Integer id){return this.sqlSession.selectOne("getCreatorIdByNoticeId",id);}

    public boolean isUserNoticeCreator(Integer id){
        Integer currentUserId = AuthenticationInterceptor.getCurrentUserId();

        //用于测试
        //currentUserId = 3;

        Integer creatorId = getCreatorIdByNoticeId(id);
        if(creatorId == currentUserId){
            return true;
        }
        else return false;
    }

}
