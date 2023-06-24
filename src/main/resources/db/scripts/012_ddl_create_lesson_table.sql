create table if not exists lesson(
    id serial primary key,
    lesson_date date,
    number int,
    name varchar(256) UNIQUE,
    subject_id int references subject(id),
    teacher_id int references teacher(id),
    school_class_id int references school_class(id)
);

comment on table lesson is 'Таблица уроков';
comment on column lesson.id is 'Идентификатор';
comment on column lesson.lesson_date is 'Дата проведения';
comment on column lesson.number is 'Номер урока в расписании по порядку проведения';
comment on column lesson.name is 'Название';
comment on column lesson.subject_id is 'Предмет';
comment on column lesson.teacher_id is 'Учитель';
comment on column lesson.school_class_id is 'Класс';