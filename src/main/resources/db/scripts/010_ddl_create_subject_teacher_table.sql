CREATE TABLE if not exists subject_teacher(
    id serial primary key,
    subject_id int not null references subject(id),
    teacher_id int not null references teacher(id)
);