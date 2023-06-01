package com.repositories;

import com.model.Article;

import java.util.List;

public interface ArticleRepository {

    List<Article> findAll();
    Article findById( long id);
    void save( Article article);
    void remove( long id);

}
