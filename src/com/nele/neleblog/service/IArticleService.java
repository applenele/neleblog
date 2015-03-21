package com.nele.neleblog.service;

import com.nele.neleblog.model.Articel;

import java.util.List;

/**
 * Created by apple on 15/3/21.
 */
public interface IArticleService {
     List<Articel> getAll();

     void add(Articel articel);

     void delete(String id);

     void update(Articel articel);
}
