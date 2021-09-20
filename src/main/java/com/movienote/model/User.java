package com.movienote.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

/**
 * Объект представляющий пользователя
 * @autor Ilkevich Anastasiya
 * @version 1.0
 *
 * НЕ ЗНАЮ КАК В ТАБЛИЦУ users_has_movies СОЗДАТЬ ПОЛЯ "description", "rating",
 * "created_timastamp" и "modefied_timastamp"
 *
 */

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
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

    @Transient
    private String passwordConfirm;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_has_roles", joinColumns = @JoinColumn(name = "users_id"),
            inverseJoinColumns = @JoinColumn(name = "roles_id"))
    private Set<Role> roles;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "users_has_movies", joinColumns = @JoinColumn(name = "users_id"),
            inverseJoinColumns = @JoinColumn(name = "movies_id"))
    private Set<Movie> movies;

}
