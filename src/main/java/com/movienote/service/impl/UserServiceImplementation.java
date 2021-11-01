
package com.movienote.service.impl;


import com.movienote.model.Role;
import com.movienote.model.User;
import com.movienote.repository.RoleJpaRepository;
import com.movienote.repository.UserJpaRepository;
import com.movienote.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Реализация interface UserService
 *
 * @version 1.0
 * @autor Ilkevich Anastasiya
 */

@Slf4j
@Transactional
@Service
public class UserServiceImplementation implements UserService {

    private final UserJpaRepository userJpaRepository;

    private final RoleJpaRepository roleJpaRepository;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserServiceImplementation(UserJpaRepository userJpaRepository, RoleJpaRepository roleJpaRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userJpaRepository = userJpaRepository;
        this.roleJpaRepository = roleJpaRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }


    @Override
    public List<User> getAll() {

        return userJpaRepository.findAll();

    }

    @Override
    public User getByName(String username) {

        return userJpaRepository.findByUsername(username);

    }

    @Override
    public void save(User user) {

        Set<Role> roles = new HashSet<>();
        roles.add(roleJpaRepository.getByName("ROLE_USER"));
        user.setRoles(roles);

        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));

        userJpaRepository.save(user);

        log.info("save new user " + user);

    }

    @Override
    public User update(User user) {

        boolean userDBId = userJpaRepository.existsById(user.getId());

        if (userDBId) {

            userJpaRepository.save(user);

            log.info("update user " + user);

        }else {

            log.warn("user with such id does not exist " + user);

        }
        return user;
    }

    @Override
    public void delete(Long id) {

        userJpaRepository.deleteById(id);

        log.info("delete user by ID - " + id);

    }
}
