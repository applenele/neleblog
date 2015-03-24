package com.nele.neleblog.controller;

import com.nele.neleblog.model.Article;
import com.nele.neleblog.service.impl.ArticleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.*;

/**
 * Created by apple on 15/3/21.
 */
@Controller
public class HomeController {

    @Resource
    private ArticleService articleService;

    @RequestMapping("/index")
    public String index(Map<String,Object> model) {
        List<Article> articles = articleService.getAll();
        Map<String,Integer> mtime=new HashMap<String, Integer>();
        Map<String,Integer> mcategory =new HashMap<String, Integer>();
        List<String> stime=new ArrayList<String>();
        List<String> scategory=new ArrayList<String>();
        for(Article article : articles){
            stime.add(article.getPtime());
            scategory.add(article.getCategory());
        }
        for (String time :stime){
            LocalDateTime local=LocalDateTime.parse(time);
            int year =local.getYear();
            int month=local.getMonthValue();
            String data= year+"年" +month+"月";
            if(mtime.containsKey(data)){
               Integer val= mtime.get(data);
               mtime.put(data,(int)val+1);
            }else{
                mtime.put(data,1);
            }
        }
        for(String category : scategory){
             if(mcategory.containsKey(category)){
                 Integer val=mcategory.get(category);
                 mcategory.put(category,(int)val+1);
             }else{
                 mcategory.put(category,1);
             }
        }

        model.put("mtime",mtime);
        model.put("mcategory",mcategory);
        return "index";
    }
}
