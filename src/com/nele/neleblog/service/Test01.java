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

    static class  User{
        private  String userName;

        private String remark;

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public User(String userName, String remark) {
            this.remark = remark;
            this.userName = userName;
        }

        @Override
        public String toString() {
            return "User{" +
                    "remark='" + remark + '\'' +
                    ", userName='" + userName + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) {
        List<User> users=new ArrayList<User>();

        users.add(new User("admin","demo"));
        users.add(new User("test01","test01"));
        users.add(new User("test02","test02"));
        users.add(new User("test03","test03"));
        users.add(new User("test04","test05"));
        users.add(new User("test06","test06"));
        users.add(new User("test07","test07"));



        List<User> so = users.stream().filter(u->u.getUserName()=="admin").limit(2).collect(Collectors.toList());

        for (User s : so){
            System.out.println(s);
        }

        /*String time ="2015年3月";

        int year =Integer.parseInt(time.substring(0, 4));
        int month=Integer.parseInt(time.substring(5,6));

        System.out.println(year);
        System.out.println(month);*/

    }
}
