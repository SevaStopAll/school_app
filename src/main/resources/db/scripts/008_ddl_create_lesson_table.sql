create table if not exists lesson(
    id serial primary key,
    name varchar(256),
    subject_id int references subject(id),
    teacher_id int references teacher(id),
    school_class_id int references school_class(id)
)