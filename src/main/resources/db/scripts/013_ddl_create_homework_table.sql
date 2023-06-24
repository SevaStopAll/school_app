CREATE TABLE if not exists homework (
    id serial primary key,
    description varchar(1024),
    lesson_id int references lesson(id),
    subject_id int references subject(id),
    school_class_id int references school_class(id)
);

comment on table homework is 'Таблица домашних заданий';
comment on column homework.id is 'Идентификатор';
comment on column homework.description is 'Описание';
comment on column homework.lesson_id is 'Во время какого урока было задано';
comment on column homework.subject_id is 'Предмет';
comment on column homework.school_class_id is 'Класс';
