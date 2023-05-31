  CREATE TABLE if not exists teacher (
    id serial primary key,
    name varchar(256),
    user_id int references users(id)
);