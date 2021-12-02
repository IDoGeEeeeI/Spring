DROP TABLE products IF EXISTS;
CREATE TABLE IF NOT EXISTS products (id bigserial, cost int, title VARCHAR(255), PRIMARY KEY (id));
INSERT INTO products (titel, cost)VALUES ('apple', 80),('orange', 80),('milk', 80);

DROP TABLE users IF EXISTS;
CREATE TABLE IF NOT EXISTS users (id bigserial, score int, name VARCHAR(255), PRIMARY KEY (id));
INSERT INTO users (name, score) VALUES ('Bob', 80), ('Jack', 80), ('John', 80);