package com.controller;

import com.model.Article;
import com.service.ArticleService;
import com.service.ArticleServiceImpl;

import java.util.List;

public class ArticleController {

    ArticleService articleService = new ArticleServiceImpl();

    // Endpoint
    // http://localhost:8080/api/article
    // PUT
    public void createArticle( Article article){
        articleService.save(article);
    }

    // Endpoint
    // http://localhost:8080/api/article
    // GET
    public List<Article> getAllArticles(){
        return articleService.findAll();

    }

    // Endpoint
    // http://localhost:8080/api/article/2
    // GET
    public Article getArticleById( long id){
        return articleService.findById(id);

    }

    // Endpoint
    // http://localhost:8080/api/article/2
    // DEL
    public void deleteArticleById( long id){
        articleService.remove(id);
    }

}
