package com.nele.neleblog.controller;

import com.nele.neleblog.model.Reply;
import com.nele.neleblog.service.impl.ArticleService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Created by apple on 15/3/27.
 */

@Controller
@RequestMapping("/reply")
public class ReplyController {

    @Resource
    private ArticleService articleService;

    @RequestMapping("/add")
    @ResponseBody
    public String add(@RequestParam String nickname,@RequestParam String content,@RequestParam String articleId){
        String ptime= LocalDateTime.now().toString();
        Reply reply=new Reply(UUID.randomUUID().toString(),nickname,content,ptime,"");
        articleService.addReply(reply,articleId);
        return  "ok";
    }
}
