create table if not exists users(
    id serial primary key,
    first_name varchar(255),
    last_name varchar(255),
    email varchar(255),
    login varchar(255),
    password varchar(255),
    confirmed boolean not null
);