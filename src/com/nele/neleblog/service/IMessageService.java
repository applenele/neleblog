package com.nele.neleblog.service;

import com.nele.neleblog.model.Message;

import java.util.List;

/**
 * Created by apple on 15/3/27.
 */
public interface IMessageService {

    List<Message>  getByPage();

    void add(Message message);

    void delete(String id);
}
