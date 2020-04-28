-- *for Windows
-- \! chcp 1251

-- *for Linux
-- sudo -i -u postgres
-- psql

-- *new password for user postgres
-- ALTER USER postgres PASSWORD 'admin';

-- DROP SCHEMA IF EXISTS time_controller;
-- CREATE SCHEMA time_controller;
--
-- SET search_path TO time_controller;

DROP TABLE IF EXISTS users CASCADE;
CREATE TABLE users
(
    id         bigserial,
    phone      VARCHAR(15) NOT NULL UNIQUE,
    password   varchar(80),
    email      VARCHAR(50) NOT NULL UNIQUE,
    first_name VARCHAR(50),
    last_name  VARCHAR(50),
    PRIMARY KEY (id)
);
-- SELECT * FROM users;

DROP TABLE IF EXISTS roles CASCADE;
CREATE TABLE roles
(
    id   serial,
    name VARCHAR(50) NOT NULL,
    PRIMARY KEY (id)
);
-- SELECT * FROM roles;

DROP TABLE IF EXISTS users_roles CASCADE;
CREATE TABLE users_roles
(
    user_id INT NOT NULL,
    role_id INT NOT NULL,
    PRIMARY KEY (user_id, role_id),
    FOREIGN KEY (user_id)
        REFERENCES users (id),
    FOREIGN KEY (role_id)
        REFERENCES roles (id)
);
-- SELECT * FROM users_roles;

INSERT INTO roles (name)
VALUES ('ROLE_USER'),
       ('ROLE_ADMIN');

INSERT INTO users (phone, password, first_name, last_name, email)
VALUES ('88888888', '$2a$04$Fx/SX9.BAvtPlMyIIqqFx.hLY2Xp8nnhpzvEEVINvVpwIPbA3v/.i', 'Admin', 'Admin', 'admin@gmail.com'),
       ('66666666', '$2a$04$Fx/SX9.BAvtPlMyIIqqFx.hLY2Xp8nnhpzvEEVINvVpwIPbA3v/.i', 'User', 'User', 'user@gmail.com');
-- password 100

INSERT INTO users_roles (user_id, role_id)
VALUES (1, 1),
       (1, 2),
       (2, 1);
