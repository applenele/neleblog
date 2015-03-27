package com.nele.neleblog.service.impl;

import com.nele.neleblog.model.Article;
import com.nele.neleblog.service.IArticleService;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.mongodb.repository.query.StringBasedMongoQuery;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;
import static org.springframework.data.mongodb.core.query.Query.query;

/**
 * Created by apple on 15/3/21.
 */
@Service("articleService")
public class ArticleService implements IArticleService {

    @Resource
    private MongoTemplate mongoTemplate;

    @Override
    public void add(Article article) {
        mongoTemplate.save(article, "articles");
        // mongoTemplate.insert(articel,"articles");
    }

    @Override
    public List<Article> getAll() {
        List<Article> list = mongoTemplate.findAll(Article.class, "articles");
        return list;
    }

    @Override
    public void delete(String id) {
        mongoTemplate.remove(query(Criteria.where("id").is(id)), Article.class, "articles");
    }

    @Override
    public void update(Article article) {
        Query query = new Query(Criteria.where("id").is(article.getId()));
        Update update = new Update().set("title", article.getTitle()).set("content", article.getContent())
                .set("category", article.getCategory());

        mongoTemplate.findAndModify(query, update, Article.class, "articles");
    }

    /**
     * 第二种方式按叶查询  这种方式比较正规
     * @author nele
     * @param page
     * @param time
     * @param category
     * @return
     */
    @Override
    public List<Article> getArticlesByPage(int page, String time, String category) {
        List<Article> articles = new ArrayList<Article>();
        Criteria criteria=new Criteria();
        if (!time.equals(null) && !"".equals(time)) {
            String year = time.substring(0, 4);
            String month = time.substring(5, 6);
            String stime = year + "-0" + month;
            criteria = Criteria.where("ptime").regex(".*?"+stime+".*");
        }
        if(!category.equals(null) && ! "".equals(category)){
           criteria=criteria.where("category").is(category);
        }
        Query query=new Query(criteria);
        query.skip(3*page);
        query.limit(3);
        query.with(new Sort(Sort.Direction.DESC,"ptime"));  //按时间逆序
        articles = mongoTemplate.find(query,Article.class);
        return articles;
    }

    /*@Override
    public List<Article> getArticlesByPage(int page, String time, String category) {
        //mongoTemplate.

        List<Article> articles = new ArrayList<Article>();
        articles=getAll();
        Function<Article, String> byTime = a->a.getPtime();
        articles = articles.stream().sorted(comparing(byTime).reversed()).collect(Collectors.toList());
        if (!time.equals(null) && !"".equals(time)) {
            String year = time.substring(0, 4);
            String month = time.substring(5, 6);
            String  stime = year + "-0" + month;
            articles = articles.stream().filter(a->a.getPtime().contains(stime)).collect(Collectors.toList());
        }
        if(!category.equals(null) && ! "".equals(category)){
            articles = articles.stream().filter(a -> a.getCategory().equals(category))
                    .skip(page * 6).limit(6).collect(Collectors.toList());
        }
        return articles;
    }*/

    @Override
    public Article getArticleById(String id) {
        Article article = new Article();
        article = mongoTemplate.findById(id, Article.class);
        return article;
    }
}
