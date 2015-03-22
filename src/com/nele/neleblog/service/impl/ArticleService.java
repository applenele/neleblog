package com.nele.neleblog.service.impl;

import com.nele.neleblog.model.Articel;
import com.nele.neleblog.service.IArticleService;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

/**
 * Created by apple on 15/3/21.
 */
@Service("articleService")
public class ArticleService implements IArticleService{

    @Resource
    private MongoTemplate mongoTemplate;

    @Override
    public void add(Articel articel) {
       //mongoTemplate.save(articel,"article");
        mongoTemplate.insert(articel,"articles");
    }

    @Override
    public List<Articel> getAll() {
        List<Articel> list= mongoTemplate.findAll(Articel.class, "articles");
        return list;
    }

    @Override
    public void delete(String id) {
        mongoTemplate.remove(query(Criteria.where("id").is(id)), Articel.class, "articles");
    }

    @Override
    public void update(Articel articel) {
        Query query =new Query(Criteria.where("id").is(articel.getId()));

        Update update= new Update().set("title",articel.getTitle()).set("content",articel.getContent())
                .set("category", articel.getCategory());

        mongoTemplate.findAndModify(query,update,Articel.class,"articles");
    }
}
