create table mark (
    id serial primary key,
    score_id int references score(id),
    student_id int references student(id),
    subject_id int references subject(id),
    teacher_id int references teacher(id)
)