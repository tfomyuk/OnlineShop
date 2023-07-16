CREATE TABLE cups (
    id          UUID            NOT NULL PRIMARY KEY,
    prize       INT,
    type        VARCHAR(255),
    kind        VARCHAR(255),
    color       VARCHAR(255),
    surface     VARCHAR(255),
    shape       VARCHAR(255),
    material    VARCHAR(255),
    capacity    INT,
    diameter    INT,
    image       VARCHAR(255),
    description VARCHAR(255)
);