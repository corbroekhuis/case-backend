package com.repositories;

import com.model.Article;
import com.model.Sequence;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArticleRepositoryImpl implements ArticleRepository{

    private List<Article> articles = new ArrayList<>();

    @Override
    public List<Article> findAll(){
        return articles;
    }

    @Override
    public Article findById( long id){

        for( Article article: articles){
            if( article.getId() == id){
                return article;
            }
        }

        return null;
    }

    private long getNextId(){

        if( articles.size() == 0){
            return 1L;
        }

        List<Long> ids = new ArrayList<>();

        for( Article article: articles){
            ids.add(article.getId());
        }

        Collections.sort(ids);

       // 3
       // 6
       // 4

       // 3 0
       // 4 1
       // 6 2

        return ids.get(ids.size() -1 ) + 1;
    }

    @Override
    public void save( Article article){

        long id = Sequence.getNextSequence();
        article.setId(id);
        articles.add(article);
    }

    @Override
    public void remove( long id){

        List<Article> newArticles = new ArrayList<>();

        for( Article article: articles){

            if( article.getId() != id){
                newArticles.add(article);
            }
        }

        articles = newArticles;
    }

}
