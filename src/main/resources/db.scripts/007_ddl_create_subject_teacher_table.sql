CREATE TABLE subject_teacher(
    id serial primary key,
    subject_id int not null refererences teacher(id),
    teacher_id int not null references subject(id)
)