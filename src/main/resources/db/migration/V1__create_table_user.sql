CREATE TABLE users (
    id UUID NOT NULL PRIMARY KEY,
    login VARCHAR(255),
    password VARCHAR(255),
    CONSTRAINT uc_users_email UNIQUE (login)
);