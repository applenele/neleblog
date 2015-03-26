package com.nele.neleblog.service.impl;

import com.nele.neleblog.model.Article;
import com.nele.neleblog.service.IArticleService;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.data.mongodb.core.query.Query.query;

/**
 * Created by apple on 15/3/21.
 */
@Service("articleService")
public class ArticleService implements IArticleService{

    @Resource
    private MongoTemplate mongoTemplate;

    @Override
    public void add(Article article) {
       mongoTemplate.save(article,"articles");
       // mongoTemplate.insert(articel,"articles");
    }

    @Override
    public List<Article> getAll() {
        List<Article> list= mongoTemplate.findAll(Article.class, "articles");
        return list;
    }

    @Override
    public void delete(String id) {
        mongoTemplate.remove(query(Criteria.where("id").is(id)), Article.class, "articles");
    }

    @Override
    public void update(Article article) {
        Query query =new Query(Criteria.where("id").is(article.getId()));
        Update update= new Update().set("title", article.getTitle()).set("content", article.getContent())
                .set("category", article.getCategory());

        mongoTemplate.findAndModify(query,update,Article.class,"articles");
    }


    @Override
    public List<Object> getArticlesByPage(int page) {
        List<Article> articles =new ArrayList<Article>();
        articles = getAll();
        List<Object> list= articles.stream().skip(page*3).limit(3).collect(Collectors.toList());
        return list;
    }

    @Override
    public Article getArticleById(String id) {
        Article article =new Article();
        article =mongoTemplate.findById(id,Article.class);
        return article;
    }
}
