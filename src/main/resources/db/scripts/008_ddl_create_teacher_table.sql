  CREATE TABLE if not exists teacher (
    id serial primary key,
    first_name varchar(256),
    last_name varchar(256),
    user_id int references users(id)
);