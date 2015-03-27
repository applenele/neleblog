package com.nele.neleblog.controller;

import com.google.gson.Gson;
import com.nele.neleblog.model.Message;
import com.nele.neleblog.service.IMessageService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

/**
 * Created by apple on 15/3/27.
 */

@Controller
@RequestMapping("/message")
public class MessageController {

    @Resource
    private IMessageService messageService;

    @RequestMapping("/add")
    @ResponseBody
    public String add(@RequestParam String nickname,@RequestParam String content){
        Message message=new Message(UUID.randomUUID().toString(),nickname,content, LocalDateTime.now().toString());
        messageService.add(message);
        return "ok";
    }


    @RequestMapping("/getMessages")
    @ResponseBody
    public String getMessages(@RequestParam int page){
        List<Message> messages=messageService.getByPage(page);
        Gson gson=new Gson();
        String result=gson.toJson(messages);
        return result;
    }
}
