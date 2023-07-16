CREATE TABLE shoppers (
    id              UUID            NOT NULL PRIMARY KEY,
    prize           INT,
    size            VARCHAR(255),
    textile         VARCHAR(255),
    handles_length  INT,
    quantity        INT,
    description     VARCHAR(255)
);