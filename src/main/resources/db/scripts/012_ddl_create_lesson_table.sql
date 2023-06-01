create table if not exists lesson(
    id serial primary key,
    number int,
    name varchar(256) UNIQUE,
    subject_id int references subject(id),
    teacher_id int references teacher(id),
    school_class_id int references school_class(id)
);