CREATE TABLE tshorts (
    id          UUID            NOT NULL PRIMARY KEY,
    prize       INT,
    material    VARCHAR(255),
    density     INT,
    style       VARCHAR(255),
    size        VARCHAR(255),
    quantity    VARCHAR(255),
    temperature INT,
    color       VARCHAR(255),
    image       VARCHAR(255),
    description VARCHAR(255)
);