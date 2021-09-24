package com.movienote.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

/**
 * Объект представляющий пользователя
 * @autor Ilkevich Anastasiya
 * @version 1.0
 */

@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    @OneToMany (cascade = CascadeType.ALL, mappedBy="user")
    private Set<UserMovies> UserMovie;
}
