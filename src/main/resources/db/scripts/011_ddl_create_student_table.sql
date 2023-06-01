  CREATE TABLE if not exists student (
    id serial primary key,
    first_name varchar(256),
    last_name varchar(256),
    class_id int references school_class(id),
    user_id int references users(id)
);