package com.nele.neleblog.service.impl;

import com.nele.neleblog.model.Message;
import com.nele.neleblog.service.IMessageService;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
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
    public List<Message> getByPage(int page) {
        Query query =new Query();
        query.skip(page*6);
        query.limit(6);
        query.with(new Sort(Sort.Direction.DESC,"mtime"));
        return mongoTemplate.find(query,Message.class);
    }

    @Override
    public void delete(String id) {

    }
}
