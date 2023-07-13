CREATE TABLE roles
(
    id UUID NOT NULL,
    name VARCHAR(250) NOT NULL,
    CONSTRAINT pk_roles PRIMARY KEY (id)
);

CREATE TABLE user_roles
(
   role_id UUID NOT NULL REFERENCES roles(id),
   user_id UUID NOT NULL REFERENCES users(id),
   PRIMARY KEY (role_id, user_id)
);