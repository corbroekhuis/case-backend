package com.service;

import com.model.Article;
import com.repositories.ArticleRepository;
import com.repositories.ArticleRepositoryImpl;

import java.util.List;

public class ArticleServiceImpl implements ArticleService{

    ArticleRepository articleRepository = new ArticleRepositoryImpl();

    @Override
    public List<Article> findAll() {
        return articleRepository.findAll();
    }

    @Override
    public Article findById(long id) {
        return articleRepository.findById(id);
    }

    @Override
    public void save(Article article) {
        articleRepository.save(article);
    }

    @Override
    public void remove(long id) {
        articleRepository.remove(id);

    }
}
