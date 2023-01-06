DROP TABLE IF EXISTS users, todos;

CREATE TABLE users
(
    id SERIAL PRIMARY KEY,
    username varchar NOT NULL,
    password varchar(12) NOT NULL
);

CREATE TABLE todos
(
    id SERIAL PRIMARY KEY,
    title varchar NOT NULL,
    content varchar NOT NULL,
    user_id INT NOT NULL,
    CONSTRAINT fk_user
        FOREIGN KEY(user_id)
            REFERENCES users(id)
);