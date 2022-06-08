package com.cnpmHDT.api.mapper;

import com.cnpmHDT.api.dto.news.NewsDto;
import com.cnpmHDT.api.form.news.CreateNewsForm;
import com.cnpmHDT.api.form.news.UpdateNewsForm;
import com.cnpmHDT.api.storage.model.News;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-06-02T10:00:50+0700",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.13 (Oracle Corporation)"
)
@Component
public class NewsMapperImpl implements NewsMapper {

    @Override
    public News fromCreateNewsFormToEntity(CreateNewsForm createNewsForm) {
        if ( createNewsForm == null ) {
            return null;
        }

        News news = new News();

        news.setBanner( createNewsForm.getBanner() );
        news.setDescription( createNewsForm.getDescription() );
        news.setAvatar( createNewsForm.getAvatar() );
        news.setTitle( createNewsForm.getTitle() );
        news.setContent( createNewsForm.getContent() );
        news.setStatus( createNewsForm.getStatus() );

        return news;
    }

    @Override
    public void fromUpdateNewsFormToEntity(UpdateNewsForm updateNewsForm, News news) {
        if ( updateNewsForm == null ) {
            return;
        }

        if ( updateNewsForm.getBanner() != null ) {
            news.setBanner( updateNewsForm.getBanner() );
        }
        if ( updateNewsForm.getDescription() != null ) {
            news.setDescription( updateNewsForm.getDescription() );
        }
        if ( updateNewsForm.getId() != null ) {
            news.setId( updateNewsForm.getId() );
        }
        if ( updateNewsForm.getAvatar() != null ) {
            news.setAvatar( updateNewsForm.getAvatar() );
        }
        if ( updateNewsForm.getTitle() != null ) {
            news.setTitle( updateNewsForm.getTitle() );
        }
        if ( updateNewsForm.getContent() != null ) {
            news.setContent( updateNewsForm.getContent() );
        }
        if ( updateNewsForm.getStatus() != null ) {
            news.setStatus( updateNewsForm.getStatus() );
        }
    }

    @Override
    public NewsDto fromEntityToNewsDtoNoNewsContent(News news) {
        if ( news == null ) {
            return null;
        }

        NewsDto newsDto = new NewsDto();

        newsDto.setCreatedDate( news.getCreatedDate() );
        newsDto.setCreatedBy( news.getCreatedBy() );
        newsDto.setModifiedDate( news.getModifiedDate() );
        newsDto.setBanner( news.getBanner() );
        newsDto.setDescription( news.getDescription() );
        newsDto.setModifiedBy( news.getModifiedBy() );
        newsDto.setId( news.getId() );
        newsDto.setAvatar( news.getAvatar() );
        newsDto.setTitle( news.getTitle() );
        newsDto.setStatus( news.getStatus() );

        return newsDto;
    }

    @Override
    public List<NewsDto> fromEntityListToNewsDtoListNoNewsContent(List<News> news) {
        if ( news == null ) {
            return null;
        }

        List<NewsDto> list = new ArrayList<NewsDto>( news.size() );
        for ( News news1 : news ) {
            list.add( fromEntityToNewsDtoNoNewsContent( news1 ) );
        }

        return list;
    }

    @Override
    public NewsDto fromEntityToNewsDto(News news) {
        if ( news == null ) {
            return null;
        }

        NewsDto newsDto = new NewsDto();

        newsDto.setCreatedDate( news.getCreatedDate() );
        newsDto.setCreatedBy( news.getCreatedBy() );
        newsDto.setModifiedDate( news.getModifiedDate() );
        newsDto.setBanner( news.getBanner() );
        newsDto.setDescription( news.getDescription() );
        newsDto.setModifiedBy( news.getModifiedBy() );
        newsDto.setId( news.getId() );
        newsDto.setAvatar( news.getAvatar() );
        newsDto.setTitle( news.getTitle() );
        newsDto.setContent( news.getContent() );
        newsDto.setStatus( news.getStatus() );

        return newsDto;
    }
}
