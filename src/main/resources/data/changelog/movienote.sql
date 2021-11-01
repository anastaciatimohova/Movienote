CREATE TABLE genres
(
    id BIGSERIAL NOT NULL,
    name varchar(100),
    external_id varchar(100)
);

ALTER TABLE genres ADD CONSTRAINT pk_genres
    PRIMARY KEY (id);

CREATE TABLE movie_genres
(
    movie_id bigint  NOT NULL,
    genre_id bigint NOT NULL
);

CREATE TABLE movies
(
    id BIGSERIAL NOT NULL,
    adult boolean,
    backdrop_path varchar(255),
    language varchar(45),
    title text,
    overview text,
    external_id bigint NOT NULL
);

ALTER TABLE movies ADD CONSTRAINT pk_movies
    PRIMARY KEY (id);

CREATE TABLE roles
(
    id BIGSERIAL  NOT NULL,
    name varchar(20) NOT NULL
);

ALTER TABLE roles ADD CONSTRAINT pk_role
    PRIMARY KEY (id);

CREATE TABLE user_movies
(
    id BIGSERIAL NOT NULL,
    user_id bigint NOT NULL,
    movie_id bigint NOT NULL,
    status INT NOT NULL DEFAULT 1,
    description text,
    rating integer,
    created_timestamp timestamp DEFAULT NOW(),
    updated_timestamp timestamp DEFAULT NOW()
);

ALTER TABLE user_movies ADD CONSTRAINT pk_user_movies
    PRIMARY KEY (id);

CREATE TABLE user_roles
(
    user_id bigint NOT NULL,
    role_id bigint NOT NULL
);

CREATE TABLE users
(
    id BIGSERIAL NOT NULL,
    username varchar(25) NOT NULL UNIQUE,
    email varchar(40) NOT NULL UNIQUE,
    password varchar(255) NOT NULL
);

ALTER TABLE users ADD CONSTRAINT pk_user
    PRIMARY KEY (id);

ALTER TABLE movie_genres ADD CONSTRAINT fk_movie_genres_genre
    FOREIGN KEY (genre_id) REFERENCES genres (id) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE movie_genres ADD CONSTRAINT fk_movie_genres_movie
    FOREIGN KEY (movie_id) REFERENCES movies (id) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE user_movies ADD CONSTRAINT fk_user_movies_user
    FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE user_movies ADD CONSTRAINT fk_user_movies_movie
    FOREIGN KEY (movie_id) REFERENCES movies (id) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE user_roles ADD CONSTRAINT fk_user_roles_role
    FOREIGN KEY (role_id) REFERENCES roles (id) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE user_roles ADD CONSTRAINT fk_user_roles_user
    FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE ON UPDATE CASCADE;

INSERT INTO roles
VALUES (1, 'ROLE_USER');

INSERT INTO roles
VALUES (2, 'ROLE_ADMIN');