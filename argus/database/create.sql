CREATE DATABASE IF NOT EXISTS argus;

CREATE Table IF NOT EXISTS buildings(
    id INT not NULL PRIMARY key AUTO_INCREMENT,
    city VARCHAR(50),
    address VARCHAR(50),
    busage VARCHAR(50),
    size int,
    price double
);