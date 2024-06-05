DROP
    DATABASE IF EXISTS coffee_manager;

CREATE
    DATABASE IF NOT EXISTS coffee_manager;

USE
    coffee_manager;

CREATE TABLE IF NOT EXISTS coffee
(
    id
          INT
                       NOT
                           NULL
        AUTO_INCREMENT
        PRIMARY
            KEY,
    name
          VARCHAR(180) NOT NULL,
    price INT          NOT NULL
);

CREATE TABLE IF NOT EXISTS store
(
    id
             INT
                          NOT
                              NULL
        AUTO_INCREMENT
        PRIMARY
            KEY,
    name
             VARCHAR(180) NOT NULL,
    location VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS employee
(
    id
              INT
                          NOT
                              NULL
        AUTO_INCREMENT
        PRIMARY
            KEY,
    first_name
              VARCHAR(80) NOT NULL,
    last_name VARCHAR(80) NOT NULL,
    age       INT         NOT NULL,
    salary    FLOAT       NOT NULL,
    store_id  INT,
    FOREIGN KEY (store_id) REFERENCES store (id)
);

CREATE TABLE IF NOT EXISTS store_coffees
(
    stores_id  INT,
    coffees_id INT,
    FOREIGN KEY (stores_id) REFERENCES store (id),
    FOREIGN KEY (coffees_id) REFERENCES coffee (id)
)
