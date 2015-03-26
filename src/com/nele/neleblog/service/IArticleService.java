package com.nele.neleblog.service;

import com.nele.neleblog.model.Article;

import java.util.List;

/**
 * Created by apple on 15/3/21.
 */
public interface IArticleService {
    List<Article> getAll();

    void add(Article article);

    void delete(String id);

    void update(Article article);

    List<Object> getArticlesByPage(int page);

    Article getArticleById(String id);
}
