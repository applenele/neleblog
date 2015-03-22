package com.nele.neleblog.controller;

import com.google.gson.Gson;
import com.nele.neleblog.model.Article;
import com.nele.neleblog.model.Reply;
import com.nele.neleblog.service.impl.ArticleService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
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
    public String add(String title,String content,String category){
        Article article =new Article();
        UUID uuid =UUID.randomUUID();
        article.setId(uuid.toString());
        article.setTitle(title);
        article.setContent(content);
        article.setCategory(category);
        article.setPtime(LocalDateTime.now().toString());
        article.setReplies(new ArrayList<Reply>());
        articleService.add(article);
        return  "ok";
    }


    @RequestMapping("/getArticles")
    @ResponseBody
    public String getArticles(@RequestParam int page){
        List<Article> articles =new ArrayList<Article>();
        articles = articleService.getArticlesByPage(page);
        Gson gson=new Gson();
        String json =gson.toJson(articles);
        return json;
    }


}
