package com.infoshareacademy.searchengine.searchengine.dao;

import com.infoshareacademy.searchengine.searchengine.domain.User;

import javax.ejb.Local;
import java.util.List;

@Local
public interface UsersRepositoryDao {

    abstract void addUser(User user);
    abstract User getUserById(int id);
    abstract User getUserByLogin(String login);
    abstract List getUsersList();
}
