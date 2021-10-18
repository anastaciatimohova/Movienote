package com.movienote.service;

import com.movienote.model.User;

import java.util.List;

/**
 * Сервис для сущности User
 *
 * @version 1.0
 * @autor Ilkevich Anastasiya
 */


public interface UserService {


    List<User> getAll();

    User getByName(String username);

    void save(User user);

    User update(User user);

    void delete (Long id);

}
