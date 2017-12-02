package com.infoshareacademy.searchengine.searchengine.dao;

import com.infoshareacademy.searchengine.searchengine.domain.User;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface UsersRepositoryDaoRemote {

    List<String> getUsersNames();

}
