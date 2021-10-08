package com.movienote.service;


import com.movienote.model.Status;

import java.util.List;

/**
 * Сервис для сущности Status
 *
 * @version 1.0
 * @autor Ilkevich Anastasiya
 */


public interface StatusService {

    List<Status> getAll();

    Status getByName(String name);

    void save(String name);

    Status change(Status status);

    void delete(Long id);
}
