create table lesson(
    id serial primary key,
    subject_id int references subject(id),
    teacher_id int references teacher(id),
    school_class_id int references school_class(id)
)