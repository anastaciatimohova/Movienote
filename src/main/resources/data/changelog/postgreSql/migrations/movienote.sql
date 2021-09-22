DROP SCHEMA IF EXISTS movienote;



CREATE SCHEMA IF NOT EXISTS movienote;

CREATE TABLE IF NOT EXISTS users(
    id       SERIAL PRIMARY KEY NOT NULL,
    username VARCHAR(255)       NOT NULL UNIQUE,
    email    VARCHAR(255)       NOT NULL UNIQUE,
    password VARCHAR(255)       NOT NULL
);

CREATE TABLE IF NOT EXISTS roles(
    id       SERIAL PRIMARY KEY NOT NULL,
    name     VARCHAR(225)       NOT NULL
);

CREATE TABLE IF NOT EXISTS status(
    id    SERIAL PRIMARY KEY NOT NULL,
    name VARCHAR(245)       NOT NULL
);

CREATE TABLE IF NOT EXISTS genres(
    id          SERIAL PRIMARY KEY NOT NULL,
    name        VARCHAR(245)       NOT NULL UNIQUE,
    external_id BIGINT             NOT NULL
);

CREATE TABLE IF NOT EXISTS movies(
    id                SERIAL PRIMARY KEY NOT NULL,
    adult             BOOLEAN            NOT NULL,
    poster            BYTEA               NOT NULL,
    original_language VARCHAR(45)        NOT NULL,
    original_title    VARCHAR(1245)      NOT NULL,
    overview          VARCHAR(1245)      NOT NULL,
    external_id       BIGINT             NOT NULL
);

CREATE TABLE IF NOT EXISTS user_movies(
    id                SERIAL PRIMARY KEY NOT NULL,
    user_id           BIGINT              NOT NULL,
    description        TEXT               NULL,
    rating             INT                NULL,
    status_id          BIGINT             NOT NULL,
    movie_id          BIGINT             NOT NULL UNIQUE,
    created_timestamp  TIMESTAMP          NOT NULL,
    modefied_timestamp TIMESTAMP          NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users (id),
    FOREIGN KEY (status_id) REFERENCES status (id),
    FOREIGN KEY (movie_id) REFERENCES movies (id)
    ON DELETE CASCADE
    );

CREATE TABLE IF NOT EXISTS user_roles(
   user_id BIGINT,
   role_id BIGINT,
   FOREIGN KEY (user_id) REFERENCES users (id),
   FOREIGN KEY (role_id) REFERENCES roles (id)
        ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS movie_genres(
    movie_id BIGINT NOT NULL,
    genre_id BIGINT NOT NULL,
    FOREIGN KEY (movie_id) REFERENCES movies (id),
    FOREIGN KEY (genre_id) REFERENCES genres (id)
        ON DELETE CASCADE
);

