package com.nele.neleblog.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Created by apple on 15/3/26.
 */
public class Test01 {
    public static void main(String[] args) {
        List<String> str = new ArrayList<String>();

        str.add("admin");
        str.add("demo");
        str.add("ss");
        str.add("asd");
        str.add("all");

        List<Object> so = str.stream().limit(3).collect(Collectors.toList());

        for (Object s : so){
            System.out.println(s);
        }
    }
}
