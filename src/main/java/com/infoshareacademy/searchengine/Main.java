package com.infoshareacademy.searchengine;

import com.infoshareacademy.searchengine.searchengine.dao.UsersRepositoryDaoBean;
import com.infoshareacademy.searchengine.searchengine.domain.User;

public class Main {
    public static void main(String[] args) {

        UsersRepositoryDaoBean bean = new UsersRepositoryDaoBean();

        for (User user : bean.getUsersList()) {
            System.out.println(user.getName());
        }

//        System.out.println("ble ble bleeee");
    }
}
