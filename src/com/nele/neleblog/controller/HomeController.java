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

        return "index";
    }
}
