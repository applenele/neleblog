package com.nele.neleblog.service.impl;

import com.nele.neleblog.model.Message;
import com.nele.neleblog.service.IMessageService;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by apple on 15/3/27.
 */

@Service("messageService")
public class MessageService implements IMessageService{

    @Resource
    private MongoTemplate mongoTemplate;

    @Override
    public void add(Message message) {
       mongoTemplate.save(message);
    }

    @Override
    public List<Message> getByPage() {
        return null;
    }

    @Override
    public void delete(String id) {

    }
}
