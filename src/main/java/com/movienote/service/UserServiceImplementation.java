
package com.movienote.service;


import com.movienote.model.Role;
import com.movienote.model.User;
import com.movienote.repository.RoleJpaRepository;
import com.movienote.repository.UserJpaRepository;
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

@Transactional
@Service
public class UserServiceImplementation implements UserService {

    private final UserJpaRepository userJpaRepository;

    private final RoleJpaRepository roleJpaRepository;

    public UserServiceImplementation(UserJpaRepository userJpaRepository, RoleJpaRepository roleJpaRepository) {
        this.userJpaRepository = userJpaRepository;
        this.roleJpaRepository = roleJpaRepository;
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

        userJpaRepository.save(user);
    }

    @Override
    public User change(User user) {

        return userJpaRepository.save(user);

    }

    @Override
    public void delete(Long id) {

        userJpaRepository.deleteById(id);

    }
}
