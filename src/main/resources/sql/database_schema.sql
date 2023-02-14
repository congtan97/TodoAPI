DROP TABLE IF EXISTS users, todos;

CREATE TABLE users
(
    id SERIAL PRIMARY KEY,
    first_name varchar NOT NULL,
    last_name varchar NOT NULL,
    email varchar NOT NULL ,
    username varchar NOT NULL,
    password varchar(12) NOT NULL,
    created_at TIMESTAMP,
    updated_at TIMESTAMP
);

CREATE TABLE todos
(
    id SERIAL PRIMARY KEY,
    title varchar NOT NULL,
    content varchar NOT NULL,
    status BOOLEAN NOT NULL,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP,
    due_date TIMESTAMP,
    user_id INT NOT NULL,
    CONSTRAINT fk_user
        FOREIGN KEY(user_id)
            REFERENCES users(id)
);