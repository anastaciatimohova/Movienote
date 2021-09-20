package com.movienote.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

/**
 * Объект представляющий роль для пользователя
 * @autor Ilkevich Anastasiya
 * @version 1.0
 */

@Entity
@Table(name = "roles")
@Data
@NoArgsConstructor
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "roles")
    private String role;

    @ManyToMany(mappedBy = "roles")
    private Set<User> users;

}

