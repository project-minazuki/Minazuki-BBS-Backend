package com.minazuki.bbsbackend.bbs.theme.service;

import com.minazuki.bbsbackend.bbs.category.service.impl.CategoryServiceImpl;
import com.minazuki.bbsbackend.bbs.theme.dao.ThemeDao;
import com.minazuki.bbsbackend.bbs.theme.dataobject.ThemeCheckDto;
import com.minazuki.bbsbackend.bbs.theme.dataobject.ThemeCreateDto;
import com.minazuki.bbsbackend.bbs.theme.dataobject.ThemeUpdateDto;
import com.minazuki.bbsbackend.bbs.theme.exception.DuplicateThemeInfoException;
import com.minazuki.bbsbackend.bbs.theme.pojo.Theme;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class ThemeServiceImpl implements ThemeService {
    private final ThemeDao themeDao;

    @Autowired
    public ThemeServiceImpl(ThemeDao themeDao) {
        this.themeDao = themeDao;
    }

    //创建一个新主题，同一个板块下不可有标题相同的主题帖，否则抛出DuplicateThemeInfoException异常
    @Override
    public void createTheme(ThemeCreateDto themeCreateDto) throws DuplicateThemeInfoException {
        //新建一个ThemeCheckDto以备检测
        ThemeCheckDto uniqueCheckDto = new ThemeCheckDto();
        uniqueCheckDto.setCategoryId(themeCreateDto.getCategoryId());
        uniqueCheckDto.setTitle(themeCreateDto.getTitle());

        if (themeDao.isThemeUnique(uniqueCheckDto)) {
            Theme newTheme = Theme.builder().title(themeCreateDto.getTitle()).categoryId(themeCreateDto.getCategoryId())
                    .creatorId(themeCreateDto.getCreatorId()).status(true).isHighQuality(false).isTop(false)
                    .visitsCount(0).replyCount(0).updatedAt(LocalDateTime.now()).createdAt(LocalDateTime.now())
                    .latestReplyAt(null).build();
            themeDao.addTheme(newTheme);
        } else {
            throw new DuplicateThemeInfoException();
        }
    }

    //找版块下的所有主题帖
    @Override
    public List<Theme> getThemeListByCategoryId(Integer id) {
        return themeDao.getThemeByCategoryId(id);
    }

    //找所有为该标题的主题贴
    @Override
    public List<Theme> getThemeListByTitle(String title) {
        return themeDao.getThemeByTitle(title);
    }

    //根据Id找主题帖
    @Override
    public Theme getThemeByIndex(Integer id) {
        return themeDao.getThemeById(id);
    }

    //设置，取消置顶
    @Override
    public void setTopById(Integer id) {
        themeDao.setTopById(id);
    }

    @Override
    public void cancelTopById(Integer id) {
        themeDao.cancelTopById(id);
    }

    //设置，取消精品
    @Override
    public void setHighQuality(Integer id) {
        themeDao.setHighQualityById(id);
    }

    @Override
    public void cancelHighQuality(Integer id) {
        themeDao.cancelHighQualityById(id);
    }


    //更新主题帖，同一个板块下不可有标题相同的主题帖，否则抛出DuplicateThemeInfoException异常
    @Override
    public void updateTheme(ThemeUpdateDto themeUpdateDto) throws DuplicateThemeInfoException {
        //获取该主题所在版块的Id
        Integer categoryId = themeDao.getCategoryIdOfThemeById(themeUpdateDto.getId());
        //新建一个ThemeCheckDto以备检测
        ThemeCheckDto uniqueCheckDto = new ThemeCheckDto();
        uniqueCheckDto.setTitle(themeUpdateDto.getTitle());
        uniqueCheckDto.setCategoryId(categoryId);

        if (themeDao.isThemeUnique(uniqueCheckDto)) {
            themeUpdateDto.setUpdatedAt(LocalDateTime.now());
            themeDao.updateTheme(themeUpdateDto);
        }
        else {
            throw new DuplicateThemeInfoException();
        }
    }


    //visitsCount+1
    @Override
    public void increaseVisitsCountById(Integer id) {
        themeDao.increaseVisitsCountById(id);
    }

    //visitsCount-1
    @Override
    public void decreaseVisitsCountById(Integer id) {
        themeDao.decreaseVisitsCountById(id);
    }

    //replyCount+1
    @Override
    public void increaseReplyCountById(Integer id) {
        themeDao.increaseReplyCountById(id);
    }

    //replyCount-1
    @Override
    public void decreaseReplyCountById(Integer id) {
        themeDao.decreaseReplyCountById(id);
    }

}
