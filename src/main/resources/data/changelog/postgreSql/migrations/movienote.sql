DROP SCHEMA IF EXISTS movienote;


CREATE SCHEMA IF NOT EXISTS movienote;
USE movienote.public ;

CREATE TABLE IF NOT EXISTS users(
    id       BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    username VARCHAR(255)       NOT NULL UNIQUE,
    email    VARCHAR(255)       NOT NULL UNIQUE,
    password VARCHAR(255)       NOT NULL
    ) ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS roles(
    id   BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    name VARCHAR(225)       NOT NULL
    ) ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS user_roles(
    user_id BIGINT,
    role_id BIGINT,
    FOREIGN KEY (user_id) REFERENCES users (id),
    FOREIGN KEY (role_id) REFERENCES roles (id)
    ON DELETE CASCADE
    ) ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS status(
     id     BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
     status VARCHAR(245)       NOT NULL
    ) ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS genres(
    id          BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    name        VARCHAR(245)       NOT NULL UNIQUE,
    external_id BIGINT             NOT NULL
    ) ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS movies(
    id                BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    adult             BOOLEAN            NOT NULL,
    backdrop_path     BLOB               NOT NULL,
    original_language VARCHAR(45)        NOT NULL,
    original_title    VARCHAR(1245)      NOT NULL,
    overview          VARCHAR(1245)      NOT NULL,
    external_id       BIGINT             NOT NULL
    ) ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS movies_has_genres(
    movies_id BIGINT NOT NULL,
    genres_id BIGINT NOT NULL,
    FOREIGN KEY (movies_id) REFERENCES movies (id),
    FOREIGN KEY (genres_id) REFERENCES genres (id)
    ON DELETE CASCADE
    ) ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS users_has_movies(
    users_id           BIGINT PRIMARY KEY NOT NULL,
    description        TEXT               NULL,
    rating             INT                NULL,
    status_id          BIGINT             NOT NULL,
    movies_id          BIGINT             NOT NULL UNIQUE,
    created_timestamp  TIMESTAMP          NOT NULL,
    modefied_timestamp TIMESTAMP          NOT NULL,
    FOREIGN KEY (users_id) REFERENCES users (id),
    FOREIGN KEY (status_id) REFERENCES status (id),
    FOREIGN KEY (movies_id) REFERENCES movies (id)
    ON DELETE CASCADE
    ) ENGINE = InnoDB;