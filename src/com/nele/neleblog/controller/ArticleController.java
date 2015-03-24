package com.nele.neleblog.controller;

import com.google.gson.Gson;
import com.nele.neleblog.model.Article;
import com.nele.neleblog.model.Reply;
import com.nele.neleblog.model.Tag;
import com.nele.neleblog.service.impl.ArticleService;
import com.nele.neleblog.util.StringHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by apple on 15/3/22.
 */
@Controller
@RequestMapping("/article")
public class ArticleController {

    @Resource
    private ArticleService articleService;

    @RequestMapping("/add")
    @ResponseBody
    public String add(String title,String content,String category,String tags){
        String[] tagsArray=tags.split(",");
        List<Tag> tagList =new ArrayList<Tag>();
        for (String stag: tagsArray){
            Tag tag=new Tag();
            tag.setContent(stag);
            tagList.add(tag);
        }
        Article article =new Article();
        UUID uuid =UUID.randomUUID();
        article.setId(uuid.toString());
        article.setTitle(title);
        article.setContent(content);
        article.setCategory(category);
        article.setPtime(LocalDateTime.now().toString());
        article.setReplies(new ArrayList<Reply>());
        article.setTags(tagList);
        articleService.add(article);
        return  "ok";
    }


    @RequestMapping("/getArticles")
    @ResponseBody
    public String getArticles(@RequestParam int page){
        List<Article> articles =new ArrayList<Article>();
        articles = articleService.getArticlesByPage(page);
        for(Article article : articles){
            article.setContent(StringHelper.getSomeConent(article.getContent()));
        }
        Gson gson=new Gson();
        String json =gson.toJson(articles);
        return json;
    }


}
