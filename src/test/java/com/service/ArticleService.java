package com.service;

import com.model.Article;

import java.util.List;

public interface ArticleService {

    List<Article> findAll();
    Article findById( long id);
    void save( Article article);
    void remove( long id);

}
