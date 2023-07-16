CREATE TABLE carts (
    id              UUID            NOT NULL PRIMARY KEY,
    date_placed     TIMESTAMP,
    order_status    VARCHAR(255),
    products        TEXT ARRAY
);