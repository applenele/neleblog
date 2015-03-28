package com.nele.neleblog.controller;

import com.google.gson.Gson;
import com.nele.neleblog.model.Article;
import com.nele.neleblog.model.Reply;
import com.nele.neleblog.model.Tag;
import com.nele.neleblog.service.impl.ArticleService;
import com.nele.neleblog.util.StringHelper;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by apple on 15/3/22.
 */
@Controller
@RequestMapping("/article")
public class ArticleController {

    @Resource
    private ArticleService articleService;



    @RequestMapping("/addArticle")
    public String addArticle(){
         return "addArticle";
    }

    @RequestMapping("/add")
    @ResponseBody
    public String add(String title, String content, String category, String tags) {
        String[] tagsArray = tags.split(",");
        List<Tag> tagList = new ArrayList<Tag>();
        for (String stag : tagsArray) {
            Tag tag = new Tag();
            tag.setContent(stag);
            tagList.add(tag);
        }
        Article article = new Article();
        UUID uuid = UUID.randomUUID();
        article.setId(uuid.toString());
        article.setTitle(title);
        article.setContent(content);
        article.setCategory(category);
        article.setPtime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")).toString());
        article.setReplies(new ArrayList<Reply>());
        article.setTags(tagList);
        articleService.add(article);
        return "ok";
    }


    @RequestMapping("/getArticles")
    @ResponseBody
    public String getArticles(@RequestParam int page,@RequestParam String time,@RequestParam String category) {
        List<Article> articles = new ArrayList<Article>();
        articles = articleService.getArticlesByPage(page,time,category);
        for (Article article : articles) {
            article.setContent(StringHelper.getSomeConent(article.getContent()));
        }
        Gson gson = new Gson();
        String json = gson.toJson(articles);
        return json;
    }

    //页面展示 获取文章 然后展示
    @RequestMapping("/show")
    public String show(@RequestParam String id,Model model) {
        Article article = new Article();
        article = articleService.getArticleById(id);
        Function<Reply, String> byTime = r->r.getPtime();
        SimpleDateFormat format =new SimpleDateFormat("YYYY-MM-DD HH:mm:ss");
        article.setReplies(article.getReplies().stream().sorted(Comparator.comparing(byTime).reversed()).collect(Collectors.toList()));
        //article.getPtime(new LocalDateTime(article.getPtime()).format("YYYY-MM-DD HH:mm:ss"));
        model.addAttribute("article",article);
        return "showArticle";
    }

    //获取归档的时间 直接返回html
    @RequestMapping("/getPTime")
    @ResponseBody
    public String getPTime(){
        List<Article> articles = articleService.getAll();
        Map<String,Integer> mtime=new HashMap<String, Integer>();
        Map<String,Integer> mcategory =new HashMap<String, Integer>();
        List<String> stime=new ArrayList<String>();
        for(Article article : articles){
            stime.add(article.getPtime());
        }
        for (String time :stime){

            String date =time.substring(0,7);
            if(mtime.containsKey(date)){
                Integer val= mtime.get(date);
                mtime.put(date,(int)val+1);
            }else{
                mtime.put(date,1);
            }
        }
        Gson gson=new Gson();
        String str=gson.toJson(mtime);
        return str;
    }


    @RequestMapping("/getPCategory")
    @ResponseBody
    public String getPCategory(){
        List<Article> articles = articleService.getAll();
        Map<String,Integer> mcategory =new HashMap<String, Integer>();
        List<String> scategory=new ArrayList<String>();

        for(Article article : articles){
            scategory.add(article.getCategory());
        }

        for(String category : scategory){
            if(mcategory.containsKey(category)){
                Integer val=mcategory.get(category);
                mcategory.put(category,(int)val+1);
            }else{
                mcategory.put(category,1);
            }
        }
        Gson gson=new Gson();
        String str=gson.toJson(mcategory);
        return str;
    }
}
