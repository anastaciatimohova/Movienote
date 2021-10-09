
package com.movienote.service;

import com.movienote.model.Status;
import com.movienote.repository.StatusJpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * Реализация interface StatusService
 *
 * @version 1.0
 * @autor Ilkevich Anastasiya
 */

@Transactional
@Service
public class StatusServiceImplementation implements StatusService {

    private final StatusJpaRepository statusJpaRepository;

    public StatusServiceImplementation(StatusJpaRepository statusJpaRepository) {
        this.statusJpaRepository = statusJpaRepository;
    }

    @Override
    public List<Status> getAll() {

        return statusJpaRepository.findAll();

    }

    @Override
    public Status getByName(String name) {

        return statusJpaRepository.findByName(name);

    }

    @Override
    public void save(String name) {

        Status status = new Status();
        status.setName(name);
        statusJpaRepository.save(status);

    }

    @Override
    public Status change(Status status) {

        return statusJpaRepository.save(status);

    }

    @Override
    public void delete(Long id) {

        statusJpaRepository.deleteById(id);
    }


}
