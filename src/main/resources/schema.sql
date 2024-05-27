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
    VARCHAR
(
    180
) NOT NULL,
    price INT NOT NULL
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
    VARCHAR
(
    180
) NOT NULL,
    location VARCHAR
(
    255
) NOT NULL
    );