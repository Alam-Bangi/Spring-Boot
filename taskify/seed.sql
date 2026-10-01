CREATE DATABASE taskify_db;

\c taskify_db

CREATE TABLE users (
  id SERIAL PRIMARY KEY,
  name VARCHAR(50),
  email VARCHAR(100) UNIQUE
);

CREATE TABLE task (
  id SERIAL PRIMARY KEY,
  name VARCHAR(50),
  completed BOOLEAN DEFAULT=false
);
