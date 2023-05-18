  CREATE TABLE student (
    id serial primary key not null,
    name varchar(256),
    class_id int references id(school_class)
);